package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.common.data.EPCorePlanets;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

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
        planet(context, DEIMOS, EPCorePlanets.DEIMOS.location());
        planet(context, CERES, EPCorePlanets.CERES.location());
        planet(context, GANYMEDE, EPCorePlanets.GANYMEDE.location());
        planet(context, IO, EPCorePlanets.IO.location());

        planet(context, DEIMOS_ORBIT, EPCorePlanets.DEIMOS_ORBIT.location());
        planet(context, CERES_ORBIT, EPCorePlanets.CERES_ORBIT.location());
        planet(context, GANYMEDE_ORBIT, EPCorePlanets.GANYMEDE_ORBIT.location());
        planet(context, IO_ORBIT, EPCorePlanets.IO_ORBIT.location());
    }

    private static void planet(
            BootstapContext<DimensionType> context,
            ResourceKey<DimensionType> key,
            ResourceLocation dimensionSpecialEffects) {
        context.register(
                key,
                new DimensionType(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        true,
                        false,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        dimensionSpecialEffects,
                        0.0f,
                        new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));
    }
}
