package cn.dancingsnow.epcore.common.data.worldgen;

import cn.dancingsnow.epcore.common.data.EPCorePlanets;
import cn.dancingsnow.epcore.common.data.EPCoreTags;
import cn.dancingsnow.epcore.common.worldgen.AnyMatchRuleTest;

import com.gregtechceu.gtceu.api.data.worldgen.IWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.SimpleWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.WorldGeneratorUtils;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import earth.terrarium.adastra.api.planets.Planet;
import earth.terrarium.adastra.common.tags.ModBlockTags;

import java.util.List;
import java.util.Set;

public class EPCoreWorldGenLayers {
    public static final IWorldGenLayer ALL = new SimpleWorldGenLayer(
            "all",
            () -> new AnyMatchRuleTest(
                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                    new TagMatchTest(BlockTags.NETHER_CARVER_REPLACEABLES),
                    WorldGeneratorUtils.END_ORE_REPLACEABLES,
                    new TagMatchTest(ModBlockTags.MOON_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.VENUS_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.MARS_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.MERCURY_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.GLACIO_STONE_REPLACEABLES),
                    new TagMatchTest(EPCoreTags.Blocks.ORE_REPLACEABLES)),
            Set.of(
                    Level.OVERWORLD.location(),
                    Level.NETHER.location(),
                    Level.END.location(),
                    Planet.MOON.location(),
                    Planet.MARS.location(),
                    Planet.VENUS.location(),
                    Planet.MERCURY.location(),
                    Planet.GLACIO.location(),
                    EPCorePlanets.DEIMOS.location(),
                    EPCorePlanets.CERES.location(),
                    EPCorePlanets.GANYMEDE.location(),
                    EPCorePlanets.IO.location()));

    public static void init() {
    }
}
