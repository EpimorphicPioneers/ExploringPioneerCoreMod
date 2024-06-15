package cn.dancingsnow.epcore.data.planet;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.PlanetKey;
import cn.dancingsnow.epcore.api.registry.builder.PlanetRendererBuilder;
import cn.dancingsnow.epcore.common.data.EPCorePlanets;
import cn.dancingsnow.epcore.data.provider.CodecProvider;
import cn.dancingsnow.epcore.utils.EPCoreDimensionRenderingUtils;

import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;

import earth.terrarium.adastra.client.dimension.PlanetRenderer;
import org.jetbrains.annotations.NotNull;

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
        planetRenderer(EPCorePlanets.DEIMOS_ORBIT)
                .orbit(EPCoreDimensionRenderingUtils.DEIMOS, 0xff3c7cda, 8)
                .buildAndRegister(consumer);

        planetRenderer(EPCorePlanets.TAU_CETI_F_ORBIT)
                .orbit(EPCoreDimensionRenderingUtils.TAU_CETI_F, 0xff3c7cda, 8)
                .buildAndRegister(consumer);
    }

    private static PlanetRendererBuilder planetRenderer(PlanetKey planet) {
        return PlanetRendererBuilder.of(planet.location()).dimension(planet.dimension());
    }

    @Override
    public @NotNull String getName() {
        return "EPCore Planet Renderers";
    }
}
