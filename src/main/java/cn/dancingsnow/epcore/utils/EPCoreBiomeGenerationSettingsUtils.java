package cn.dancingsnow.epcore.utils;

import net.minecraft.data.worldgen.Carvers;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EPCoreBiomeGenerationSettingsUtils {
    public static void caves(BiomeGenerationSettings.Builder builder) {
        builder
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
    }
}
