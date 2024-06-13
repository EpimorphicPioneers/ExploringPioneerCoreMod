package cn.dancingsnow.epcore.mixins.armor;

import cn.dancingsnow.epcore.api.item.armor.IOxygenArmor;

import com.gregtechceu.gtceu.common.item.armor.AdvancedNanoMuscleSuite;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.api.systems.OxygenApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AdvancedNanoMuscleSuite.class, remap = false)
public class AdvancedNanoMuscleSuiteMixin {
    @Inject(method = "onArmorTick", at = @At(value = "RETURN", ordinal = 1))
    public void onArmorTick(Level world, Player player, ItemStack itemStack, CallbackInfo ci) {
        if (!player.isCreative() && player.tickCount % 12 == 0) {
            IOxygenArmor oxygenArmor = (IOxygenArmor) this;
            if (oxygenArmor.hasOxygen(itemStack)) {
                if (!OxygenApi.API.hasOxygen(player)) {
                    oxygenArmor.extractOxygen(itemStack, 1, false);
                }
            }
        }
    }
}
