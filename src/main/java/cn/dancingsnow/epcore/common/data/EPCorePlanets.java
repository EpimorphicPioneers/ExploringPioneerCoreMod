package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.EPCoreMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class EPCorePlanets {
    public static final ResourceKey<Level> DEIMOS = create("deimos");
    public static final ResourceKey<Level> CERES = create("ceres");
    public static final ResourceKey<Level> GANYMEDE = create("ganymede");
    public static final ResourceKey<Level> IO = create("io");

    public static final ResourceKey<Level> DEIMOS_ORBIT = create("deimos_orbit");
    public static final ResourceKey<Level> CERES_ORBIT = create("ceres_orbit");
    public static final ResourceKey<Level> GANYMEDE_ORBIT = create("ganymede_orbit");
    public static final ResourceKey<Level> IO_ORBIT = create("io_orbit");

    private static ResourceKey<Level> create(String path) {
        return ResourceKey.create(Registries.DIMENSION, EPCoreMod.id(path));
    }
}
