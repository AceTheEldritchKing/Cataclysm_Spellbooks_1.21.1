package net.acetheeldritchking.cataclysm_spellbooks.effects.potion;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModParticle;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.EffectCure;

import java.util.Set;

public class KingsWrathPotionEffect extends MagicMobEffect {
    public KingsWrathPotionEffect() {
        super(MobEffectCategory.BENEFICIAL, 4583645);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, CataclysmSpellbooks.id("kings_wrath_effect"), KingsWrathPotionEffect.ATTACK_DAMAGE_PER_WRATH, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.SPELL_POWER, CataclysmSpellbooks.id("kings_wrath_effect"), KingsWrathPotionEffect.SPELL_POWER_PER_WRATH, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        //this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "f3ebfd1c-ae19-4802-aa8e-e5cd04ad197b", WrathfulPotionEffect.ATTACK_DAMAGE_PER_WRATH, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public static final float ATTACK_DAMAGE_PER_WRATH = 0.20f;
    public static final float SPELL_POWER_PER_WRATH = 0.05f;

    @Override
    public boolean applyEffectTick(LivingEntity entity, int pAmplifier) {
        if (!entity.level().isClientSide)
        {
            ServerLevel world = (ServerLevel) entity.level();

            float random = 0.04F;

            float r = 0.89F + entity.getRandom().nextFloat() * random;
            float g = 0.85F + entity.getRandom().nextFloat() * random;
            float b = 0.69F + entity.getRandom().nextFloat() * random * 1.5F;

            MagicManager.spawnParticles(world, new StormParticleOptions(r, g, b, 2.75F + entity.getRandom().nextFloat() * 0.6F, 3.75F + entity.getRandom().nextFloat() * 0.6F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
            MagicManager.spawnParticles(world, new StormParticleOptions(r, g, b, 2.5F + entity.getRandom().nextFloat() * 0.45F, 3.0F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
            MagicManager.spawnParticles(world, new StormParticleOptions(r, g, b, 2.25F + entity.getRandom().nextFloat() * 0.45F, 2.25F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
            MagicManager.spawnParticles(world, new StormParticleOptions(r, g, b, 1.25F + entity.getRandom().nextFloat() * 0.45F, 1.25F + entity.getRandom().nextFloat() * 0.45F, entity.getId()), entity.getX(), entity.getY(), entity.getZ(), 1, 0, 0, 0, 1, true);
        }

        return super.applyEffectTick(entity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 2 == 0;
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        // If you're reading this, HAIIII!! XD X3 >:3c
    }
}
