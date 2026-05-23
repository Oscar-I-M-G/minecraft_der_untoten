package mdu.gui;

import mdu.Minecraft_der_untoten;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.Util;
import net.minecraft.client.Minecraft;
public class HudRenderingEntryPoint{
    public static void init(){
        HudElementRegistry.attachElementBefore(VanillaHudElements.CROSSHAIR,
            Identifier.fromNamespaceAndPath(Minecraft_der_untoten.MOD_ID, "before_chat"),
            HudRenderingEntryPoint::extract);
    }

	private static void extract(GuiGraphicsExtractor graphics,DeltaTracker tickCounter ) {
		Minecraft mc = Minecraft.getInstance();

		int color = 0xFFFF0000; // Red
		int targetColor = 0xFF00FF00; // Green
		int width = mc.getWindow().getGuiScaledWidth();
		int height = mc.getWindow().getGuiScaledHeight();
		int pushRight = 25;
		int pushUp = 12;
		// You can use the Util.getMillis() function to get the current time in milliseconds.
		// Divide by 1000 to get seconds.
		double currentTime = Util.getMillis() / 1000.0;

		// "lerp" simply means "linear interpolation", which is a fancy way of saying "blend".
		float lerpedAmount = Mth.abs(Mth.sin((float) currentTime));
		int lerpedColor = ARGB.linearLerp(lerpedAmount, color, targetColor);
		String currentRound = String.valueOf(0);
		int h = mc.font.lineHeight;
		int w = mc.font.width("Round");
		// Draw a square with the lerped color.
		// x1, x2, y1, y2, color
		// graphics.fill(0, 0, 10, 10, lerpedColor);
		graphics.text(
			mc.font,
			"Round",
			10+pushRight,
			height-12-h-pushUp,
			lerpedColor,
			true
		);
		graphics.text(
				mc.font,
				currentRound,
				7+ w/2 +pushRight,
				height-10-pushUp,
				lerpedColor,
				true
		);
	}
}
