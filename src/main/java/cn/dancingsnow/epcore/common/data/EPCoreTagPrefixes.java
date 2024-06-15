package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.api.registry.builder.OreTagPrefixBuilder;
import cn.dancingsnow.epcore.integration.EPCoreIntegration;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.tags.BlockTags;

import earth.terrarium.adastra.common.registry.ModBlocks;

import java.util.HashSet;
import java.util.Set;

public class EPCoreTagPrefixes {
    public static final Set<TagPrefixTranslate> ALL_TAG_PREFIXES = new HashSet<>();

    public static final TagPrefix oreMoonStone = oreTagPrefix(
                    "moon_stone", "Moon Stone %s Ore", "月石%s矿石")
            .stateSupplier(() -> ModBlocks.MOON_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreIntegration.ad("block/moon_stone"))
            .register();

    public static final TagPrefix oreVenusStone = oreTagPrefix(
                    "venus_stone", "Venus Stone %s Ore", "金星石%s矿石")
            .stateSupplier(() -> ModBlocks.VENUS_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreIntegration.ad("block/venus_stone"))
            .register();

    public static final TagPrefix oreMarsStone = oreTagPrefix(
                    "mars_stone", "Mars Stone %s Ore", "火星石%s矿石")
            .stateSupplier(() -> ModBlocks.MARS_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreIntegration.ad("block/mars_stone"))
            .register();

    public static final TagPrefix oreMercuryStone = oreTagPrefix(
                    "mercury_stone", "Mercury Stone %s Ore", "水星石%s矿石")
            .stateSupplier(() -> ModBlocks.MERCURY_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreIntegration.ad("block/mercury_stone"))
            .register();

    public static final TagPrefix oreGlacioStone = oreTagPrefix(
                    "glacio_stone", "Glacio Stone %s Ore", "霜原石%s矿石")
            .stateSupplier(() -> ModBlocks.GLACIO_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreIntegration.ad("block/glacio_stone"))
            .register();

    //    public static final TagPrefix oreMoonStone = oreTagPrefix("holystone", "ore", "月石%s矿石")
    //            .stateSupplier(() -> .get().defaultBlockState())
    //            .baseModelLocation("aether:block/holystone")

    public static final TagPrefix oreDeimosStone = oreTagPrefix(
                    "deimos_stone", "Deimos Stone %s Ore", "火卫二%s矿石")
            .stateSupplier(() -> EPCoreBlocks.DEIMOS_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreMod.id("block/deimos_stone"))
            .register();

    public static final TagPrefix oreCeresStone = oreTagPrefix(
                    "ceres_stone", "Ceres Stone %s Ore", "谷神星%s矿石")
            .stateSupplier(() -> EPCoreBlocks.CERES_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreMod.id("block/ceres_stone"))
            .register();

    public static final TagPrefix oreGanymedeStone = oreTagPrefix(
                    "ganymede_stone", "Ganymede Stone %s Ore", "木卫三%s矿石")
            .stateSupplier(() -> EPCoreBlocks.GANYMEDE_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreMod.id("block/ganymede_stone"))
            .register();

    public static final TagPrefix oreIoStone = oreTagPrefix("io_stone", "Io Stone %s Ore", "木卫一%s矿石")
            .stateSupplier(() -> EPCoreBlocks.IO_STONE.get().defaultBlockState())
            .materialSupplier(() -> GTMaterials.Stone)
            .baseModelLocation(EPCoreMod.id("block/io_stone"))
            .register();

    private static OreTagPrefixBuilder oreTagPrefix(String name, String en_lang, String cn_lang) {
        ALL_TAG_PREFIXES.add(new TagPrefixTranslate(name, en_lang, cn_lang));
        return OreTagPrefixBuilder.of(name, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public record TagPrefixTranslate(String name, String en_lang, String cn_lang) {
        public String getTranslateKey() {
            return "tagprefix." + name;
        }
    }

    public static void init() {}
}
