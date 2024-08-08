package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreBlocks;
import cn.dancingsnow.epcore.common.data.EPCoreDimensionMarkers;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

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

        provider.addBlockName(EPCoreDimensionMarkers.MOON_MARKER, "Moon", "月球");
        provider.addBlockName(EPCoreDimensionMarkers.MARS_MARKER, "Mars", "火星");
        provider.addBlockName(EPCoreDimensionMarkers.VENUS_MARKER, "Venus", "金星");
        provider.addBlockName(EPCoreDimensionMarkers.MERCURY_MARKER, "Mercury", "水星");
        provider.addBlockName(EPCoreDimensionMarkers.GLACIO_MARKER, "Glacio", "寒霜");

        provider.addBlockName(EPCoreDimensionMarkers.DEIMOS_MARKER, "Deimos", "火卫二");
        provider.addBlockName(EPCoreDimensionMarkers.CERES_MARKER, "Ceres", "谷神星");
        provider.addBlockName(EPCoreDimensionMarkers.GANYMEDE_MARKER, "Ganymede", "木卫三");
        provider.addBlockName(EPCoreDimensionMarkers.IO_MARKER, "IO", "木卫一");
    }
}
