package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class PharaohMageArmorItem extends ImbuableCSArmorItem {
    public PharaohMageArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.CURSIUM_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        AttributeRegistry.NATURE_SPELL_POWER,
                        AttributeRegistry.HOLY_SPELL_POWER,
                        150,
                        0.2F,
                        0.05F,
                        0.2F)
        );
    }
}
