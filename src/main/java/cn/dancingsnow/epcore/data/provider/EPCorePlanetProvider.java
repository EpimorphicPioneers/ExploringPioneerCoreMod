package cn.dancingsnow.epcore.data.provider;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.planets.EPCorePlanets;
import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.api.planets.Planet;
import earth.terrarium.adastra.common.constants.PlanetConstants;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class EPCorePlanetProvider extends CodecProvider<Planet> {
    public static final ResourceKey<Registry<Planet>> PLANET_REGISTRY = ResourceKey.createRegistryKey(EPCoreMod.id("planets"));

    public static final ResourceLocation SOLAR_SYSTEM = new ResourceLocation(AdAstra.MOD_ID, "solar_system");

    public EPCorePlanetProvider(PackOutput packOutput) {
        super(packOutput, Planet.CODEC, PLANET_REGISTRY);
    }

    @Override
    protected void build(BiConsumer<ResourceLocation, Planet> consumer) {
        orbit(consumer, EPCorePlanets.DEIMOS_ORBIT, 24, SOLAR_SYSTEM, 2);
        orbit(consumer, EPCorePlanets.CERES_ORBIT, 24, SOLAR_SYSTEM, 3);
        orbit(consumer, EPCorePlanets.GANYMEDE_ORBIT, 24, SOLAR_SYSTEM, 3);
        orbit(consumer, EPCorePlanets.IO_ORBIT, 24, SOLAR_SYSTEM, 4);

        consumer.accept(
            EPCorePlanets.DEIMOS.location(),
            new Planet(
                EPCorePlanets.DEIMOS,
                false,
                (short) -75,
                3.72076f,
                12,
                SOLAR_SYSTEM,
                Optional.of(EPCorePlanets.DEIMOS_ORBIT),
                2,
                List.of()
            )
        );

        consumer.accept(
            EPCorePlanets.CERES.location(),
            new Planet(
                EPCorePlanets.CERES,
                false,
                (short) -105,
                2.7558f,
                8,
                SOLAR_SYSTEM,
                Optional.of(EPCorePlanets.CERES_ORBIT),
                3,
                List.of()
            )
        );

        consumer.accept(
            EPCorePlanets.GANYMEDE.location(),
            new Planet(
                EPCorePlanets.GANYMEDE,
                false,
                (short) -105,
                14.281004f,
                8,
                SOLAR_SYSTEM,
                Optional.of(EPCorePlanets.GANYMEDE_ORBIT),
                3,
                List.of()
            )
        );

        consumer.accept(
            EPCorePlanets.IO.location(),
            new Planet(
                EPCorePlanets.IO,
                false,
                (short) -125,
                17.9641009f,
                4,
                SOLAR_SYSTEM,
                Optional.of(EPCorePlanets.IO_ORBIT),
                4,
                List.of()
            )
        );
    }

    private static void orbit(BiConsumer<ResourceLocation, Planet> consumer, ResourceKey<Level> planet, int solarPower, ResourceLocation galaxy, int tier) {
        consumer.accept(
            planet.location(),
            new Planet(planet,
                false,
                PlanetConstants.SPACE_TEMPERATURE,
                PlanetConstants.SPACE_GRAVITY,
                solarPower,
                galaxy,
                Optional.empty(), tier,
                List.of()
            )
        );
    }

    @Override
    public String getName() {
        return "EPCore Planet";
    }
}
