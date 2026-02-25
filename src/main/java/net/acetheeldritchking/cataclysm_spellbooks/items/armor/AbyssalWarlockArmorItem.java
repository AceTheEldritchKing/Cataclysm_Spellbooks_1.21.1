package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.minecraft.world.item.ItemStack;

public class AbyssalWarlockArmorItem extends ImbuableCSArmorItem {
    public AbyssalWarlockArmorItem(Type slot, Properties settings) {
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
