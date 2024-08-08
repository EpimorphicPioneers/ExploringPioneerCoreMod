package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.EPCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EPCoreTags {
    public static class Items {
        public static final TagKey<Item> NANO_SPACE_SUITE = mod("nano_space_suite");
        public static final TagKey<Item> QUANTUM_SPACE_SUITE = mod("quantum_space_suite");

        private static TagKey<Item> mc(String path) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(path));
        }

        private static TagKey<Item> mod(String path) {
            return TagKey.create(Registries.ITEM, EPCore.id(path));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> ORE_REPLACEABLES = mod("ore_replaceables");

        private static TagKey<Block> mc(String path) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(path));
        }

        private static TagKey<Block> mod(String path) {
            return TagKey.create(Registries.BLOCK, EPCore.id(path));
        }
    }
}
