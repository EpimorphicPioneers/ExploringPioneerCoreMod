package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreBlocks;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

public class EPCoreBlockLang {
    public static void init(MOLangProvider provider) {
        provider.addBlockName(EPCoreBlocks.DEIMOS_SURFACE, "Deimos Surface", "火卫二地表岩石");
        provider.addBlockName(EPCoreBlocks.DEIMOS_STONE, "Deimos Stone", "火卫二地底岩石");

        provider.addBlockName(EPCoreBlocks.CERES_SURFACE, "Ceres Surface", "谷神星地表岩石");
        provider.addBlockName(EPCoreBlocks.CERES_STONE, "Ceres Stone", "谷神星地底岩石");

        provider.addBlockName(EPCoreBlocks.GANYMEDE_SURFACE, "Ganymede Surface", "木卫三地表岩石");
        provider.addBlockName(EPCoreBlocks.GANYMEDE_STONE, "Ganymede Stone", "木卫三地底岩石");

        provider.addBlockName(EPCoreBlocks.IO_SURFACE, "IO Surface", "木卫一地表岩石");
        provider.addBlockName(EPCoreBlocks.IO_STONE, "IO Stone", "木卫一地底岩石");
        provider.addBlockName(EPCoreBlocks.IO_ASH, "IO Ash", "木卫一灰烬");
    }
}
