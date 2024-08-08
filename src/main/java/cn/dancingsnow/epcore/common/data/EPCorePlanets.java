package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.EPCore;
import cn.dancingsnow.epcore.api.registry.PlanetKey;

public class EPCorePlanets {
    public static final PlanetKey DEIMOS = create("deimos");
    public static final PlanetKey CERES = create("ceres");
    public static final PlanetKey GANYMEDE = create("ganymede");
    public static final PlanetKey IO = create("io");
    public static final PlanetKey TAU_CETI_F = create("tau_ceti_f");

    public static final PlanetKey DEIMOS_ORBIT = create("deimos_orbit");
    public static final PlanetKey CERES_ORBIT = create("ceres_orbit");
    public static final PlanetKey GANYMEDE_ORBIT = create("ganymede_orbit");
    public static final PlanetKey IO_ORBIT = create("io_orbit");
    public static final PlanetKey TAU_CETI_F_ORBIT = create("tau_ceti_f_orbit");

    private static PlanetKey create(String path) {
        return new PlanetKey(EPCore.id(path));
    }
}
