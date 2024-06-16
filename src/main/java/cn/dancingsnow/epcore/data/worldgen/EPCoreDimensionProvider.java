package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.PlanetKey;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import static cn.dancingsnow.epcore.common.data.EPCorePlanets.CERES_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.DEIMOS;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.DEIMOS_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.GANYMEDE_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.IO_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.TAU_CETI_F_ORBIT;
import static cn.dancingsnow.epcore.data.worldgen.EPCoreBiomeDataProvider.SPACE_WASTELANDS;

public class EPCoreDimensionProvider {

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        space(context, DEIMOS_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, CERES_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, GANYMEDE_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, IO_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, TAU_CETI_F_ORBIT, dimensionTypes, biomes, noiseSettings);

//        planet(context, DEIMOS, new FixedBiomeSource(biomes.getOrThrow(SPACE_WASTELANDS)),
//                noiseSettings.getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, EPCoreMod.id("deimos"))), dimensionTypes);
    }

    private static void space(
            BootstapContext<LevelStem> context,
            PlanetKey planet,
            HolderGetter<DimensionType> dimensionTypes,
            HolderGetter<Biome> biomes,
            HolderGetter<NoiseGeneratorSettings> noiseSettings) {
        context.register(
                planet.levelStem(),
                new LevelStem(
                        dimensionTypes.getOrThrow(planet.dimensionType()),
                        new NoiseBasedChunkGenerator(
                                new FixedBiomeSource(biomes.getOrThrow(EPCoreBiomeDataProvider.SPACE)),
                                noiseSettings.getOrThrow(EPCoreNoiseGeneratorSettingsProvider.SPACE))));
    }

    private static void planet(
            BootstapContext<LevelStem> context,
            PlanetKey planet,
            BiomeSource biomes,
            Holder<NoiseGeneratorSettings> noiseSettings,
            HolderGetter<DimensionType> dimensionTypes) {
        context.register(
                planet.levelStem(),
                new LevelStem(
                        dimensionTypes.getOrThrow(planet.dimensionType()),
                        new NoiseBasedChunkGenerator(biomes, noiseSettings)));
    }
}
