package cn.dancingsnow.epcore.common;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.common.data.EPCoreMaterials;
import cn.dancingsnow.epcore.common.worldgen.EPCoreRuleTests;
import cn.dancingsnow.epcore.data.worldgen.EPCoreOreVeins;
import cn.dancingsnow.epcore.data.worldgen.EPCoreWorldGenLayers;

import com.epimorphismmc.monomorphism.proxy.base.ICommonProxyBase;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Set;

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
        //        EPCoreTagPrefixes.init();
    }

    @Override
    public void registerMaterials(MaterialEvent event) {
        EPCoreMaterials.init();
    }

    @Override
    public void registerOreDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, GTOreDefinition> event) {
        Set.copyOf(GTRegistries.ORE_VEINS.keys()).forEach(GTRegistries.ORE_VEINS::remove);
        EPCoreOreVeins.init();
    }

    @Override
    public void registerModBusEventHandlers(IEventBus bus) {
        ICommonProxyBase.super.registerModBusEventHandlers(bus);

        EPCoreRuleTests.init(bus);
    }
}
