package net.acetheeldritchking.cataclysm_spellbooks.entity.render.mobs.phantom_remnant;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ancient_Remnant_Rework_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Ancient_Remnant_Rework_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.render.RenderHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;

public class AncientRemnantTransLayer extends RenderLayer<Ancient_Remnant_Entity, Ancient_Remnant_Rework_Model> {
    private static final ResourceLocation LAYER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/entity/ancient_remnant/ancient_remnant.png");

    public AncientRemnantTransLayer(Ancient_Remnant_Rework_Renderer renderIn) {
        super(renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ancient_Remnant_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        /*RenderType translucent = RenderType.entityTranslucentEmissive(LAYER_TEXTURES, false);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(translucent);
        (this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, RenderHelper.colorf(0.5F, 0.7F, 0.9F));//0.5F, 0.7F, 0.9F, 0.4F);*/

        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(LAYER_TEXTURES));
        float hide = entity.getHealth() / entity.getMaxHealth() - 0.4F;
        float alpha = (1.0F - hide) * 0.6F;
        boolean hurt = Math.max(entity.hurtTime, entity.deathTime) > 0;
        // 116 247 232
        // 87 207 175
        int i = FastColor.ARGB32.color((int)(alpha * 255.0F), hurt ? 116 : 94, hurt ? 247 : 242, hurt ? 232 : 242);
        (this.getParentModel()).renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), i);
    }
}
