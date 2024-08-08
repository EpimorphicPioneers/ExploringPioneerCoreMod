package cn.dancingsnow.epcore.client;

import cn.dancingsnow.epcore.api.item.armor.IOxygenArmor;
import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.adastra.api.systems.PlanetData;
import earth.terrarium.adastra.client.config.AdAstraConfigClient;
import earth.terrarium.adastra.client.utils.ClientData;
import earth.terrarium.adastra.common.items.armor.SpaceSuitItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;

import static earth.terrarium.adastra.client.screens.player.OverlayScreen.OXYGEN_TANK;
import static earth.terrarium.adastra.client.screens.player.OverlayScreen.OXYGEN_TANK_EMPTY;

public class OverlayScreen {

    public static void render(GuiGraphics graphics, float partialTick) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || player.isSpectator()) return;
        if (mc.options.renderDebug) return;

        Font font = mc.font;
        PoseStack poseStack = graphics.pose();

        // Oxygen overlay
        ItemStack chestStack = player.getInventory().getArmor(2);
        if (SpaceSuitItem.hasFullSet(player)
                && chestStack.getItem() instanceof ArmorComponentItem armorComponentItem
                && armorComponentItem.getArmorLogic() instanceof IOxygenArmor oxygenArmor) {
            long amount = oxygenArmor.getOxygen(chestStack);
            long capacity = oxygenArmor.getMaxOxygen();
            double ratio = (double) amount / capacity;
            int barHeight = (int) (ratio * 52);

            int x = AdAstraConfigClient.oxygenBarX;
            int y = AdAstraConfigClient.oxygenBarY;
            float scale = AdAstraConfigClient.oxygenBarScale;

            poseStack.pushPose();
            poseStack.scale(scale, scale, scale);
            graphics.blit(OXYGEN_TANK_EMPTY, x, y, 0.0F, 0.0F, 62, 52, 62, 52);
            graphics.blit(OXYGEN_TANK, x, y + 52 - barHeight, 0, 52 - barHeight, 62, barHeight, 62, 52);

            var text = String.format("%.1f%%", ratio * 100);
            int textWidth = font.width(text);
            int color = ratio <= 0 ? 0xDC143C : 0xFFFFFF;
            PlanetData localData = ClientData.getLocalData();
            if (localData != null && localData.oxygen()) {
                color = 0x55ff55;
            }
            graphics.drawString(font, text, (int) (x + (62 - textWidth) / 2f), y + 52 + 3, color);
            poseStack.popPose();
        }
    }
}
