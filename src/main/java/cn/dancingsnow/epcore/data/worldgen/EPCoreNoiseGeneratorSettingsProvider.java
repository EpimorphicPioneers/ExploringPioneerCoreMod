package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;

import java.util.List;

public class EPCoreNoiseGeneratorSettingsProvider {
    public static final ResourceKey<NoiseGeneratorSettings> SPACE = register("orbit");

    protected static final NoiseSettings SIMPLE_NOISE_SETTINGS = NoiseSettings.create(0, 256, 2, 1);

    private static ResourceKey<NoiseGeneratorSettings> register(String name) {
        return ResourceKey.create(Registries.NOISE_SETTINGS, EPCore.id(name));
    }

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(
                SPACE,
                new NoiseGeneratorSettings(
                        SIMPLE_NOISE_SETTINGS,
                        Blocks.AIR.defaultBlockState(),
                        Blocks.AIR.defaultBlockState(),
                        none(),
                        SurfaceRuleData.air(),
                        List.of(),
                        0,
                        true,
                        false,
                        false,
                        false));
    }

    public static NoiseRouter none() {
        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero());
    }
}
