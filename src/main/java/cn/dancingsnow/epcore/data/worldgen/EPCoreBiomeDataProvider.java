package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCore;
import cn.dancingsnow.epcore.api.registry.builder.BiomeBuilder;
import cn.dancingsnow.epcore.utils.EPCoreBiomeGenerationSettingsUtils;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EPCoreBiomeDataProvider {
    public static final ResourceKey<Biome> SPACE = register("orbit");
    public static final ResourceKey<Biome> SPACE_WASTELANDS = register("space_wastelands");
    public static final ResourceKey<Biome> IO = register("io");
    public static final ResourceKey<Biome> IO_ASH = register("io_ash");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, EPCore.id(name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers =
                context.lookup(Registries.CONFIGURED_CARVER);

        BiomeBuilder.of(SPACE)
                .hasPrecipitation(false)
                .temperature(0.5f)
                .downfall(0)
                .noSpecialEffects()
                .noMobSpawn()
                .noGeneration(placedFeatures, configuredCarvers)
                .buildAndRegister(context::register);

        BiomeBuilder.of(SPACE_WASTELANDS)
                .hasPrecipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .specialEffects(builder -> builder
                        .skyColor(0xE6AC84)
                        .fogColor(0xE6AC84)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f))
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x50533))
                .noMobSpawn()
                .generationSettings(placedFeatures, configuredCarvers, builder -> {
                    EPCoreBiomeGenerationSettingsUtils.caves(builder);
                    builder
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION, CavePlacements.LARGE_DRIPSTONE)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.DRIPSTONE_CLUSTER)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.POINTED_DRIPSTONE);
                })
                .buildAndRegister(context::register);

        BiomeBuilder.of(IO)
                .hasPrecipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .specialEffects(builder -> builder
                        .skyColor(0xE6AC84)
                        .fogColor(0xE6AC84)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f))
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x50533))
                .noMobSpawn()
                .generationSettings(placedFeatures, configuredCarvers, builder -> {
                    EPCoreBiomeGenerationSettingsUtils.caves(builder);
                    builder
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION, CavePlacements.LARGE_DRIPSTONE)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.DRIPSTONE_CLUSTER)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.POINTED_DRIPSTONE)
                            .addFeature(
                                    GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE)
                            .addFeature(
                                    GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.BASALT_PILLAR);
                })
                .buildAndRegister(context::register);

        BiomeBuilder.of(IO_ASH)
                .hasPrecipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .specialEffects(builder -> builder
                        .skyColor(0xE6AC84)
                        .fogColor(0xE6AC84)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.014f))
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x50533))
                .noMobSpawn()
                .generationSettings(placedFeatures, configuredCarvers, builder -> {
                    EPCoreBiomeGenerationSettingsUtils.caves(builder);
                    builder
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION, CavePlacements.LARGE_DRIPSTONE)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.DRIPSTONE_CLUSTER)
                            .addFeature(
                                    GenerationStep.Decoration.UNDERGROUND_DECORATION,
                                    CavePlacements.POINTED_DRIPSTONE)
                            .addFeature(
                                    GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE)
                            .addFeature(
                                    GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.BASALT_PILLAR);
                })
                .buildAndRegister(context::register);
    }
}
