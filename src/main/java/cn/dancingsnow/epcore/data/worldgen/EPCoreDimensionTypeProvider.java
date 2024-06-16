package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.api.registry.PlanetKey;
import cn.dancingsnow.epcore.api.registry.builder.DimensionTypeBuilder;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.dimension.DimensionType;

import static cn.dancingsnow.epcore.common.data.EPCorePlanets.CERES;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.CERES_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.DEIMOS;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.DEIMOS_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.GANYMEDE;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.GANYMEDE_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.IO;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.IO_ORBIT;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.TAU_CETI_F;
import static cn.dancingsnow.epcore.common.data.EPCorePlanets.TAU_CETI_F_ORBIT;

public class EPCoreDimensionTypeProvider {

    public static void bootstrap(BootstapContext<DimensionType> context) {
        planet(DEIMOS).buildAndRegister(context::register);
        planet(CERES).buildAndRegister(context::register);
        planet(GANYMEDE).buildAndRegister(context::register);
        planet(IO).buildAndRegister(context::register);
        planet(TAU_CETI_F).buildAndRegister(context::register);

        planet(DEIMOS_ORBIT).buildAndRegister(context::register);
        planet(CERES_ORBIT).buildAndRegister(context::register);
        planet(GANYMEDE_ORBIT).buildAndRegister(context::register);
        planet(IO_ORBIT).buildAndRegister(context::register);
        planet(TAU_CETI_F_ORBIT).buildAndRegister(context::register);
    }

    private static DimensionTypeBuilder planet(PlanetKey key) {
        return DimensionTypeBuilder.of(key.dimensionType()).effects(key.location()).hasRaids(false);
    }
}
