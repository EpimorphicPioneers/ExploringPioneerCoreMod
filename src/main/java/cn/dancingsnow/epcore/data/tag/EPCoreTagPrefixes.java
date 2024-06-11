package cn.dancingsnow.epcore.data.tag;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import earth.terrarium.adastra.AdAstra;
import earth.terrarium.adastra.common.registry.ModBlocks;

import java.util.HashSet;
import java.util.Set;

public class EPCoreTagPrefixes {
    public static final Set<TagPrefixTranslate> ALL_TAG_PREFIXES = new HashSet<>();

    public static final TagPrefix oreMoonStone = oreTagPrefix(
                    "moon_stone", "Moon Stone %s Ore", "月石%s矿石")
            .registerOre(
                    () -> ModBlocks.MOON_STONE.get().defaultBlockState(),
                    () -> GTMaterials.Stone,
                    BlockBehaviour.Properties.of()
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 3.0f)
                            .mapColor(MapColor.STONE),
                    new ResourceLocation(AdAstra.MOD_ID, "block/moon_stone"));

    private static TagPrefix oreTagPrefix(String name, String en_lang, String cn_lang) {
        ALL_TAG_PREFIXES.add(new TagPrefixTranslate(name, en_lang, cn_lang));
        return TagPrefix.oreTagPrefix(name, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public record TagPrefixTranslate(String name, String en_lang, String cn_lang) {
        public String getTranslateKey() {
            return "tagprefix." + name;
        }
    }

    public static void init() {}
}
