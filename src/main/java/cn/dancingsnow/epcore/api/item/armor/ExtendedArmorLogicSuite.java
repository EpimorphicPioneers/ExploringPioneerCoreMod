package cn.dancingsnow.epcore.api.item.armor;

import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.gregtechceu.gtceu.api.item.armor.ArmorLogicSuite;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.adastra.api.systems.OxygenApi;
import earth.terrarium.adastra.api.systems.PlanetData;
import earth.terrarium.adastra.client.config.AdAstraConfigClient;
import earth.terrarium.adastra.client.utils.ClientData;
import earth.terrarium.adastra.common.items.armor.SpaceSuitItem;
import earth.terrarium.adastra.common.registry.ModFluids;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

import static earth.terrarium.adastra.client.screens.player.OverlayScreen.OXYGEN_TANK;
import static earth.terrarium.adastra.client.screens.player.OverlayScreen.OXYGEN_TANK_EMPTY;

@Getter
@Setter
@Accessors(chain = true)
public class ExtendedArmorLogicSuite extends WrappedArmorLogicSuite implements IOxygenArmor {

    private long maxOxygen;

    protected ExtendedArmorLogicSuite(ArmorLogicSuite innerSuite) {
        super(innerSuite);
    }

    public static Optional<ExtendedArmorLogicSuite> wrap(ArmorComponentItem item) {
        var armorLogic = item.getArmorLogic();
        if (armorLogic instanceof ArmorLogicSuite suite) {
            var logic = new ExtendedArmorLogicSuite(suite);
            item.setArmorLogic(logic);
            return Optional.of(logic);
        }
        return Optional.empty();
    }

    @Override
    public void addInfo(ItemStack itemStack, List<Component> lines) {
        super.addInfo(itemStack, lines);
        if (getMaxOxygen() > 0) {
            lines.add(Component.translatable(
                            "tooltip.ad_astra.fluid",
                            getOxygen(itemStack),
                            getMaxOxygen(),
                            ModFluids.OXYGEN.get().getFluidType().getDescription())
                    .withStyle(ChatFormatting.GOLD));
        }
    }

    @Override
    public void onArmorTick(Level world, Player player, ItemStack itemStack) {
        super.onArmorTick(world, player, itemStack);
        if (!player.isCreative() && player.tickCount % 12 == 0 && hasOxygen(itemStack)) {
            if (!OxygenApi.API.hasOxygen(player)) {
                extractOxygen(itemStack, 1, false);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawHUD(ItemStack stack, GuiGraphics guiGraphics) {
        super.drawHUD(stack, guiGraphics);
        drawOxygenCapacityHUD(stack, guiGraphics);
    }

    @OnlyIn(Dist.CLIENT)
    protected static void drawOxygenCapacityHUD(ItemStack item, GuiGraphics graphics) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || player.isSpectator()) return;
        if (mc.options.renderDebug) return;

        Font font = mc.font;
        PoseStack poseStack = graphics.pose();

        // Oxygen overlay
        if (SpaceSuitItem.hasFullSet(player)
                && item.getItem() instanceof ArmorComponentItem armorComponentItem
                && armorComponentItem.getArmorLogic() instanceof IOxygenArmor oxygenArmor
                && oxygenArmor.getMaxOxygen() > 0) {
            long amount = oxygenArmor.getOxygen(item);
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
