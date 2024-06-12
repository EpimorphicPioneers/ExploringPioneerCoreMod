package cn.dancingsnow.epcore.common.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.planets.EPCorePlanets;
import cn.dancingsnow.epcore.common.data.EPCoreMaterials;

import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTOres;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.api.planets.Planet;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class EPCoreOreVeins {
    public static final Set<OreTranslate> ALL_ORES = new HashSet<>();

    private static final ResourceLocation OVERWORLD = Level.OVERWORLD.location();
    private static final ResourceLocation NETHER = Level.NETHER.location();
    private static final ResourceLocation END = Level.END.location();

    private static final ResourceLocation MOON = Planet.MOON.location();
    private static final ResourceLocation MARS = Planet.MARS.location();
    private static final ResourceLocation VENUS = Planet.VENUS.location();
    private static final ResourceLocation MERCURY = Planet.MERCURY.location();
    private static final ResourceLocation GLACIO = Planet.GLACIO.location();

    private static final ResourceLocation DEIMOS = EPCorePlanets.DEIMOS.location();
    private static final ResourceLocation CERES = EPCorePlanets.CERES.location();
    private static final ResourceLocation GANYMEDE = EPCorePlanets.GANYMEDE.location();
    private static final ResourceLocation IO = EPCorePlanets.IO.location();
    private static final ResourceLocation ROSE_128b = EPCoreMod.id("rose_128b");

    private static final ResourceLocation TWILIGHT_FOREST =
            new ResourceLocation("twilightforest:twilight_forest");
    private static final ResourceLocation AETHER = new ResourceLocation("aether:the_aether");

    public static GTOreDefinition DIAMOND = create("diamond", "Diamond veins", "钻石矿脉", vein -> {
        vein.weight(50);
        vein.clusterSize(35);
        vein.density(0.25F);
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
                .density(0.1F)
                .radius(2));
    });

    public static GTOreDefinition LAPIS = create("lapis", "Lapis veins", "青金石矿脉", vein -> {
        vein.weight(50);
        vein.clusterSize(45);
        vein.density(0.25F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, DEIMOS, CERES);
        vein.heightRangeUniform(-20, 50);
        vein.dikeVeinGenerator(generator -> generator
                .withBlock(GTMaterials.Lazurite, 3, 20, 50)
                .withBlock(GTMaterials.Sodalite, 2, -5, 40)
                .withBlock(GTMaterials.Lapis, 2, -20, 20)
                .withBlock(GTMaterials.Calcite, 1, -20, 50));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Lapis)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
                .density(0.15F)
                .radius(3));
    });
    public static GTOreDefinition IRON = create("iron", "Iron veins", "铁矿脉", vein -> {
        vein.weight(120);
        vein.clusterSize(50);
        vein.density(1);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, MARS, CERES, GANYMEDE, MERCURY);
        vein.heightRangeUniform(-40, 60);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Goethite, 3)
                .oreBlock(GTMaterials.YellowLimonite, 2)
                .oreBlock(GTMaterials.Hematite, 2)
                .rareBlock(GTMaterials.Malachite, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Goethite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition VERMICULITE =
            create("vermiculite", "Vermiculite veins", "蛭石矿脉", vein -> {
                vein.weight(80);
                vein.clusterSize(35);
                vein.density(0.75F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(OVERWORLD);
                vein.heightRangeUniform(80, 200);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Chalcocite, 3, 80, 200)
                        .withBlock(GTMaterials.get("vermiculite"), 2, 80, 200)
                        .withBlock(GTMaterials.Cassiterite, 2, 80, 200)
                        .withBlock(GTMaterials.Alunite, 1, 80, 200));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(EPCoreMaterials.Vermiculite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition OIL_SAND = create("oil_sand", "Oil sand veins", "油砂矿脉", vein -> {
        vein.weight(40);
        vein.clusterSize(40);
        vein.density(0.6F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD);
        vein.heightRangeUniform(20, 80);
        vein.dikeVeinGenerator(generator -> generator.withBlock(GTMaterials.Oilsands, 1, 20, 80));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Oilsands)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition COAL = create("coal", "Coal veins", "煤矿脉", vein -> {
        vein.weight(80);
        vein.clusterSize(60);
        vein.density(0.9F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST);
        vein.heightRangeUniform(-20, 80);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Coal, 3)
                .rareBlock(EPCoreMaterials.Lignite, 1)
                .rareBlockChance(0.2F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Coal)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition MANGANESE = create("manganese", "Manganese veins", "锰矿脉", vein -> {
        vein.weight(20);
        vein.clusterSize(40);
        vein.density(0.8F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, CERES, IO);
        vein.heightRangeUniform(-40, -10);
        vein.dikeVeinGenerator(generator -> generator
                .withBlock(GTMaterials.Grossular, 2, -20, -10)
                .withBlock(GTMaterials.Spessartine, 2, -30, -10)
                .withBlock(GTMaterials.Pyrolusite, 2, -40, -20)
                .withBlock(GTMaterials.Tantalite, 1, -40, -10));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Grossular)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition REDSTONE = create("redstone", "Redstone veins", "红石矿脉", vein -> {
        vein.weight(60);
        vein.clusterSize(30);
        vein.density(0.25F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, MARS, GANYMEDE, MERCURY, VENUS);
        vein.heightRangeUniform(-60, -10);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(3).mat(GTMaterials.Redstone).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Ruby).size(1, 1))
                .layer(l -> l.weight(1).mat(GTMaterials.Cinnabar).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Redstone)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition MICA = create("mica", "Mica veins", "云母矿脉", vein -> {
        vein.weight(20);
        vein.clusterSize(25);
        vein.density(0.25F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD);
        vein.heightRangeUniform(-40, 10);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(2).mat(GTMaterials.Kyanite).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Mica).size(1, 2))
                .layer(l -> l.weight(1).mat(GTMaterials.Cassiterite).size(1, 1))
                .layer(l -> l.weight(1).mat(GTMaterials.Pollucite).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Mica)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition COPPER = create("copper", "Copper veins", "铜矿脉", vein -> {
        vein.weight(80);
        vein.clusterSize(50);
        vein.density(1);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, MOON, CERES);
        vein.heightRangeUniform(-60, 70);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Chalcopyrite, 3)
                .oreBlock(GTMaterials.Pyrite, 2)
                .oreBlock(GTMaterials.Iron, 1)
                .rareBlock(GTMaterials.Copper, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Chalcopyrite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition TALC = create("talc", "Talc veins", "滑石矿脉", vein -> {
        vein.weight(40);
        vein.clusterSize(35);
        vein.density(1);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, CERES);
        vein.heightRangeUniform(10, 60);
        vein.dikeVeinGenerator(generator -> generator
                .withBlock(GTMaterials.Soapstone, 2, 40, 60)
                .withBlock(GTMaterials.Talc, 2, 25, 50)
                .withBlock(GTMaterials.GlauconiteSand, 2, 10, 35)
                .withBlock(GTMaterials.Pentlandite, 1, 10, 60));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Talc)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition GOLD = create("gold", "Gold veins", "金矿脉", vein -> {
        vein.weight(160);
        vein.clusterSize(40);
        vein.density(0.9F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, MARS);
        vein.heightRangeUniform(-30, 70);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Magnetite, 3)
                .oreBlock(GTMaterials.VanadiumMagnetite, 1)
                .rareBlock(GTMaterials.Gold, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Magnetite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition ZEOLITE = create("zeolite", "Zeolite veins", "沸石矿脉", vein -> {
        vein.weight(60);
        vein.clusterSize(30);
        vein.density(0.4F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD);
        vein.heightRangeUniform(40, 70);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(1).mat(GTMaterials.Zeolite).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.FullersEarth).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.GlauconiteSand).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Zeolite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition LIGNITE = create("lignite", "Lignite veins", "褐煤矿脉", vein -> {
        vein.weight(160);
        vein.clusterSize(50);
        vein.density(0.6F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD);
        vein.heightRangeUniform(80, 140);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(EPCoreMaterials.Lignite, 3)
                .rareBlock(GTMaterials.Coal, 1)
                .rareBlockChance(0.1F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(EPCoreMaterials.Lignite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition APATITE = create("apatite", "Apatite veins", "磷灰石矿脉", vein -> {
        vein.weight(60);
        vein.clusterSize(25);
        vein.density(0.3F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST);
        vein.heightRangeUniform(-10, 60);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(2).mat(GTMaterials.Apatite).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.TricalciumPhosphate).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Pyrochlore).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Apatite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition BASALTIC_MINERAL_SAND =
            create("basaltic_mineral_sand", "Basaltic mineral sand veins", "玄武岩矿砂矿脉", vein -> {
                vein.weight(80);
                vein.clusterSize(30);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(OVERWORLD);
                vein.heightRangeUniform(30, 60);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(2).mat(GTMaterials.BasalticMineralSand).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.GraniticMineralSand).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.FullersEarth).size(1, 2))
                        .layer(l -> l.weight(1).mat(GTMaterials.Gypsum).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.BasalticMineralSand)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition MAGNETITE = create("magnetite", "Magnetite veins", "磁铁矿脉", vein -> {
        vein.weight(160);
        vein.clusterSize(40);
        vein.density(0.9F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, MARS);
        vein.heightRangeUniform(50, 180);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Magnetite, 3)
                .oreBlock(GTMaterials.Iron, 1)
                .rareBlock(GTMaterials.VanadiumMagnetite, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Magnetite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition GARNET_SAND =
            create("garnet_sand", "Garnet sand veins", "石榴石砂矿脉", vein -> {
                vein.weight(80);
                vein.clusterSize(30);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(OVERWORLD);
                vein.heightRangeUniform(30, 60);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(2).mat(GTMaterials.GarnetSand).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.Cassiterite).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Asbestos).size(1, 2))
                        .layer(l -> l.weight(1).mat(GTMaterials.Diatomite).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.GarnetSand)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition SALT = create("salt", "Salt veins", "盐矿脉", vein -> {
        vein.weight(50);
        vein.clusterSize(30);
        vein.density(0.4F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(OVERWORLD, TWILIGHT_FOREST, MARS);
        vein.heightRangeUniform(40, 70);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(2).mat(GTMaterials.Salt).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.RockSalt).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Lepidolite).size(1, 2))
                .layer(l -> l.weight(1).mat(GTMaterials.Spodumene).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Salt)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition CASSITERITE =
            create("cassiterite", "Cassiterite veins", "锡石矿脉", vein -> {
                vein.weight(50);
                vein.clusterSize(30);
                vein.density(0.4F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(OVERWORLD, TWILIGHT_FOREST, MOON, IO, VENUS);
                vein.heightRangeUniform(80, 220);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(2).mat(GTMaterials.Cassiterite).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Tin).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Cassiterite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition OLIVINE = create("olivine", "Olivine veins", "橄榄石矿脉", vein -> {
        vein.weight(60);
        vein.clusterSize(45);
        vein.density(0.45F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(TWILIGHT_FOREST, CERES);
        vein.heightRangeUniform(-40, 20);
        vein.dikeVeinGenerator(generator -> generator
                .withBlock(GTMaterials.Bentonite, 2, 0, 20)
                .withBlock(GTMaterials.Magnesite, 2, -20, 10)
                .withBlock(GTMaterials.Olivine, 2, -40, -10)
                .withBlock(GTMaterials.Calcite, 1, -40, 20));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Olivine)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition MOLYBDENUM =
            create("molybdenum", "Molybdenum veins", "钼矿脉", vein -> {
                vein.weight(10);
                vein.clusterSize(30);
                vein.density(0.5F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(TWILIGHT_FOREST, MOON, CERES, MERCURY);
                vein.heightRangeUniform(-30, 40);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Wulfenite, 2, 10, 40)
                        .withBlock(GTMaterials.Molybdenite, 2, -10, 30)
                        .withBlock(GTMaterials.Molybdenum, 2, -30, 0)
                        .withBlock(GTMaterials.Powellite, 1, -30, 40));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Molybdenum)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition SAPPHIRE = create("sapphire", "Sapphire veins", "蓝宝石矿脉", vein -> {
        vein.weight(60);
        vein.clusterSize(45);
        vein.density(0.45F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(TWILIGHT_FOREST);
        vein.heightRangeUniform(-40, 20);
        vein.dikeVeinGenerator(generator -> generator
                .withBlock(GTMaterials.Almandine, 2, 0, 20)
                .withBlock(GTMaterials.Pyrope, 2, -20, 10)
                .withBlock(GTMaterials.Sapphire, 2, -40, -10)
                .withBlock(GTMaterials.GreenSapphire, 1, -40, 20));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Sapphire)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition LEAD = create("lead", "Lead veins", "铅矿脉", vein -> {
        vein.weight(40);
        vein.clusterSize(40);
        vein.density(0.35F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(TWILIGHT_FOREST);
        vein.heightRangeUniform(-30, 20);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                .layer(l -> l.weight(3).mat(GTMaterials.Galena).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Silver).size(1, 2))
                .layer(l -> l.weight(2).mat(GTMaterials.Lead).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Lead)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition NICKEL = create("nickel", "Nickel veins", "镍矿脉", vein -> {
        vein.weight(40);
        vein.clusterSize(40);
        vein.density(0.35F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(TWILIGHT_FOREST);
        vein.heightRangeUniform(-30, 20);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                .layer(l -> l.weight(2).mat(GTMaterials.Garnierite).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Nickel).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Cobaltite).size(1, 1))
                .layer(l -> l.weight(1).mat(GTMaterials.Pentlandite).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Nickel)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition QUARTZITE =
            create("quartzite", "Quartzite veins", "石英岩矿脉", vein -> {
                vein.weight(20);
                vein.clusterSize(40);
                vein.density(0.35F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(MOON, MARS, IO, VENUS);
                vein.heightRangeUniform(-30, 60);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(2).mat(GTMaterials.Quartzite).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.Barite).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.CertusQuartz).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.CertusQuartz).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Quartzite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition MONAZITE = create("monazite", "Monazite veins", "独居石矿脉", vein -> {
        vein.weight(20);
        vein.clusterSize(40);
        vein.density(0.35F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(MOON, DEIMOS, CERES, IO, VENUS);
        vein.heightRangeUniform(-30, 60);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                .layer(l -> l.weight(2).mat(GTMaterials.Bastnasite).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Bastnasite).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Monazite).size(1, 1))
                .layer(l -> l.weight(1).mat(GTMaterials.Neodymium).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Monazite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition ILMENITE = create("ilmenite", "Ilmenite veins", "钛铁矿脉", vein -> {
        vein.weight(16);
        vein.clusterSize(35);
        vein.density(0.4F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(MOON, CERES, MERCURY);
        vein.heightRangeUniform(-10, 60);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(2).mat(GTMaterials.Ilmenite).size(2, 4))
                .layer(l -> l.weight(1).mat(GTMaterials.Chromite).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Ilmenite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition BAUXITE = create("bauxite", "Bauxite veins", "铝土矿脉", vein -> {
        vein.weight(16);
        vein.clusterSize(35);
        vein.density(0.4F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(MOON, CERES, MERCURY);
        vein.heightRangeUniform(-40, 60);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                .layer(l -> l.weight(2).mat(GTMaterials.Bauxite).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Ilmenite).size(1, 1))
                .layer(l -> l.weight(1).mat(GTMaterials.Aluminium).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Bauxite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition GALENA = create("galena", "Galena veins", "方铅矿脉", vein -> {
        vein.weight(40);
        vein.clusterSize(40);
        vein.density(0.35F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(MOON, MARS, VENUS);
        vein.heightRangeUniform(-40, 10);
        vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                .layer(l -> l.weight(3).mat(GTMaterials.Galena).size(2, 4))
                .layer(l -> l.weight(2).mat(GTMaterials.Silver).size(1, 2))
                .layer(l -> l.weight(2).mat(GTMaterials.Lead).size(1, 1))));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Galena)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition SULFUR_SMALL =
            create("sulfur_small", "Sulfur veins", "硫矿脉", vein -> {
                vein.weight(100);
                vein.clusterSize(35);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(5, 40);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(3).mat(GTMaterials.Sulfur).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.Pyrite).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.Sphalerite).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Sulfur)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition MOLYBDENUM_SMALL =
            create("molybdenum_small", "Molybdenum veins", "钼矿脉", vein -> {
                vein.weight(10);
                vein.clusterSize(30);
                vein.density(0.5F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER, END);
                vein.heightRangeUniform(20, 60);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Wulfenite, 2, 40, 60)
                        .withBlock(GTMaterials.Molybdenite, 2, 30, 50)
                        .withBlock(GTMaterials.Molybdenum, 2, 20, 40)
                        .withBlock(GTMaterials.Powellite, 1, 20, 60));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Molybdenum)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition REDSTONE_SMALL =
            create("redstone_small", "Redstone veins", "红石矿脉", vein -> {
                vein.weight(60);
                vein.clusterSize(30);
                vein.density(0.25F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(5, 40);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(3).mat(GTMaterials.Redstone).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Ruby).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.Cinnabar).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Redstone)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition COPPER_SMALL =
            create("copper_small", "Copper veins", "铜矿脉", vein -> {
                vein.weight(80);
                vein.clusterSize(50);
                vein.density(1F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER, END);
                vein.heightRangeUniform(5, 60);
                vein.veinedVeinGenerator(generator -> generator
                        .oreBlock(GTMaterials.Chalcopyrite, 3)
                        .oreBlock(GTMaterials.Pyrite, 2)
                        .oreBlock(GTMaterials.Iron, 1)
                        .rareBlock(GTMaterials.Copper, 1)
                        .rareBlockChance(0.075F)
                        .veininessThreshold(0.1F)
                        .maxRichnessThreshold(0.175F)
                        .minRichness(0.4F)
                        .maxRichness(0.7F)
                        .edgeRoundoffBegin(3)
                        .maxEdgeRoundoff(0.1));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Chalcopyrite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition IRON_SMALL = create("iron_small", "Iron veins", "铁矿脉", vein -> {
        vein.weight(120);
        vein.clusterSize(50);
        vein.density(1F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(NETHER);
        vein.heightRangeUniform(10, 40);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Goethite, 3)
                .oreBlock(GTMaterials.YellowLimonite, 2)
                .oreBlock(GTMaterials.Hematite, 2)
                .rareBlock(GTMaterials.Malachite, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Goethite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });
    public static GTOreDefinition BERYLLIUM_SMALL =
            create("beryllium_small", "Beryllium veins", "铍矿脉", vein -> {
                vein.weight(30);
                vein.clusterSize(20);
                vein.density(0.4F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(5, 60);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(3).mat(GTMaterials.Beryllium).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Emerald).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.Thorium).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Beryllium)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition ELECTROTINE_SMALL =
            create("electrotine_small", "Electrotine veins", "蓝石矿脉", vein -> {
                vein.weight(40);
                vein.clusterSize(35);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(5, 50);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(2).mat(GTMaterials.Saltpeter).size(1, 2))
                        .layer(l -> l.weight(2).mat(GTMaterials.Diatomite).size(1, 2))
                        .layer(l -> l.weight(2).mat(GTMaterials.Electrotine).size(1, 2))
                        .layer(l -> l.weight(1).mat(GTMaterials.Alunite).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Electrotine)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition TETRAHEDRITE_SMALL =
            create("tetrahedrite_small", "Tetrahedrite veins", "黝铜矿脉", vein -> {
                vein.weight(80);
                vein.clusterSize(50);
                vein.density(1F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER, END);
                vein.heightRangeUniform(80, 120);
                vein.veinedVeinGenerator(generator -> generator
                        .oreBlock(GTMaterials.Tetrahedrite, 3)
                        .oreBlock(GTMaterials.Copper, 2)
                        .rareBlock(GTMaterials.Stibnite, 1)
                        .rareBlockChance(0.125F)
                        .veininessThreshold(0.1F)
                        .maxRichnessThreshold(0.175F)
                        .minRichness(0.4F)
                        .maxRichness(0.7F)
                        .edgeRoundoffBegin(3)
                        .maxEdgeRoundoff(0.1));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Chalcopyrite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition NETHER_QUARTZ_SMALL =
            create("nether_quartz_small", "Nether Quartz veins", "下界石英矿脉", vein -> {
                vein.weight(40);
                vein.clusterSize(35);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(40, 80);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(3).mat(GTMaterials.NetherQuartz).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Quartzite).size(1, 2))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.NetherQuartz)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition QUARTZITE_SMALL =
            create("quartzite_small", "Quartzite veins", "石英岩矿脉", vein -> {
                vein.weight(40);
                vein.clusterSize(35);
                vein.density(0.3F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER);
                vein.heightRangeUniform(80, 120);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(2).mat(GTMaterials.Quartzite).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.CertusQuartz).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.Barite).size(1, 2))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.NetherQuartz)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });
    public static GTOreDefinition MANGANESE_SMALL =
            create("manganese_small", "Manganese veins", "锰矿脉", vein -> {
                vein.weight(20);
                vein.clusterSize(40);
                vein.density(0.8F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(NETHER, END);
                vein.heightRangeUniform(20, 30);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Grossular, 2, 26, 30)
                        .withBlock(GTMaterials.Spessartine, 2, 24, 28)
                        .withBlock(GTMaterials.Pyrolusite, 2, 20, 25)
                        .withBlock(GTMaterials.Tantalite, 1, 20, 30));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Grossular)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition GOLD_SMALL = create("gold_small", "Gold veins", "金矿脉", vein -> {
        vein.weight(160);
        vein.clusterSize(40);
        vein.density(0.9F);
        vein.layer(EPCoreWorldGenLayers.ALL);
        vein.dimensions(END);
        vein.heightRangeUniform(20, 40);
        vein.veinedVeinGenerator(generator -> generator
                .oreBlock(GTMaterials.Magnetite, 3)
                .oreBlock(GTMaterials.VanadiumMagnetite, 1)
                .rareBlock(GTMaterials.Gold, 1)
                .rareBlockChance(0.075F)
                .veininessThreshold(0.1F)
                .maxRichnessThreshold(0.175F)
                .minRichness(0.4F)
                .maxRichness(0.7F)
                .edgeRoundoffBegin(3)
                .maxEdgeRoundoff(0.1));
        vein.surfaceIndicatorGenerator(indicator -> indicator
                .surfaceRock(GTMaterials.Magnetite)
                .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
    });

    public static GTOreDefinition MAGNETITE_SMALL =
            create("magnetite_small", "Magnetite veins", "磁铁矿脉", vein -> {
                vein.weight(160);
                vein.clusterSize(40);
                vein.density(0.9F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(20, 100);
                vein.veinedVeinGenerator(generator -> generator
                        .oreBlock(GTMaterials.Magnetite, 3)
                        .oreBlock(GTMaterials.Iron, 1)
                        .rareBlock(GTMaterials.VanadiumMagnetite, 1)
                        .rareBlockChance(0.075F)
                        .veininessThreshold(0.1F)
                        .maxRichnessThreshold(0.175F)
                        .minRichness(0.4F)
                        .maxRichness(0.7F)
                        .edgeRoundoffBegin(3)
                        .maxEdgeRoundoff(0.1));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Magnetite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition CASSITERITE_SMALL =
            create("cassiterite_small", "Cassiterite veins", "锡石矿脉", vein -> {
                vein.weight(50);
                vein.clusterSize(30);
                vein.density(0.4F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(50, 130);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(patten -> patten
                        .layer(l -> l.weight(2).mat(GTMaterials.Cassiterite).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Tin).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Cassiterite)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition OLIVINE_SMALL =
            create("olivine_small", "Olivine veins", "橄榄石矿脉", vein -> {
                vein.weight(60);
                vein.clusterSize(45);
                vein.density(0.45F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(10, 40);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Bentonite, 2, 30, 40)
                        .withBlock(GTMaterials.Magnesite, 2, 20, 35)
                        .withBlock(GTMaterials.Olivine, 2, 10, 20)
                        .withBlock(GTMaterials.Calcite, 1, 10, 40));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Olivine)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition NICKEL_SMALL =
            create("nickel_small", "Nickel veins", "镍矿脉", vein -> {
                vein.weight(40);
                vein.clusterSize(40);
                vein.density(0.35F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(20, 50);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(2).mat(GTMaterials.Garnierite).size(2, 4))
                        .layer(l -> l.weight(2).mat(GTMaterials.Nickel).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Cobaltite).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.Pentlandite).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Nickel)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static GTOreDefinition LAPIS_SMALL =
            create("lapis_small", "Lapis veins", "青金石矿脉", vein -> {
                vein.weight(50);
                vein.clusterSize(45);
                vein.density(0.25F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(30, 70);
                vein.dikeVeinGenerator(generator -> generator
                        .withBlock(GTMaterials.Lazurite, 3, 50, 70)
                        .withBlock(GTMaterials.Sodalite, 2, 40, 60)
                        .withBlock(GTMaterials.Lapis, 2, 30, 40)
                        .withBlock(GTMaterials.Calcite, 1, 30, 70));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Lapis)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
                        .density(0.15F)
                        .radius(3));
            });

    public static GTOreDefinition SCHEELITE_SMALL =
            create("scheelite_small", "Scheelite veins", "白钨矿脉", vein -> {
                vein.weight(40);
                vein.clusterSize(40);
                vein.density(0.35F);
                vein.layer(EPCoreWorldGenLayers.ALL);
                vein.dimensions(END);
                vein.heightRangeUniform(20, 60);
                vein.layeredVeinGenerator(generator -> generator.buildLayerPattern(pattern -> pattern
                        .layer(l -> l.weight(2).mat(GTMaterials.Scheelite).size(2, 4))
                        .layer(l -> l.weight(1).mat(GTMaterials.Tungstate).size(1, 1))
                        .layer(l -> l.weight(1).mat(GTMaterials.Lithium).size(1, 1))));
                vein.surfaceIndicatorGenerator(indicator -> indicator
                        .surfaceRock(GTMaterials.Nickel)
                        .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE));
            });

    public static void init() {}

    private static GTOreDefinition create(
            String key, String en_name, String cn_name, Consumer<GTOreDefinition> consumer) {
        ALL_ORES.add(new OreTranslate(key, en_name, cn_name));
        return GTOres.create(EPCoreMod.id(key), consumer);
    }

    public static void removeOreVeins() {
        Set.copyOf(GTRegistries.ORE_VEINS.keys()).forEach(rl -> {
            if (!rl.getNamespace().equals(EPCoreMod.MODID)) GTRegistries.ORE_VEINS.remove(rl);
        });
    }

    public record OreTranslate(String key, String en_name, String cn_name) {
        public String getTranslateKey() {
            return "gtceu.jei.ore_vein." + key;
        }
    }
}
