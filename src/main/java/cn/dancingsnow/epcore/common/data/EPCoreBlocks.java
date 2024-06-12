package cn.dancingsnow.epcore.common.data;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;

import com.tterrag.registrate.util.entry.BlockEntry;

import static cn.dancingsnow.epcore.EPCoreMod.registrate;

@SuppressWarnings("unused")
public class EPCoreBlocks {

    static {
        registrate().creativeModeTab(EPCoreCreativeModeTabs.EP_CORE);
    }

    //////////////////////////////////////
    // *****         DEIMOS       ***** //
    //////////////////////////////////////

    public static final BlockEntry<Block> DEIMOS_STONE = registrate()
            .block("deimos_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, EPCoreTags.Blocks.ORE_REPLACEABLES)
            .defaultLoot()
            .simpleItem()
            .register();

    public static final BlockEntry<Block> DEIMOS_SURFACE = registrate()
            .block("deimos_surface", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .defaultLoot()
            .simpleItem()
            .register();

    //////////////////////////////////////
    // *****          CERES       ***** //
    //////////////////////////////////////

    public static final BlockEntry<Block> CERES_STONE = registrate()
            .block("ceres_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, EPCoreTags.Blocks.ORE_REPLACEABLES)
            .defaultLoot()
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CERES_SURFACE = registrate()
            .block("ceres_surface", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .defaultLoot()
            .simpleItem()
            .register();

    //////////////////////////////////////
    // *****        GANYMEDE      ***** //
    //////////////////////////////////////

    public static final BlockEntry<Block> GANYMEDE_STONE = registrate()
            .block("ganymede_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, EPCoreTags.Blocks.ORE_REPLACEABLES)
            .defaultLoot()
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GANYMEDE_SURFACE = registrate()
            .block("ganymede_surface", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .defaultLoot()
            .simpleItem()
            .register();

    //////////////////////////////////////
    // *****           IO         ***** //
    //////////////////////////////////////

    public static final BlockEntry<Block> IO_STONE = registrate()
            .block("io_stone", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, EPCoreTags.Blocks.ORE_REPLACEABLES)
            .defaultLoot()
            .simpleItem()
            .register();

    public static final BlockEntry<Block> IO_SURFACE = registrate()
            .block("io_surface", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .defaultLoot()
            .simpleItem()
            .register();

    public static final BlockEntry<FallingBlock> IO_ASH = registrate()
            .block("io_ash", FallingBlock::new)
            .initialProperties(() -> Blocks.SAND)
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .defaultLoot()
            .simpleItem()
            .register();

    public static void init() {}
}
