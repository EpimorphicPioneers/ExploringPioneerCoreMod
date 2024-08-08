package cn.dancingsnow.epcore.common.data;

import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.common.data.GTDimensionMarkers;
import com.tterrag.registrate.util.entry.BlockEntry;
import earth.terrarium.adastra.api.planets.Planet;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.world.level.block.Block;

import static cn.dancingsnow.epcore.EPCoreCommon.registrate;


public class EPCoreDimensionMarkers {
    //AdAstra Markers
    public static final BlockEntry<Block> MOON_MARKER = createMarker("moon");
    public static final BlockEntry<Block> MARS_MARKER = createMarker("mars");
    public static final BlockEntry<Block> VENUS_MARKER = createMarker("venus");
    public static final BlockEntry<Block> MERCURY_MARKER = createMarker("mercury");
    public static final BlockEntry<Block> GLACIO_MARKER = createMarker("glacio");

    public static final BlockEntry<Block> DEIMOS_MARKER = createMarker("deimos");
    public static final BlockEntry<Block> CERES_MARKER = createMarker("ceres");
    public static final BlockEntry<Block> GANYMEDE_MARKER = createMarker("ganymede");
    public static final BlockEntry<Block> IO_MARKER = createMarker("io");

    public static final DimensionMarker MOON = GTDimensionMarkers.createAndRegister(Planet.MOON.location(), 1, () -> MOON_MARKER, null);
    public static final DimensionMarker MARS = GTDimensionMarkers.createAndRegister(Planet.MARS.location(), 2, () -> MARS_MARKER, null);
    public static final DimensionMarker VENUS = GTDimensionMarkers.createAndRegister(Planet.VENUS.location(), 4, () -> VENUS_MARKER, null);
    public static final DimensionMarker MERCURY = GTDimensionMarkers.createAndRegister(Planet.MERCURY.location(), 4, () -> MERCURY_MARKER, null);
    public static final DimensionMarker GLACIO = GTDimensionMarkers.createAndRegister(Planet.GLACIO.location(), 5, () -> GLACIO_MARKER, null);

    public static final DimensionMarker DEIMOS = GTDimensionMarkers.createAndRegister(EPCorePlanets.DEIMOS.location(), 2, () -> DEIMOS_MARKER, null);
    public static final DimensionMarker CERES = GTDimensionMarkers.createAndRegister(EPCorePlanets.CERES.location(), 3, () -> CERES_MARKER, null);
    public static final DimensionMarker GANYMEDE = GTDimensionMarkers.createAndRegister(EPCorePlanets.GANYMEDE.location(), 3, () -> GANYMEDE_MARKER, null);
    public static final DimensionMarker IO = GTDimensionMarkers.createAndRegister(EPCorePlanets.IO.location(), 4, () -> IO_MARKER, null);

    private static BlockEntry<Block> createMarker(String name) {
        return registrate().block("%s_marker".formatted(name), Block::new)
                .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models().cube(ctx.getName(),
                                provider.modLoc("block/dim_markers/%s/down".formatted(name)),
                                provider.modLoc("block/dim_markers/%s/up".formatted(name)),
                                provider.modLoc("block/dim_markers/%s/north".formatted(name)),
                                provider.modLoc("block/dim_markers/%s/south".formatted(name)),
                                provider.modLoc("block/dim_markers/%s/east".formatted(name)),
                                provider.modLoc("block/dim_markers/%s/west".formatted(name)))
                        .texture("particle", "#north")
                        .guiLight(BlockModel.GuiLight.FRONT)
                ))
                .simpleItem()
                .register();
    }

    public static void init() {
    }
}
