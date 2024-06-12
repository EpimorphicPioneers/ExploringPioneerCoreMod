package cn.dancingsnow.epcore.data.provider;

import cn.dancingsnow.epcore.EPCoreMod;

import cn.dancingsnow.epcore.data.provider.worldgen.EPCoreBiomeDataProvider;
import cn.dancingsnow.epcore.data.provider.worldgen.EPCoreDimensionProvider;
import cn.dancingsnow.epcore.data.provider.worldgen.EPCoreDimensionTypeProvider;
import cn.dancingsnow.epcore.data.provider.worldgen.EPCoreNoiseGeneratorSettingsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EPCoreRegistryProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.DIMENSION_TYPE, EPCoreDimensionTypeProvider::bootstrap)
        .add(Registries.LEVEL_STEM, EPCoreDimensionProvider::bootstrap)
        .add(Registries.BIOME, EPCoreBiomeDataProvider::bootstrap)
        .add(Registries.NOISE_SETTINGS, EPCoreNoiseGeneratorSettingsProvider::bootstrap);

    public EPCoreRegistryProvider(
        PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(EPCoreMod.MODID));
    }
}
