package cn.dancingsnow.epcore.api.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import earth.terrarium.adastra.client.dimension.MovementType;
import earth.terrarium.adastra.client.dimension.PlanetRenderer;
import earth.terrarium.adastra.client.dimension.SkyRenderable;
import earth.terrarium.adastra.client.utils.DimensionRenderingUtils;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
    private List<SkyRenderable> skyRenderables = new ArrayList<>();

    public PlanetRendererBuilder(ResourceLocation id, Object... args) {
        super(id, args);
    }

    public static PlanetRendererBuilder create(ResourceLocation id) {
        return new PlanetRendererBuilder(id);
    }

    public PlanetRendererBuilder starColors(
            Consumer<SimpleWeightedRandomList.Builder<Integer>> consumer) {
        var builder = SimpleWeightedRandomList.<Integer>builder();
        consumer.accept(builder);
        this.starColors = builder.build();
        return this;
    }

    public PlanetRendererBuilder addSkyRenderer(SkyRenderable skyRenderer) {
        skyRenderables.add(skyRenderer);
        return this;
    }

    public PlanetRendererBuilder addSkyRenderer(SkyRenderable... skyRenderers) {
        Collections.addAll(skyRenderables, skyRenderers);
        return this;
    }

    public PlanetRendererBuilder addSkyRenderer(Consumer<SkyRenderableBuilder> consumer) {
        var builder = new SkyRenderableBuilder();
        consumer.accept(builder);
        skyRenderables.add(builder.build());
        return this;
    }

    public PlanetRendererBuilder orbit(
            ResourceLocation planetTexture, int backlightColor, int sunScale) {
        this.customClouds = true;
        this.customSky = true;
        this.customWeather = false;
        this.hasThickFog = false;
        this.hasFog = false;
        this.sunriseColor = DEFAULT_SUNRISE_COLOR;
        this.stars = 13000;
        this.starBrightness = 0.6f;
        this.sunriseAngle = 0;
        this.renderInRain = true;
        this.starColors = COLORED_STARS;

        skyRenderables.add(new SkyRenderable(
                DimensionRenderingUtils.SUN,
                sunScale,
                Vec3.ZERO,
                Vec3.ZERO,
                MovementType.TIME_OF_DAY,
                0xffffffd9));
        skyRenderables.add(new SkyRenderable(
                planetTexture, 80, new Vec3(180, 0, 0), Vec3.ZERO, MovementType.STATIC, backlightColor));

        return this;
    }

    @Override
    public PlanetRenderer register() {
        return new PlanetRenderer(
                dimension,
                customClouds,
                customSky,
                customWeather,
                hasThickFog,
                hasFog,
                sunriseColor,
                stars,
                Optional.of(starBrightness),
                sunriseAngle,
                renderInRain,
                starColors,
                skyRenderables);
    }

    @Setter
    @Accessors(fluent = true, chain = true)
    public static class SkyRenderableBuilder {
        ResourceLocation texture;
        float scale;
        Vec3 globalRotation;
        Vec3 localRotation;
        MovementType movementType;
        boolean blend;
        int backLightColor;
        float backLightScale = scale * 3.0F;

        protected SkyRenderableBuilder() {}

        protected SkyRenderable build() {
            return new SkyRenderable(
                    texture,
                    scale,
                    globalRotation,
                    localRotation,
                    movementType,
                    blend,
                    backLightColor,
                    backLightScale);
        }
    }
}
