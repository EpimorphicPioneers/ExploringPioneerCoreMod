package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.common.worldgen.AnyMatchRuleTest;

import com.gregtechceu.gtceu.api.data.worldgen.IWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.SimpleWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.WorldGeneratorUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.common.tags.ModBlockTags;

import java.util.List;
import java.util.Set;

public class EPCoreWorldGenLayers {
    public static final IWorldGenLayer ALL = new SimpleWorldGenLayer(
            "all",
            () -> new AnyMatchRuleTest(List.of(
                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                    new TagMatchTest(BlockTags.NETHER_CARVER_REPLACEABLES),
                    WorldGeneratorUtils.END_ORE_REPLACEABLES,
                    new TagMatchTest(ModBlockTags.MOON_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.VENUS_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.MARS_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.MERCURY_STONE_REPLACEABLES),
                    new TagMatchTest(ModBlockTags.GLACIO_STONE_REPLACEABLES))),
            Set.of(
                    Level.OVERWORLD.location(),
                    Level.NETHER.location(),
                    Level.END.location(),
                    new ResourceLocation(AdAstra.MOD_ID, "moon"),
                    new ResourceLocation(AdAstra.MOD_ID, "mars"),
                    new ResourceLocation(AdAstra.MOD_ID, "venus"),
                    new ResourceLocation(AdAstra.MOD_ID, "mercury"),
                    new ResourceLocation(AdAstra.MOD_ID, "glacio")));

    public static void init() {}
}
