package cn.dancingsnow.epcore.api.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.client.dimension.PlanetRenderer;
import earth.terrarium.adastra.client.dimension.SkyRenderable;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

import static cn.dancingsnow.epcore.data.planet.EPCorePlanetRendererProvider.COLORED_STARS;
import static cn.dancingsnow.epcore.data.planet.EPCorePlanetRendererProvider.DEFAULT_SUNRISE_COLOR;

@Setter
@Accessors(fluent = true, chain = true)
public class PlanetRendererBuilder extends RegisterBuilder<PlanetRenderer> {

    private ResourceKey<Level> dimension;
    private boolean customClouds;
    private boolean customSky;
    private boolean customWeather;
    private boolean hasThickFog;
    private boolean hasFog;
    private int sunriseColor;
    private int stars;
    private float starBrightness;
    private int sunriseAngle;
    private boolean renderInRain;
    private WeightedRandomList<WeightedEntry.Wrapper<Integer>> starColors;
    private List<SkyRenderable> skyRenderables;

    public PlanetRendererBuilder(ResourceLocation id, Object... args) {
        super(id, args);
    }

    @Override
    public PlanetRenderer register() {
        return new PlanetRenderer(
                dimension,
                true,
                true,
                false,
                false,
                false,
                DEFAULT_SUNRISE_COLOR,
                13000,
                Optional.of(0.6f),
                0,
                true,
                COLORED_STARS,
                skyRenderables);
    }
}
