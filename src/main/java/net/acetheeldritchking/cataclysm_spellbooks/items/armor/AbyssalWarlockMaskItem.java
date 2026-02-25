package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class AbyssalWarlockMaskItem extends ImbuableCSArmorItem {
    public AbyssalWarlockMaskItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.ABYSSAL_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        CSAttributeRegistry.ABYSSAL_MAGIC_POWER,
                        CSAttributeRegistry.ABYSSAL_MAGIC_RESIST,
                        150,
                        0.2F,
                        0.05F,
                        0.1F)
        );
    }
}
