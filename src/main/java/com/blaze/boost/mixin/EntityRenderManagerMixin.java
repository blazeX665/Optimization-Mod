package com.blaze.boost.mixin;

import com.blaze.boost.BoostConfig;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderManager.class)
public class EntityRenderManagerMixin {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void blazeboost$cull(Entity entity, Frustum frustum, double x, double y, double z,
                                 CallbackInfoReturnable<Boolean> cir) {
        if (!BoostConfig.enabled) return;
        if (entity instanceof PlayerEntity || entity.getWidth() > 4.0f) return;
        double max = (entity instanceof ItemEntity || entity instanceof ExperienceOrbEntity)
                ? BoostConfig.itemDistance : BoostConfig.entityDistance;
        if (entity.squaredDistanceTo(x, y, z) > max * max) {
            cir.setReturnValue(false);
        }
    }
}
