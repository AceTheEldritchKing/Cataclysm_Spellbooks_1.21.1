package net.acetheeldritchking.cataclysm_spellbooks.registries;

import com.mojang.serialization.Codec;
import net.acetheeldritchking.cataclysm_spellbooks.CataclysmSpellbooks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class CSAttachmentRegistry {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, CataclysmSpellbooks.MOD_ID);

    // Forgone Rage
    public static final Supplier<AttachmentType<Integer>> FORGONE_RAGE = ATTACHMENT_TYPES.register(
            "forgone_rage", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());

    // King's Wrath
    public static final Supplier<AttachmentType<Integer>> KINGS_WRATH = ATTACHMENT_TYPES.register(
            "kings_wrath", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());

    public static void register(IEventBus eventBus)
    {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
