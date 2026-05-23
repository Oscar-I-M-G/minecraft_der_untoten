package mdu.gui;

import mdu.Minecraft_der_untoten;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;

public class HudDebug {
    public static void init(){
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.fromNamespaceAndPath(Minecraft_der_untoten.MOD_ID, "debug_before_chat"),
                HudDebug::extract);
    }

    private static void extract(GuiGraphicsExtractor graphics, DeltaTracker tickCounter) {
        Minecraft mc = Minecraft.getInstance();

        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();
        int spacing = 25;
        int bgColor = 0x6600FF00;
        int labelColor = 0xFFFFFFFF;

        // vertical lines
        for(int x=0;  x < width; x+= spacing){
            graphics.fill(x, 0, x + 1, height, bgColor);
            graphics.text(
                    mc.font,
                    String.valueOf(x),
                    x + 2,
                    2,
                    labelColor,
                    true
            );
        }

        // Horizontal lines
        for (int y = 0; y < height; y += spacing) {
            graphics.fill(0, y, width, y + 1, bgColor);
            graphics.text(
                    mc.font,
                    String.valueOf(y),
                    2,
                    y+2,
                    labelColor,
                    true
            );
        }
    }
}
