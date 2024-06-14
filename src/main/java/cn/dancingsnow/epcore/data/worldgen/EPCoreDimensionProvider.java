package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class EPCoreDimensionProvider {
    public static final ResourceKey<LevelStem> DEIMOS = register("deimos");
    public static final ResourceKey<LevelStem> CERES = register("ceres");
    public static final ResourceKey<LevelStem> GANYMEDE = register("ganymede");
    public static final ResourceKey<LevelStem> IO = register("io");

    public static final ResourceKey<LevelStem> DEIMOS_ORBIT = register("deimos_orbit");
    public static final ResourceKey<LevelStem> CERES_ORBIT = register("ceres_orbit");
    public static final ResourceKey<LevelStem> GANYMEDE_ORBIT = register("ganymede_orbit");
    public static final ResourceKey<LevelStem> IO_ORBIT = register("io_orbit");

    private static ResourceKey<LevelStem> register(String name) {
        return ResourceKey.create(Registries.LEVEL_STEM, EPCoreMod.id(name));
    }

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        space(
                context,
                DEIMOS_ORBIT,
                EPCoreDimensionTypeProvider.DEIMOS_ORBIT,
                dimensionTypes,
                biomes,
                noiseSettings);
        space(
                context,
                CERES_ORBIT,
                EPCoreDimensionTypeProvider.CERES_ORBIT,
                dimensionTypes,
                biomes,
                noiseSettings);
        space(
                context,
                GANYMEDE_ORBIT,
                EPCoreDimensionTypeProvider.GANYMEDE_ORBIT,
                dimensionTypes,
                biomes,
                noiseSettings);
        space(
                context,
                IO_ORBIT,
                EPCoreDimensionTypeProvider.IO_ORBIT,
                dimensionTypes,
                biomes,
                noiseSettings);
    }

    private static void space(
            BootstapContext<LevelStem> context,
            ResourceKey<LevelStem> key,
            ResourceKey<DimensionType> type,
            HolderGetter<DimensionType> dimensionTypes,
            HolderGetter<Biome> biomes,
            HolderGetter<NoiseGeneratorSettings> noiseSettings) {
        context.register(
                key,
                new LevelStem(
                        dimensionTypes.getOrThrow(type),
                        new NoiseBasedChunkGenerator(
                                new FixedBiomeSource(biomes.getOrThrow(EPCoreBiomeDataProvider.SPACE)),
                                noiseSettings.getOrThrow(EPCoreNoiseGeneratorSettingsProvider.SPACE))));
    }
}
