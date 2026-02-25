package net.acetheeldritchking.cataclysm_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IgnisWizardArmorItem extends ImbuableCSArmorItem{
    public IgnisWizardArmorItem(Type slot, Properties settings) {
        super(CSArmorMaterialRegistry.IGNITIUM_WIZARD_ARMOR, slot, settings,
                schoolAttributesWithResistance(
                        AttributeRegistry.FIRE_SPELL_POWER,
                        AttributeRegistry.FIRE_MAGIC_RESIST,
                        150,
                        0.2F,
                        0.05F,
                        0.1F)
        );
    }

    // Using the same stuff as Cataclysm for tooltips
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        if (this.type == Type.HELMET) {
            pTooltipComponents.add(Component.translatable("item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.CHESTPLATE) {
            pTooltipComponents.add(Component.translatable("item.cataclysm.ignitium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.LEGGINGS) {
            pTooltipComponents.add(Component.translatable("item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.BOOTS) {
            pTooltipComponents.add(Component.translatable("item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}
