package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import org.jetbrains.annotations.Nullable;

public class EPCoreBiomeDataProvider {
    public static final ResourceKey<Biome> SPACE = register("orbit");
    public static final ResourceKey<Biome> SPACE_WASTELANDS = register("space_wastelands");
    public static final ResourceKey<Biome> IO = register("io");
    public static final ResourceKey<Biome> IO_ASH = register("io_ash");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, EPCoreMod.id(name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers =
                context.lookup(Registries.CONFIGURED_CARVER);

        context.register(
                SPACE,
                biome(
                        false,
                        0.5f,
                        0,
                        0x000000,
                        0x000000,
                        new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f),
                        0x3f76e4,
                        0x50533,
                        null,
                        null,
                        new MobSpawnSettings.Builder(),
                        new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers),
                        null));

        context.register(
                SPACE_WASTELANDS,
                biome(
                        false,
                        0.8f,
                        0.0f,
                        0xE6AC84,
                        0xE6AC84,
                        new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f),
                        0x3f76e4,
                        0x50533,
                        null,
                        null,
                        new MobSpawnSettings.Builder(),
                        caves(placedFeatures, configuredCarvers)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.LARGE_DRIPSTONE)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.DRIPSTONE_CLUSTER)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.POINTED_DRIPSTONE),
                        null));

        context.register(
                IO,
                biome(
                        false,
                        0.8f,
                        0.0f,
                        0xE6AC84,
                        0xE6AC84,
                        new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f),
                        0x3f76e4,
                        0x50533,
                        null,
                        null,
                        new MobSpawnSettings.Builder(),
                        caves(placedFeatures, configuredCarvers)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.LARGE_DRIPSTONE)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.DRIPSTONE_CLUSTER)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.POINTED_DRIPSTONE)
                                .addFeature(
                                        GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE)
                                .addFeature(
                                        GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.BASALT_PILLAR),
                        null));

        context.register(
                IO_ASH,
                biome(
                        false,
                        0.8f,
                        0.0f,
                        0xE6AC84,
                        0xE6AC84,
                        new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f),
                        0x3f76e4,
                        0x50533,
                        null,
                        null,
                        new MobSpawnSettings.Builder(),
                        caves(placedFeatures, configuredCarvers)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.LARGE_DRIPSTONE)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.DRIPSTONE_CLUSTER)
                                .addFeature(
                                        GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                        CavePlacements.POINTED_DRIPSTONE)
                                .addFeature(
                                        GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE)
                                .addFeature(
                                        GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.BASALT_PILLAR),
                        null));
    }

    public static Biome biome(
            boolean hasPrecipitation,
            float temperature,
            float downfall,
            int skyColor,
            int fogColor,
            AmbientParticleSettings particles,
            int waterColor,
            int waterFogColor,
            @Nullable Integer grassColorOverride,
            @Nullable Integer foliageColorOverride,
            MobSpawnSettings.Builder mobSpawnSettings,
            BiomeGenerationSettings.Builder generationSettings,
            @Nullable Music backgroundMusic) {
        var specoalEffectsBuilder = (new BiomeSpecialEffects.Builder())
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .fogColor(skyColor)
                .skyColor(fogColor)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(backgroundMusic);
        if (grassColorOverride != null) {
            specoalEffectsBuilder.grassColorOverride(grassColorOverride);
        }

        if (particles != null) {
            specoalEffectsBuilder.ambientParticle(particles);
        }

        if (foliageColorOverride != null) {
            specoalEffectsBuilder.foliageColorOverride(foliageColorOverride);
        }

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(hasPrecipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(specoalEffectsBuilder.build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static BiomeGenerationSettings.Builder caves(
            HolderGetter<PlacedFeature> placedFeatures,
            HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers) {
        return new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
    }
}
