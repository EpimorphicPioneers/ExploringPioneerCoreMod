package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.DimensionTypeBuilder;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;

public class EPCoreDimensionTypeProvider {
    public static final ResourceKey<DimensionType> DEIMOS = register("deimos");
    public static final ResourceKey<DimensionType> CERES = register("ceres");
    public static final ResourceKey<DimensionType> GANYMEDE = register("ganymede");
    public static final ResourceKey<DimensionType> IO = register("io");

    public static final ResourceKey<DimensionType> DEIMOS_ORBIT = register("deimos_orbit");
    public static final ResourceKey<DimensionType> CERES_ORBIT = register("ceres_orbit");
    public static final ResourceKey<DimensionType> GANYMEDE_ORBIT = register("ganymede_orbit");
    public static final ResourceKey<DimensionType> IO_ORBIT = register("io_orbit");

    private static ResourceKey<DimensionType> register(String path) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, EPCoreMod.id(path));
    }

    public static void bootstrap(BootstapContext<DimensionType> context) {
        planet(DEIMOS).buildAndRegister(context::register);

        planet(CERES).buildAndRegister(context::register);

        planet(GANYMEDE).buildAndRegister(context::register);

        planet(IO).buildAndRegister(context::register);

        planet(DEIMOS_ORBIT).buildAndRegister(context::register);

        planet(CERES_ORBIT).buildAndRegister(context::register);

        planet(GANYMEDE_ORBIT).buildAndRegister(context::register);

        planet(IO_ORBIT).buildAndRegister(context::register);
    }

    private static DimensionTypeBuilder planet(ResourceKey<DimensionType> key) {
        return DimensionTypeBuilder.of(key).effects(key.location()).hasRaids(false);
    }
}
