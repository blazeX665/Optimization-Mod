package com.blaze.boost.mixin;

import com.blaze.boost.BoostConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParticleManager.class)
public class ParticleManagerMixin {
    @Inject(method = "addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;",
            at = @At("HEAD"), cancellable = true)
    private void blazeboost$cull(ParticleEffect effect, double x, double y, double z,
                                 double vx, double vy, double vz, CallbackInfoReturnable<Particle> cir) {
        if (!BoostConfig.enabled) return;
        Entity cam = MinecraftClient.getInstance().getCameraEntity();
        if (cam == null) return;
        double max = BoostConfig.particleDistance;
        if (cam.squaredDistanceTo(x, y, z) > max * max) {
            cir.setReturnValue(null);
        }
    }
}
