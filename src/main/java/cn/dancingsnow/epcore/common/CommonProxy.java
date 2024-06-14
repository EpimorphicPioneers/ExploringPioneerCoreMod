package cn.dancingsnow.epcore.common;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.item.armor.ExtendedArmorLogicSuite;
import cn.dancingsnow.epcore.common.data.EPCoreBlocks;
import cn.dancingsnow.epcore.common.data.EPCoreCreativeModeTabs;
import cn.dancingsnow.epcore.common.data.EPCoreMaterials;
import cn.dancingsnow.epcore.common.data.EPCoreTagPrefixes;
import cn.dancingsnow.epcore.common.data.worldgen.EPCoreOreVeins;
import cn.dancingsnow.epcore.common.data.worldgen.EPCoreWorldGenLayers;
import cn.dancingsnow.epcore.common.worldgen.EPCoreRuleTests;

import com.epimorphismmc.monomorphism.proxy.base.ICommonProxyBase;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonProxy implements ICommonProxyBase {

    public CommonProxy() {
        EPCoreMod.logger().info("Exploring Pioneer Core's Initialization Completed!");
    }

    @Override
    public void registerEventHandlers() {}

    @Override
    public void registerCapabilities() {}

    @Override
    public void registerWorldgenLayers() {
        EPCoreWorldGenLayers.init();
    }

    @Override
    public void registerTagPrefixes() {
        EPCoreTagPrefixes.init();
    }

    @Override
    public void registerMaterials(MaterialEvent event) {
        EPCoreMaterials.init();
    }

    @Override
    public void registerOreDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, GTOreDefinition> event) {
        EPCoreOreVeins.removeOreVeins();
    }

    @Override
    public void registerMachineDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCoreCreativeModeTabs.init();
        EPCoreBlocks.init();
    }

    @Override
    public void registerModBusEventHandlers(IEventBus bus) {
        ICommonProxyBase.super.registerModBusEventHandlers(bus);
        EPCoreRuleTests.init(bus);
    }

    @Override
    public void onCommonSetupEvent(FMLCommonSetupEvent event) {
        ExtendedArmorLogicSuite.wrap(GTItems.NANO_CHESTPLATE.get())
                .ifPresent(suite -> suite.setMaxOxygen(2000L));
        ExtendedArmorLogicSuite.wrap(GTItems.QUANTUM_CHESTPLATE.get())
                .ifPresent(suite -> suite.setMaxOxygen(6000L));
        ExtendedArmorLogicSuite.wrap(GTItems.NANO_CHESTPLATE_ADVANCED.get())
                .ifPresent(suite -> suite.setMaxOxygen(2000L));
        ExtendedArmorLogicSuite.wrap(GTItems.QUANTUM_CHESTPLATE_ADVANCED.get())
                .ifPresent(suite -> suite.setMaxOxygen(6000L));
    }
}
