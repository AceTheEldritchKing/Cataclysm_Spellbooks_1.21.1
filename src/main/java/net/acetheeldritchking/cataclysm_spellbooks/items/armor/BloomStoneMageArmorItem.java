package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class BloomStoneMageArmorItem extends ImbuableCSArmorItem {
    public BloomStoneMageArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.BOULDER_BLOSSOM_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        AttributeRegistry.NATURE_SPELL_POWER,
                        AttributeRegistry.NATURE_MAGIC_RESIST,
                        150,
                        0.2F,
                        0.05F,
                        0.1F)
        );
    }
}
