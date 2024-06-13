package cn.dancingsnow.epcore.mixins.armor;

import cn.dancingsnow.epcore.api.item.armor.IOxygenArmor;

import com.gregtechceu.gtceu.common.item.armor.NanoMuscleSuite;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.api.systems.OxygenApi;
import earth.terrarium.adastra.common.registry.ModFluids;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Debug(export = true)
@Mixin(value = NanoMuscleSuite.class, remap = false)
public class NanoMuscleSuiteMixin implements IOxygenArmor {
    @Override
    public long getMaxOxygen() {
        return ((NanoMuscleSuite) (Object) this).getArmorType() == ArmorItem.Type.CHESTPLATE ? 2000 : 0;
    }

    @Inject(method = "onArmorTick", at = @At(value = "RETURN", ordinal = 1))
    public void onArmorTick(Level world, Player player, ItemStack itemStack, CallbackInfo ci) {
        if (!player.isCreative() && player.tickCount % 12 == 0 && hasOxygen(itemStack)) {
            if (!OxygenApi.API.hasOxygen(player)) {
                extractOxygen(itemStack, 1, false);
            }
        }
    }

    @Inject(method = "addInfo", at = @At(value = "RETURN"))
    public void addInfo(ItemStack itemStack, List<Component> lines, CallbackInfo ci) {
        if (getMaxOxygen() > 0) {
            lines.add(Component.translatable(
                            "tooltip.ad_astra.fluid",
                            getOxygen(itemStack),
                            getMaxOxygen(),
                            ModFluids.OXYGEN.get().getFluidType().getDescription())
                    .withStyle(ChatFormatting.GOLD));
        }
    }
}
