package cn.dancingsnow.epcore.data;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.data.planet.EPCorePlanetProvider;
import cn.dancingsnow.epcore.data.planet.EPCorePlanetRendererProvider;
import cn.dancingsnow.epcore.data.provider.EPCoreRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = EPCoreMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPCoreDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new EPCorePlanetRendererProvider(packOutput));

        generator.addProvider(
                event.includeServer(), new EPCoreRegistryProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new EPCorePlanetProvider(packOutput));
    }
}
