package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;

import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTOres;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.AdAstra;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class EPCoreOreVeins {
    public static final Set<OreTranslate> ALL_ORES = new HashSet<>();
    private static final ResourceLocation OVERWORLD = Level.OVERWORLD.location();

    private static final ResourceLocation MOON = new ResourceLocation(AdAstra.MOD_ID, "moon"),
            MARS = new ResourceLocation(AdAstra.MOD_ID, "mars"),
            VENUS = new ResourceLocation(AdAstra.MOD_ID, "venus"),
            MERCURY = new ResourceLocation(AdAstra.MOD_ID, "mercury"),
            GLACIO = new ResourceLocation(AdAstra.MOD_ID, "glacio");

    public static GTOreDefinition DIAMOND;

    private static GTOreDefinition create(
            String key, String en_name, String cn_name, Consumer<GTOreDefinition> consumer) {
        ALL_ORES.add(new OreTranslate(key, en_name, cn_name));
        return GTOres.create(EPCoreMod.id(key), consumer);
    }

    public static void init() {
        DIAMOND = create("diamond", "Diamond veins", "钻石矿脉", vein -> {
            vein.weight(50);
            vein.clusterSize(35);
            vein.density(0.25f);
            vein.layer(EPCoreWorldGenLayers.ALL);
            vein.dimensions(OVERWORLD, MERCURY);
            vein.heightRangeUniform(-60, 10);

            vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                    .layer(l -> l.weight(3).mat(GTMaterials.Graphite).size(2, 4))
                    .layer(l -> l.weight(2).mat(GTMaterials.Coal).size(1, 1))
                    .layer(l -> l.weight(1).mat(GTMaterials.Diamond).size(1, 1))));
            vein.surfaceIndicatorGenerator(generator -> generator
                    .surfaceRock(GTMaterials.Diamond)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
                    .density(0.1f)
                    .radius(2));
        });
    }

    public record OreTranslate(String key, String en_name, String cn_name) {
        public String getTranslateKey() {
            return "gtceu.jei.ore_vein." + key;
        }
    }
}
