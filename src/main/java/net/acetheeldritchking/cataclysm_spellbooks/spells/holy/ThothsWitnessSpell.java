package net.acetheeldritchking.cataclysm_spellbooks.spells.holy;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.capabilities.magic.*;
import io.redspace.ironsspellbooks.entity.spells.EarthquakeAoe;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import net.acetheeldritchking.aces_spell_utils.spells.ASSpellAnimations;
import net.acetheeldritchking.aces_spell_utils.utils.ASUtils;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedKoboldiator;
import net.acetheeldritchking.cataclysm_spellbooks.entity.mobs.SummonedPhantomRemnant;
import net.acetheeldritchking.cataclysm_spellbooks.registries.ItemRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class ThothsWitnessSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(CataclysmSpellbooks.MOD_ID, "thoths_witness");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.cataclysm_spellbooks.remnant_count", spellLevel));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.HOLY_RESOURCE)
            .setMaxLevel(1)
            // 600 secs
            .setCooldownSeconds(600)
            .build();

    public ThothsWitnessSpell()
    {
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 5;
        this.castTime = 100;
        this.baseManaCost = 650;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public CastResult canBeCastedBy(int spellLevel, CastSource castSource, MagicData playerMagicData, Player player) {
        if (castSource == CastSource.SCROLL)
        {
            return new CastResult(CastResult.Type.FAILURE, Component.translatable("ui.cataclysm_spellbooks.thoths_witness_scroll_failure", new Object[]{this.getDisplayName(player)}).withStyle(ChatFormatting.RED));
        }
        if (
                !player.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistries.PHARAOH_MAGE_HELMET.get())
                        && !player.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistries.PHARAOH_MAGE_CHESTPLATE.get())
                        && !player.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistries.PHARAOH_MAGE_LEGGINGS.get())
                        && !player.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistries.PHARAOH_MAGE_BOOTS.get())
        )
        {
            return new CastResult(CastResult.Type.FAILURE, Component.translatable("ui.cataclysm_spellbooks.thoths_witness_armor_failure", new Object[]{this.getDisplayName(player)}).withStyle(ChatFormatting.RED));
        }
        return super.canBeCastedBy(spellLevel, castSource, playerMagicData, player);
    }

    @Override
    public boolean canBeCraftedBy(Player player) {
        return false;
    }

    @Override
    public boolean allowLooting() {
        return false;
    }

    @Override
    public boolean allowCrafting() {
        return false;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return ASSpellAnimations.ANIMATION_MALEVOLENT_HAND_SIGN;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return ASSpellAnimations.ANIMATION_MALEVOLENT_HAND_SIGN_RELEASE;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.BELL_BLOCK);
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(ModSounds.REMNANT_ROAR.get());
    }

    @Override
    public void onServerPreCast(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        // Let the ground tremble!!
        EarthquakeAoe aoe = new EarthquakeAoe(level);
        aoe.moveTo(entity.position());
        aoe.setOwner(entity);
        aoe.setCircular();
        aoe.setRadius(10);
        aoe.setDuration(getCastTime(spellLevel));
        aoe.setDamage(0);
        aoe.setSlownessAmplifier(0);

        level.addFreshEntity(aoe);

        super.onServerPreCast(level, spellLevel, entity, playerMagicData);
    }

    @Override
    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        float random = 0.04F;

        float r = 0.89F + entity.getRandom().nextFloat() * random;
        float g = 0.85F + entity.getRandom().nextFloat() * random;
        float b = 0.69F + entity.getRandom().nextFloat() * random * 1.5F;

        MagicManager.spawnParticles(level, new StormParticleOptions(r, g, b, 2.75F + entity.getRandom().nextFloat() * 0.6F, 3.75F + entity.getRandom().nextFloat() * 0.6F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
        MagicManager.spawnParticles(level, new StormParticleOptions(r, g, b, 2.5F + entity.getRandom().nextFloat() * 0.45F, 3.0F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
        MagicManager.spawnParticles(level, new StormParticleOptions(r, g, b, 2.25F + entity.getRandom().nextFloat() * 0.45F, 2.25F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
        MagicManager.spawnParticles(level, new StormParticleOptions(r, g, b, 1.25F + entity.getRandom().nextFloat() * 0.45F, 1.25F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);

        if (entity.tickCount % 10 == 0)
        {
            ASUtils.spawnParticlesInRing(16, 1.25f, 2.25f, 3.25f, 0.5F, 0.1F, entity, ModParticle.DUST_BLAST.get());
        }

        super.onServerCastTick(level, spellLevel, entity, playerMagicData);
    }

    @Override
    public void onClientPreCast(Level level, int spellLevel, LivingEntity entity, InteractionHand hand, @Nullable MagicData playerMagicData) {
        super.onClientPreCast(level, spellLevel, entity, hand, playerMagicData);
    }

    @Override
    public int getRecastCount(int spellLevel, @Nullable LivingEntity entity) {
        return 2;
    }

    @Override
    public void onRecastFinished(ServerPlayer serverPlayer, RecastInstance recastInstance, RecastResult recastResult, ICastDataSerializable castDataSerializable) {
        if (SummonManager.recastFinishedHelper(serverPlayer, recastInstance, recastResult, castDataSerializable)) {
            super.onRecastFinished(serverPlayer, recastInstance, recastResult, castDataSerializable);
        }
    }

    @Override
    public ICastDataSerializable getEmptyCastData() {
        return new SummonedEntitiesCastData();
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        PlayerRecasts recasts = playerMagicData.getPlayerRecasts();

        if (!recasts.hasRecastForSpell(this))
        {
            SummonedEntitiesCastData summonedEntitiesCastData = new SummonedEntitiesCastData();
            // Only is around for 45 seconds
            int summonTimer = 1200;

            for (int i = 0; i < spellLevel; i++)
            {
                Vec3 vec = entity.getEyePosition();

                double randomNearbyX = vec.x + entity.getRandom().nextGaussian() * 3;
                double randomNearbyZ = vec.z + entity.getRandom().nextGaussian() * 3;

                spawnPhantomRemnant(randomNearbyX, vec.y, randomNearbyZ, entity, level, summonTimer, spellLevel, summonedEntitiesCastData);
            }

            RecastInstance recastInstance = new RecastInstance(this.getSpellId(), spellLevel, getRecastCount(spellLevel, entity), summonTimer, castSource, summonedEntitiesCastData);
            recasts.addRecast(recastInstance, playerMagicData);
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private void spawnPhantomRemnant(double x, double y, double z, LivingEntity caster, Level level, int summonTimer, int spellLevel, SummonedEntitiesCastData castData)
    {
        SummonedPhantomRemnant kobolediator = new SummonedPhantomRemnant(level, caster);

        var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<>(caster, kobolediator, this.spellId, spellLevel)).getCreature();

        kobolediator.moveTo(x, y, z);

        level.addFreshEntity(event);

        SummonManager.initSummon(caster, event, summonTimer, castData);
    }
}
