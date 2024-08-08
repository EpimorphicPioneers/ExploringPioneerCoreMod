package cn.dancingsnow.epcore.data;

import cn.dancingsnow.epcore.EPCore;
import cn.dancingsnow.epcore.data.lang.EPCoreLangHandler;
import cn.dancingsnow.epcore.data.planet.EPCorePlanetProvider;
import cn.dancingsnow.epcore.data.planet.EPCorePlanetRendererProvider;
import cn.dancingsnow.epcore.data.provider.EPCoreRegistryProvider;
import cn.dancingsnow.epcore.data.tag.EPCoreTagHandler;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOProviderTypes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.tterrag.registrate.providers.ProviderType;

import java.util.concurrent.CompletableFuture;

import static cn.dancingsnow.epcore.EPCoreCommon.registrate;

@Mod.EventBusSubscriber(modid = EPCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPCoreDataGenerator {

    public static void init() {
        registrate().addDataGenerator(MOProviderTypes.MO_LANG, EPCoreLangHandler::init);
        registrate().addDataGenerator(ProviderType.ITEM_TAGS, EPCoreTagHandler::init);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(
                event.includeClient(), new EPCorePlanetRendererProvider(packOutput, existingFileHelper));

        generator.addProvider(
                event.includeServer(), new EPCoreRegistryProvider(packOutput, lookupProvider));
        generator.addProvider(
                event.includeServer(), new EPCorePlanetProvider(packOutput, existingFileHelper));
    }
}
