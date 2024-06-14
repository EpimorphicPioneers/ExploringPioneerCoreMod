package cn.dancingsnow.epcore.data.planet;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.PlanetBuilder;
import cn.dancingsnow.epcore.common.data.EPCorePlanets;
import cn.dancingsnow.epcore.data.provider.CodecProvider;

import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.api.planets.Planet;

import java.util.function.BiConsumer;

public class EPCorePlanetProvider extends CodecProvider<Planet> {
    public static final ResourceKey<Registry<Planet>> PLANET_REGISTRY =
            ResourceKey.createRegistryKey(EPCoreMod.id("planets"));

    public static final ResourceLocation SOLAR_SYSTEM =
            new ResourceLocation(AdAstra.MOD_ID, "solar_system");

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
                .orbit(builder -> builder.dimension(EPCorePlanets.DEIMOS_ORBIT).tier(2).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.CERES)
                .tier(3)
                .temperature(-105)
                .gravity(2.7558f)
                .solarPower(8)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder -> builder.dimension(EPCorePlanets.CERES_ORBIT).tier(3).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.GANYMEDE)
                .tier(3)
                .temperature(-105)
                .gravity(14.281004f)
                .solarPower(8)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(
                        builder -> builder.dimension(EPCorePlanets.GANYMEDE_ORBIT).tier(3).solarPower(24))
                .buildAndRegister(consumer);

        planet(EPCorePlanets.IO)
                .tier(4)
                .temperature(-125)
                .gravity(17.9641009f)
                .solarPower(4)
                .solarSystem(SOLAR_SYSTEM)
                .orbit(builder -> builder.dimension(EPCorePlanets.IO_ORBIT).tier(4).solarPower(24))
                .buildAndRegister(consumer);
    }

    private static PlanetBuilder planet(ResourceKey<Level> dimension) {
        return PlanetBuilder.create(dimension.location()).dimension(dimension);
    }

    @Override
    public String getName() {
        return "EPCore Planet";
    }
}
