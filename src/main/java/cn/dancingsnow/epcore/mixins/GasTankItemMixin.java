package cn.dancingsnow.epcore.mixins;

import cn.dancingsnow.epcore.api.item.armor.IOxygenArmor;
import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import earth.terrarium.adastra.common.items.GasTankItem;
import earth.terrarium.botarium.common.fluid.FluidApi;
import earth.terrarium.botarium.common.fluid.FluidConstants;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.base.ItemFluidContainer;
import earth.terrarium.botarium.common.item.ItemStackHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GasTankItem.class, remap = false)
public class GasTankItemMixin {
    @Shadow @Final private long distributionAmount;

    @Inject(
            method = "distributeSequential",
            at = @At(value = "RETURN"),
            cancellable = true
    )
    private void distributeSequential(ItemStackHolder from, FluidHolder container, Inventory inventory, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            for (int armorSlot : Inventory.ALL_ARMOR_SLOTS) {
                ItemStack stack = inventory.getArmor(armorSlot);
                if (stack.getItem() instanceof ArmorComponentItem armorComponentItem) {
                    if (armorComponentItem.getArmorLogic() instanceof IOxygenArmor oxygenArmor) {
                        if (oxygenArmor.getMaxOxygen() <= 0) continue;
                        ItemFluidContainer fluidContainer = FluidApi.getItemFluidContainer(from);
                        FluidHolder toExtract = container.copyWithAmount(FluidConstants.fromMillibuckets(distributionAmount));

                        FluidHolder extractFluid = fluidContainer.extractFluid(toExtract, true);
                        long insertFluid = oxygenArmor.insertOxygen(stack, extractFluid.getFluidAmount(), true);

                        if (extractFluid.getFluidAmount() > 0 && insertFluid > 0) {
                            fluidContainer.extractFluid(toExtract, false);
                            oxygenArmor.insertOxygen(stack, extractFluid.getFluidAmount(),false);
                            cir.setReturnValue(true);
                            return;
                        }
                    }
                }
            }
        }
    }
}
