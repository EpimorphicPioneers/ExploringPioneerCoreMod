package cn.dancingsnow.epcore.api.registry.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Consumer;

public class BiomeBuilder extends KeyRegisterBuilder<Biome> {

    private final Biome.BiomeBuilder baseBuilder;

    protected BiomeBuilder(ResourceKey<Biome> key, Object... args) {
        super(key, args);
        this.baseBuilder = new Biome.BiomeBuilder();
    }

    public static BiomeBuilder of(ResourceKey<Biome> key) {
        return new BiomeBuilder(key);
    }

    public BiomeBuilder hasPrecipitation(boolean hasPercipitation) {
        this.baseBuilder.hasPrecipitation(hasPercipitation);
        return this;
    }

    public BiomeBuilder temperature(float temperature) {
        this.baseBuilder.temperature(temperature);
        return this;
    }

    public BiomeBuilder downfall(float downfall) {
        this.baseBuilder.downfall(downfall);
        return this;
    }

    public BiomeBuilder specialEffects(BiomeSpecialEffects effects) {
        this.baseBuilder.specialEffects(effects);
        return this;
    }

    public BiomeBuilder specialEffects(Consumer<BiomeSpecialEffects.Builder> consumer) {
        var builder = new BiomeSpecialEffects.Builder();
        builder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
        consumer.accept(builder);
        this.baseBuilder.specialEffects(builder.build());
        return this;
    }

    public BiomeBuilder noMobSpawn() {
        this.baseBuilder.mobSpawnSettings(new MobSpawnSettings.Builder().build());
        return this;
    }

    public BiomeBuilder mobSpawnSettings(MobSpawnSettings mobSpawnSettings) {
        this.baseBuilder.mobSpawnSettings(mobSpawnSettings);
        return this;
    }

    public BiomeBuilder mobSpawnSettings(Consumer<MobSpawnSettings.Builder> consumer) {
        var builder = new MobSpawnSettings.Builder();
        consumer.accept(builder);
        this.baseBuilder.mobSpawnSettings(builder.build());
        return this;
    }

    public BiomeBuilder generationSettings(BiomeGenerationSettings generationSettings) {
        this.baseBuilder.generationSettings(generationSettings);
        return this;
    }

    public BiomeBuilder generationSettings(
            HolderGetter<PlacedFeature> placedFeatures,
            HolderGetter<ConfiguredWorldCarver<?>> worldCarvers,
            Consumer<BiomeGenerationSettings.Builder> consumer) {
        var builder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        consumer.accept(builder);
        this.baseBuilder.generationSettings(builder.build());
        return this;
    }

    public BiomeBuilder noGeneration(
            HolderGetter<PlacedFeature> placedFeatures,
            HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        this.baseBuilder.generationSettings(
                new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers).build());
        return this;
    }

    public BiomeBuilder temperatureAdjustment(Biome.TemperatureModifier temperatureSettings) {
        this.baseBuilder.temperatureAdjustment(temperatureSettings);
        return this;
    }

    @Override
    public Biome build() {
        return baseBuilder.build();
    }
}
