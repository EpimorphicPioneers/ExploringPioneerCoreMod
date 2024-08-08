package cn.dancingsnow.epcore;

import cn.dancingsnow.epcore.common.data.EPCoreBlocks;
import cn.dancingsnow.epcore.common.data.EPCoreCreativeModeTabs;
import cn.dancingsnow.epcore.common.data.EPCoreDimensionMarkers;
import cn.dancingsnow.epcore.common.data.EPCoreMaterials;
import cn.dancingsnow.epcore.common.data.worldgen.EPCoreOreVeins;
import cn.dancingsnow.epcore.common.worldgen.EPCoreRuleTests;
import cn.dancingsnow.epcore.config.EPCoreConfigHolder;
import cn.dancingsnow.epcore.data.EPCoreDataGenerator;
import cn.dancingsnow.epcore.integration.ad.EPCoreAdAstraEvent;

import com.epimorphismmc.monomorphism.registry.registrate.MORegistrate;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import com.lowdragmc.lowdraglib.networking.INetworking;
import com.lowdragmc.lowdraglib.networking.LDLNetworking;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class EPCoreCommon implements EPCore {

    private static EPCoreCommon instance;
    private static final MORegistrate REGISTRATE = MORegistrate.create(MOD_ID);
    private static final INetworking NETWORK =
            LDLNetworking.createNetworking(new ResourceLocation(MOD_ID, "networking"), "0.0.1");

    public EPCoreCommon() {
        instance = this;

        EPCoreConfigHolder.init();
        EPCoreAdAstraEvent.init();

        registerPackets(NETWORK);
        registerEventHandlers();

        EPCoreDataGenerator.init();

        LOGGER.info("{}'s Initialization Completed!", NAME);
    }

    public void registerPackets(INetworking network) {}

    public void registerEventHandlers() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);

        EPCoreRuleTests.register(eventBus);

        REGISTRATE.registerEventListeners(eventBus);

        eventBus.addGenericListener(MachineDefinition.class, this::registerMachineDefinitions);
        eventBus.addGenericListener(GTOreDefinition.class, this::registerOreDefinitions);
        eventBus.addGenericListener(DimensionMarker.class, this::registerDimensionMarkers);
    }

    public static EPCoreCommon instance() {
        return instance;
    }

    public static MORegistrate registrate() {
        return REGISTRATE;
    }

    public static INetworking network() {
        return NETWORK;
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        EPCoreMaterials.init();
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MaterialRegistryManager.getInstance().createRegistry(EPCore.MOD_ID);
    }

    public void registerMachineDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCoreCreativeModeTabs.init();
        EPCoreBlocks.init();
    }

    public void registerOreDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, GTOreDefinition> event) {
        EPCoreOreVeins.removeOreVeins();
    }

    public void registerDimensionMarkers(
            GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {
        EPCoreDimensionMarkers.init();
    }
}
