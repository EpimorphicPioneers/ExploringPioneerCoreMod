package cn.dancingsnow.epcore.data.provider;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.planets.EPCorePlanets;
import cn.dancingsnow.epcore.utils.EPCoreDimensionRenderingUtils;

import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import earth.terrarium.adastra.client.dimension.MovementType;
import earth.terrarium.adastra.client.dimension.PlanetRenderer;
import earth.terrarium.adastra.client.dimension.SkyRenderable;
import earth.terrarium.adastra.client.utils.DimensionRenderingUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class EPCorePlanetRendererProvider extends CodecProvider<PlanetRenderer> {

    public static final ResourceKey<Registry<PlanetRenderer>> PLANET_REGISTRY =
            ResourceKey.createRegistryKey(EPCoreMod.id("planet_renderers"));

    public static final int DEFAULT_SUNRISE_COLOR = 0xd85f33;

    public static final SimpleWeightedRandomList<Integer> COLORED_STARS =
            SimpleWeightedRandomList.<Integer>builder()
                    .add(0xA9BCDFFF, 3) // Blue
                    .add(0xBBD7FFFF, 5) // Blue-White,
                    .add(0xFFF4E8FF, 100) // Yellow-White
                    .add(0xFFD1A0FF, 80) // Orange
                    .add(0xFF8A8AFF, 150) // Red
                    .add(0xFF4500FF, 10) // Orange-Red
                    .add(0xFFFFF4FF, 60) // White
                    .add(0xFFF8E7FF, 40) // Pale Yellow
                    .add(0xFFFFFF00, 20) // Very Pale Yellow
                    .add(0xFFFF0000, 1) // Bright Red
                    .build();

    public EPCorePlanetRendererProvider(PackOutput packOutput) {
        super(packOutput, PlanetRenderer.CODEC, PLANET_REGISTRY, PackOutput.Target.RESOURCE_PACK);
    }

    @Override
    protected void build(BiConsumer<ResourceLocation, PlanetRenderer> consumer) {
        orbit(
                consumer, EPCorePlanets.DEIMOS_ORBIT, EPCoreDimensionRenderingUtils.DEIMOS, 0xff3c7cda, 8);
    }

    private static void orbit(
            BiConsumer<ResourceLocation, PlanetRenderer> consumer,
            ResourceKey<Level> planet,
            ResourceLocation planetTexture,
            int backlightColor,
            int sunScale,
            SkyRenderable... additionalRenderables) {
        List<SkyRenderable> renderables = new ArrayList<>();
        renderables.add(new SkyRenderable(
                DimensionRenderingUtils.SUN,
                sunScale,
                Vec3.ZERO,
                Vec3.ZERO,
                MovementType.TIME_OF_DAY,
                0xffffffd9));
        renderables.add(new SkyRenderable(
                planetTexture, 80, new Vec3(180, 0, 0), Vec3.ZERO, MovementType.STATIC, backlightColor));
        renderables.addAll(List.of(additionalRenderables));
        consumer.accept(
                planet.location(),
                new PlanetRenderer(
                        planet,
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
                        renderables));
    }

    @Override
    public @NotNull String getName() {
        return "EPCore Planet Renderers";
    }
}
