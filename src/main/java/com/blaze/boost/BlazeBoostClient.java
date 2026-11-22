package com.blaze.boost;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.GraphicsMode;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.ParticlesMode;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class BlazeBoostClient implements ClientModInitializer {
    private static final KeyBinding.Category CATEGORY =
            KeyBinding.Category.create(Identifier.of("blazeboost", "main"));
    private static KeyBinding toggleKey;
    private static boolean applied = false;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.blazeboost.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, CATEGORY));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!applied && client.options != null) {
                applied = true;
                applySettings(client);
            }
            while (toggleKey.wasPressed()) {
                BoostConfig.enabled = !BoostConfig.enabled;
                if (BoostConfig.enabled) applySettings(client);
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("BlazeBoost: " + (BoostConfig.enabled ? "ON" : "OFF")), true);
                }
            }
        });
    }

    private static void applySettings(MinecraftClient client) {
        GameOptions o = client.options;
        o.getViewDistance().setValue(8);
        o.getSimulationDistance().setValue(6);
        o.getEntityDistanceScaling().setValue(0.6);
        o.getBiomeBlendRadius().setValue(0);
        o.getMipmapLevels().setValue(0);
        o.getParticles().setValue(ParticlesMode.DECREASED);
        o.getCloudRenderMode().setValue(CloudRenderMode.OFF);
        o.getGraphicsMode().setValue(GraphicsMode.FAST);
        o.getAo().setValue(false);
        o.getEntityShadows().setValue(false);
        o.getEnableVsync().setValue(false);
        o.getMaxFps().setValue(260);
        o.write();
    }
}
