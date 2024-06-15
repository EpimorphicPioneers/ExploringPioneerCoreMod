package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.api.registry.PlanetKey;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import static cn.dancingsnow.epcore.common.data.EPCorePlanets.CERES_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.DEIMOS_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.GANYMEDE_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.IO_ORBIT;

public class EPCoreDimensionProvider {

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        space(context, DEIMOS_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, CERES_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, GANYMEDE_ORBIT, dimensionTypes, biomes, noiseSettings);
        space(context, IO_ORBIT, dimensionTypes, biomes, noiseSettings);
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
}
