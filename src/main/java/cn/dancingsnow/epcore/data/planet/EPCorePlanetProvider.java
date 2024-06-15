package cn.dancingsnow.epcore.data.planet;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.PlanetKey;
import cn.dancingsnow.epcore.api.registry.builder.PlanetBuilder;
import cn.dancingsnow.epcore.common.data.EPCorePlanets;
import cn.dancingsnow.epcore.data.provider.CodecProvider;

import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.api.planets.Planet;

import java.util.function.BiConsumer;

public class EPCorePlanetProvider extends CodecProvider<Planet> {
    public static final ResourceKey<Registry<Planet>> PLANET_REGISTRY =
            ResourceKey.createRegistryKey(EPCoreMod.id("planets"));

    public static final ResourceLocation SOLAR_SYSTEM =
            new ResourceLocation(AdAstra.MOD_ID, "solar_system");

    public static final ResourceLocation TAU_CETI_SYSTEM =
            new ResourceLocation(AdAstra.MOD_ID, "tau_ceti_system");

    public EPCorePlanetProvider(PackOutput packOutput) {
        super(packOutput, Planet.CODEC, PLANET_REGISTRY);
    }

    @Override
    protected void build(BiConsumer<ResourceLocation, Planet> consumer) {
        planet(EPCorePlanets.DEIMOS)
                .tier(2)
                .temperature(-75)
                .gravity(3.72076f)
                .solarPower(12)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder ->
                        builder.dimension(EPCorePlanets.DEIMOS_ORBIT.dimension()).tier(2).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.CERES)
                .tier(3)
                .temperature(-105)
                .gravity(2.7558f)
                .solarPower(8)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder ->
                        builder.dimension(EPCorePlanets.CERES_ORBIT.dimension()).tier(3).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.GANYMEDE)
                .tier(3)
                .temperature(-105)
                .gravity(14.281004f)
                .solarPower(8)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder ->
                        builder.dimension(EPCorePlanets.GANYMEDE_ORBIT.dimension()).tier(3).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.IO)
                .tier(4)
                .temperature(-125)
                .gravity(17.9641009f)
                .solarPower(4)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder ->
                        builder.dimension(EPCorePlanets.IO_ORBIT.dimension()).tier(4).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.TAU_CETI_F)
                .tier(6)
                .temperature(40)
                .gravity(9.016F)
                .solarPower(20)
                .solarSystem(TAU_CETI_SYSTEM)
                .orbit(builder -> builder
                        .dimension(EPCorePlanets.TAU_CETI_F_ORBIT.dimension())
                        .tier(6)
                        .solarPower(24))
                .buildAndRegister(consumer);
    }

    private static PlanetBuilder planet(PlanetKey planet) {
        return PlanetBuilder.of(planet.location()).dimension(planet.dimension());
    }

    @Override
    public String getName() {
        return "EPCore Planet";
    }
}
