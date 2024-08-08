package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.api.registry.PlanetKey;
import cn.dancingsnow.epcore.common.data.EPCorePlanets;
import cn.dancingsnow.epcore.data.worldgen.EPCoreBiomeDataProvider;


import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class EPCoreWorldLang {
    public static void init(MOLangProvider provider) {
        addBiomeLang(provider, EPCoreBiomeDataProvider.SPACE, "space", "太空");
        addBiomeLang(provider, EPCoreBiomeDataProvider.SPACE_WASTELANDS, "space_wastelands", "太空荒地");
        addBiomeLang(provider, EPCoreBiomeDataProvider.IO, "IO", "木卫一");
        addBiomeLang(provider, EPCoreBiomeDataProvider.IO_ASH, "IO Ash", "木卫一灰烬");

        addPlanetLang(provider, EPCorePlanets.DEIMOS, "Deimos", "火卫二");
        addPlanetLang(provider, EPCorePlanets.DEIMOS_ORBIT, "Deimos Orbit", "火卫二轨道");

        addPlanetLang(provider, EPCorePlanets.CERES, "Ceres", "谷神星");
        addPlanetLang(provider, EPCorePlanets.CERES_ORBIT, "Ceres Orbit", "谷神星轨道");

        addPlanetLang(provider, EPCorePlanets.GANYMEDE, "Ganymede", "木卫三");
        addPlanetLang(provider, EPCorePlanets.GANYMEDE_ORBIT, "Ganymede Orbit", "木卫三轨道");

        addPlanetLang(provider, EPCorePlanets.IO, "IO", "木卫一");
        addPlanetLang(provider, EPCorePlanets.IO_ORBIT, "IO Orbit", "木卫一轨道");
    }

    private static void addBiomeLang(
            MOLangProvider provider, ResourceKey<Biome> biome, String en_name, String cn_name) {
        var key = "biome.%s.%s"
                .formatted(biome.location().getNamespace(), biome.location().getPath());
        provider.add(key, en_name, cn_name);
    }

    private static void addPlanetLang(
            MOLangProvider provider, PlanetKey planet, String en_name, String cn_name) {
        var key = "planet.%s.%s"
                .formatted(planet.location().getNamespace(), planet.location().getPath());
        provider.add(key, en_name, cn_name);
    }
}
