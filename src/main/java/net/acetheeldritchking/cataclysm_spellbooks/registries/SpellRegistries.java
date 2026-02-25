package net.acetheeldritchking.cataclysm_spellbooks.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.acetheeldritchking.cataclysm_spellbooks.spells.abyssal.*;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.GravitationPullSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.GravityStormSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.VoidRuneBulwarkSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ender.VoidRuneSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.evocation.PilferSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.fire.*;
import net.acetheeldritchking.cataclysm_spellbooks.spells.holy.ConjureKoboldiatorSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.holy.ConjureKoboletonSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ice.ConjureThrallsSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ice.CursedRushSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.ice.MalevolentBattlefieldSpell;
import net.acetheeldritchking.cataclysm_spellbooks.spells.nature.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, CataclysmSpellbooks.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    //        //
    // Spells //
    //        //

    /***
     * Abyssal
     */
    // Void Beam
    public static final Supplier<AbstractSpell> VOID_BEAM = registerSpell(new VoidBeamSpell());

    // Abyssal Blast (Summon Leviathan death beam)
    public static final Supplier<AbstractSpell> ABYSSAL_BLAST = registerSpell(new AbyssalBlastSpell());

    // Dimensional Rift (Summon a rift)
    public static final Supplier<AbstractSpell> DIMENSIONAL_RIFT = registerSpell(new DimensionalRiftSpell());

    // Depth Charge (Summon mines)
    public static final Supplier<AbstractSpell> DEPTH_CHARGE = registerSpell(new DepthChargeSpell());

    // Abyssal Predator (Buffs while underwater)
    public static final Supplier<AbstractSpell> ABYSSAL_PREDATOR = registerSpell(new AbyssalPredatorSpell());

    // Tidal Tear (Melee attack which ends in a shockwave)
    public static final Supplier<AbstractSpell> ABYSSAL_SLASH = registerSpell(new AbyssalSlashSpell());

    // Tidal Claw (Summons Tidal Claw that grabs target) - Requires Tidal Claw
    public static final Supplier<AbstractSpell> TIDAL_GRAB = registerSpell(new TidalGrabSpell());

    // Summon Coral Golem (Summons a few coral golem guys)

    // Summon Corallusus (Summons a singular Corallusus for you to ride)

    // Summon Lionfish Swarm (Summons a bunch of lionfish, can only be casted while in the water)

    // Conjure: Clawdian (Summons a Clawdian to fight for you)

    // Wrath of The Abyss (Apply an effect to yourself that prevents your death. This applies an effect that boosts your spell power but reduces your max health)

    //                //
    // ABYSSAL REWORK //
    //                //

    // Delta Pressure [ABYSSAL]: Evaluate the pressure between the caster and the target. If the target has less pressure than the caster, equalize the pressure and deal damage to the target based on the difference in pressure. If the caster has more pressure than the target, equalize and debuff the caster. Pressure is influenced by the gravitational attributes of the target and caster, whether the caster is in water or not, and whether the caster has the Pressurized effect.

    // Pressurize [ABYSSAL]: Increases the caster's gravity outside of water and apply the pressurized status effect.

    // Aquatic Lungs [ABYSSAL]: Grant the caster the ability to breathe underwater for a short time.

    // Whalefall [ABYSSAL]: Apply the Whalefall effect on the targeted entity. When that entity dies, creates an explosion that heals the caster and nearby entities.

    // Thermal Adaptation [ABYSSAL]: Boil the water around you, granting you increased resistance against fire spells. Can only be casted while underwater, effect clears once the caster leaves the water.

    // Abyssal Prey [ABYSSAL]: Target an entity; you deal more damage to that specific entity, however, you will deal less damage to any other entity.

    // Midnight Zone [ABYSSAL]: In a radius around the caster, inflict darkness and blindness to all entities within that radius. Can only be casted while underwater. All entities in range take more damage from Abyssal spells.

    // Aquatic Snow [ABYSSAL]: Summon aquatic snow around the caster, heals a small amount per time spent in the snow.

    // Bio-Disorient [ABYSSAL]: The caster turns transparent, gains bioluminescent, and creates copies of itself to distract targets. Can only be casted while under the water.

    // Submerge [ABYSSAL]: Greatly increase the target's pressure and gravity, increasing even more while the target is in the water.

    // Depressurize [ABYSSAL]: Target either the caster or an entity to decrease their pressure

    // Downpour/Deluge (Summons a rainstorm around the caster, entities within become conductive)

    // Riptide (Drag nearby entities into you, dealing damage to them. Only casted in water)

    // Undercurrent (Dash in the direction you are looking in. Increased power when underwater)

    // Saltwater Spray (Spray saltwater, entities caught in it become conductive)

    // Schooling (Based on the amount of fish entities near you, your abyssal spell power is increased for X amount of spells. Only works underwater)

    // Alkaline Waters (Clears all effects from the caster, negative and positive)

    // Squid Launcher (Unleash an empowered squid in the direction the caster is looking in - Apparition Maw exclusive)

    // Tide Turn (Hold a defensive stance, increasing spell resistance and clearing negative effects. After the spell finishes, spell power is increased - Lacerator exclusive)

    // Cyclone (Scylla pushing you back attack)

    // Pacific Perforator (Lightning Spear attack)

    // Serpents of The Sea (Scylla's serpents)

    // Rogue Wave (Cataclysm Wave)

    // Cavitation Bubble (Create a highly pressurized bubble, when upon hitting an entity, it creates a volatile explosion with an AoE shockwave. Scales with Fire SP - Perforator exclusive)


    /***
     * Blood
     */
    // Hemorrhaging Impact (Shoot out crystallized blood followed by several blood needles. The blood crystals, on impact, inflict bleeding & hemophilia)

    // Quick Strike (Unleash X amount of strikes with the damage incrementing per recast. Ignores i-frames)

    // Final Rend (Charge up a devastating slash. This slash deals damage based on health and inflicts strong lifesteal. Ignores i-frames & protection. Caster is given a grace period while charging. Inflicts Disabled and Severed)


    /***
     * Ender
     */
    // Void Rune (Ender)
    public static final Supplier<AbstractSpell> VOID_RUNE = registerSpell(new VoidRuneSpell());

    // Void Bulwark (Summon void rune shield around the caster)
    public static final Supplier<AbstractSpell> VOID_BULWARK = registerSpell(new VoidRuneBulwarkSpell());

    // Gravity Storm (Ender)
    public static final Supplier<AbstractSpell> GRAVITY_STORM = registerSpell(new GravityStormSpell());

    // Gravitational Pull (Pulls entities in like Gauntlet of Guard)
    public static final Supplier<AbstractSpell> GRAVITATION_PULL = registerSpell(new GravitationPullSpell());

    // Shell Smash (Envelop yourself in a thick shell, reducing damage to yourself. After X amount of hits, the shell breaks and you briefly gain speed and extra spell power for X number of attacks)

    // Quasar Burst (Wherever you look, create a vertical quasar blast that greatly damages entities caught in it - exclusive to the Obliterator)


    /***
     * Evocation
     */
    // Steal (Steals target's mainhand item)
    public static final Supplier<AbstractSpell> PILFER = registerSpell(new PilferSpell());


    /***
     * Holy
     */
    // Summon Koboldiator
    public static final Supplier<AbstractSpell> CONJURE_KOBOLDIATOR = registerSpell(new ConjureKoboldiatorSpell());

    // Summon Koboleton (Summon Koboletons)
    public static final Supplier<AbstractSpell> CONJURE_KOBOLETON = registerSpell(new ConjureKoboletonSpell());

    // Thoth's Witness (For less than a minute, summon the ghost of The Ancient Remnant to fight for you.)


    /***
     * Fire
     */
    // Incineration (Fire) (Summon Fire runes in row) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> INCINERATION = registerSpell(new IncinerationSpell());

    // Infernal Strike (Summon mini Incinerator, inflicts blazing brand) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> INFERNAL_STRIKE = registerSpell(new InfernalStrikeSpell());

    // Summon Ignited Revenant (Just as the name says) - Requires Burning Ashes (I AM NOT READY AT ALL TO DO THIS SPELL)
    public static final Supplier<AbstractSpell> CONJURE_IGNITED_REINFORCEMENT = registerSpell(new ConjureIgnitedReinforcement());

    // Hellish Blade (Summon a large Incinerator from the ground to strike and lock in a target for a short amount of time, preventing movement) - Requires Burning Ashes
    public static final Supplier<AbstractSpell> HELLISH_BLADE = registerSpell(new HellishBladeSpell());

    // Bone Storm (Sprays out blazing bones in all directions like the Revernant)
    public static final Supplier<AbstractSpell> BONE_STORM = registerSpell(new BoneStormSpell());

    // Blazing Bone Spit (Shoots out a single blazing bone)
    public static final Supplier<AbstractSpell> BONE_PIERCE = registerSpell(new BonePierceSpell());

    // Ashen Breath (Spews out ash breath in front of the caster)
    public static final Supplier<AbstractSpell> ASHEN_BREATH = registerSpell(new AshenBreathSpell());

    // Abyss Fireball (Gurl even I don't know wtf it does)
    public static final Supplier<AbstractSpell> ABYSS_FIREBALL = registerSpell(new AbyssFireballSpell());

    // Summon Ignis (April Fools spell)

    // Tectonic Tremble
    public static final Supplier<AbstractSpell> TECTONIC_TREMBLE = registerSpell(new TectonicTrembleSpell());

    // Avatar of Flame (Ignite yourself on fire, at half health you turn into soul fire and your fire spell power is increased but every other element is decreased. Prevents you from being placed on fire, all your attacks ignite opponents. Buffs to Ignis spells)

    // Infernal Inhalation (Absorb any lava blocks near you, healing you for how much lava is around you)

    // Scorched Earth (Shoot out a barrage of molten bullets that combust on the ground, igniting entities caught within)


    /***
     * Lightning
     */
    //


    /***
     * Ice
     */
    // Malevolent Battlefield (Summon Maledictus' halberd field)
    public static final Supplier<AbstractSpell> MALEVOLENT_BATTLEFIELD = registerSpell(new MalevolentBattlefieldSpell());

    // Forgone Rage (Apply Wrath effect to the user. As the user attacks, it fills a rage meter. Each level is an additional 10% extra damage)
    //public static final Supplier<AbstractSpell> FORGONE_RAGE = registerSpell(new ForgoneRageSpell());

    // Conjure Thrall (Summons the ice undead warriors)
    public static final Supplier<AbstractSpell> CONJURE_THRALL = registerSpell(new ConjureThrallsSpell());

    // Arrow Spray (Release a barrage of icy arrows. Damage increases if the user is holding a bow/crossbow)

    // Cursed Rush (Mini boss rush attack + Soul Render charge)
    public static final Supplier<AbstractSpell> CURSED_RUSH = registerSpell(new CursedRushSpell());

    // Phantom Blade (Mini boss blade attack)

    // Malicious Curse (Summons halberds that fall ontop of the target)

    // Phantasmal Slam (Summons either a custom winged entity or Maledictus to grab and slam the target)

    // Echoed Whirlwind/Snow Squall (Summons Wrath of The Desert sandstorms)

    // Summon Maledictus (April Fools spell)

    // Cryopiercer (Shoot a blast of freezing cold energy, spawning a circle of ice spikes on impact. Entities hit are encased in ice which shatters after a few seconds)


    /***
     * Nature
     */
    // Sandstorm (Summon desert tornadoes around the user)
    public static final Supplier<AbstractSpell> SANDSTORM = registerSpell(new SandstormSpell());

    // Desert Winds (Throw a desert tornado in a path in front of the user. This damages blocks)
    public static final Supplier<AbstractSpell> DESERT_WINDS = registerSpell(new DesertWindsSpell());

    // Monolith Crash (Crashes down sandstone monoliths around the caster)
    public static final Supplier<AbstractSpell> MONOLITH_CRASH = registerSpell(new MonolithCrashSpell());

    // Amethyst Puncture (Shoots out an amethyst spike)
    public static final Supplier<AbstractSpell> AMETHYST_PUNCTURE = registerSpell(new AmethystPunctureSpell());

    // Summon Amethyst Crab
    public static final Supplier<AbstractSpell> CONJURE_AMETHYST_CRAB = registerSpell(new ConjureAmethystCrabSpell());

    // Pharaoh's Wrath (Every hit you take increases your wrath. At max wrath, all of your attacks inflict the Desert's Curse effect, and summons several sandstorms around you. You gain strong debuffs afterwards)

    // Diamond Storm (Rain down amethyst chunks around the caster. Radius scales with level)

    // Scorching Sands (Spew out burning hot sand, confusing enemies and burning them)


    /***
     * Technomancy
     */
    // EMP (Cast an emp blast?)

    // Lock-on (Summon a target particle above the entity's head, stuns and incapacitates them for a few seconds)

    // Hijack (Steals a target's summons for yourself)

    // Laserbolt (Shoots out the little Harbinger small laser)

    // Atomic Laser (Harbinger big laser blast)

    // DoS Swarm (Summons a swarm of Watchers that act as a counterspell projectiles)

    // Missile Launch (Shoots out a missile)

    // Construct: Watchers (Summons a group of Watchers)

    // Construct: Prowler (Summons a Prowler)

    // DDoS (AoE counterspell)

    // Shutdown (Prevent the target from attacking or using items. Does not stack with Lock-on)

    // Rewire (Buff selected summons' speed and damage, reducing their armor and armor toughness)

    // Hardware Update (Increases your damage and armor, does not stack with charge/clears it)

    // Software Update (Increases your speed and cooldown, does not stack with charge and haste/clears it)

    // Bothearder (AoE summon steal)

    // Flash Bang (Throw a live grenade, blinding nearby entities within the blast zone)

    // Aerial Assault (Summon various missiles down from the sky)

    // Intrusion Prevention System (Reduce all incoming projectile damage, prevent summons from being counterspelled)

    // Overclock (Special imbue on Excelsius armor, overclock the caster which unlocks more capabilities and stats from the armor)

    // Parting Shot (Exclusive to The Subjugator, shoots out two shots that inflict Wither)

    // Disabling Swipe (Charge up a slash attack, the swipe prevents hit entities from healing)

    // Gear Shift (A multicast movement spell, dash forwards when standing and upwards when crouching)

    // Reboot (Heals the caster and any nearby summons)

    // Surveillance Drone (Summons a drone on top of your selected summon, healing nearby summons and clearing any negative status effects)

    // R.A.I.D Backup (Creates a backup of your health and stats. Each spell level allows you more stats to back up (1 = HP, 2 = Location, 3 = Potion Effects))

    // Exploitation (Evaluates the stats of the target. Based on those stats, grant a debuff targeting one of them)

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
