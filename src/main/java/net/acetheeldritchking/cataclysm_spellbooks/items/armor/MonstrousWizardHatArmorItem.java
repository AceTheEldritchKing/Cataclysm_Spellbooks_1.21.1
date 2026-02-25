package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MonstrousWizardHatArmorItem extends ImbuableCSArmorItem {
    public MonstrousWizardHatArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.CURSIUM_WARLOCK_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        AttributeRegistry.FIRE_SPELL_POWER,
                        AttributeRegistry.SPELL_RESIST,
                        150,
                        0.15F,
                        0.05F,
                        0.05F)
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("item.cataclysm.monstrous_helm.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.monstrous_helm2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}
