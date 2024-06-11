package cn.dancingsnow.epcore.data;

import cn.dancingsnow.epcore.EPCoreMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EPModTags {
    public static class Items {
        private static TagKey<Item> mc(String path) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(path));
        }

        private static TagKey<Item> mod(String path) {
            return TagKey.create(Registries.ITEM, EPCoreMod.id(path));
        }
    }

    public static class Blocks {

        private static TagKey<Block> mc(String path) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(path));
        }

        private static TagKey<Block> mod(String path) {
            return TagKey.create(Registries.BLOCK, EPCoreMod.id(path));
        }
    }
}
