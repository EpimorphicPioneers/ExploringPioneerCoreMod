package cn.dancingsnow.epcore.integration.ad;

import cn.dancingsnow.epcore.api.item.armor.IOxygenArmor;

import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;

import net.minecraft.world.item.ItemStack;

import earth.terrarium.adastra.api.events.AdAstraEvents;

public class EPCoreAdAstraEvent {
    public static void init() {
        AdAstraEvents.OxygenTickEvent.register((level, entity) -> {
            for (ItemStack armorSlot : entity.getArmorSlots()) {
                if (armorSlot.getItem() instanceof ArmorComponentItem armorComponentItem) {
                    if (armorComponentItem.getArmorLogic() instanceof IOxygenArmor oxygenArmor) {
                        if (oxygenArmor.hasOxygen(armorSlot)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        });
    }
}
