package cn.dancingsnow.epcore.api.registry;

import cn.dancingsnow.epcore.EPCoreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class PlanetKey implements Comparable<PlanetKey> {
    @Getter
    @Accessors(fluent = true)
    private final ResourceLocation location;

    private ResourceKey<Level> dimension;
    private ResourceKey<LevelStem> levelStem;
    private ResourceKey<DimensionType> dimensionType;
    private ResourceKey<NoiseGeneratorSettings> noiseGeneratorSettings;

    public PlanetKey(ResourceLocation location) {
        this.location = location;
    }

    public ResourceKey<Level> dimension() {
        if (dimension != null) return dimension;
        return dimension = ResourceKey.create(Registries.DIMENSION, location);
    }

    public ResourceKey<LevelStem> levelStem() {
        if (levelStem != null) return levelStem;
        return levelStem = ResourceKey.create(Registries.LEVEL_STEM, location);
    }

    public ResourceKey<DimensionType> dimensionType() {
        if (dimensionType != null) return dimensionType;
        return dimensionType = ResourceKey.create(Registries.DIMENSION_TYPE, location);
    }

    public ResourceKey<NoiseGeneratorSettings> noiseGeneratorSettings() {
        if (noiseGeneratorSettings != null) return noiseGeneratorSettings;
        return noiseGeneratorSettings = ResourceKey.create(Registries.NOISE_SETTINGS, location);
    }

    public String toString() {
        return location.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof PlanetKey planetKey)) {
            return false;
        } else {
            return planetKey.location.equals(location);
        }
    }

    public int hashCode() {
        return location.hashCode();
    }

    public int compareTo(PlanetKey other) {
        return location.compareTo(other.location);
    }
}
