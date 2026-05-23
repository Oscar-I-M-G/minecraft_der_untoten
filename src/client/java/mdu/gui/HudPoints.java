package mdu.gui;

import mdu.Minecraft_der_untoten;
import mdu.common.PlayerPoints;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.Util;

public class HudPoints {
    public static void init(){
        HudElementRegistry.attachElementBefore(VanillaHudElements.CROSSHAIR,
                Identifier.fromNamespaceAndPath(Minecraft_der_untoten.MOD_ID, "before_chat_points"),
                HudPoints::extract);
    }

    private static void extract(GuiGraphicsExtractor graphics, DeltaTracker tickCounter ) {
        Minecraft mc = Minecraft.getInstance();

        int color = 0xFFFFFF00; // yellow
        int targetColor = 0xFFBF00FF; // purple
        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();
        int pushRight = 60;
        int pushUp = 0;
        // You can use the Util.getMillis() function to get the current time in milliseconds.
        // Divide by 1000 to get seconds.
        double currentTime = Util.getMillis() / 1000.0;

        // "lerp" simply means "linear interpolation", which is a fancy way of saying "blend".
        float lerpedAmount = Mth.abs(Mth.sin((float) currentTime));
        int lerpedColor = ARGB.linearLerp(lerpedAmount, color, targetColor);
        int currentPoints = PlayerPoints.get(mc.player.getUUID());
        int h = mc.font.lineHeight;
        StringBuilder sb = new StringBuilder("Z: ");
        sb.insert(3, currentPoints);
        String pointTotal = sb.toString();
        // Draw a square with the lerped color.
        // x1, x2, y1, y2, color
        // graphics.fill(0, 0, 10, 10, lerpedColor);
        graphics.text(
                mc.font,
                pointTotal,
                10+pushRight,
                height-13-h-pushUp,
                lerpedColor,
                true
        );

    }
}