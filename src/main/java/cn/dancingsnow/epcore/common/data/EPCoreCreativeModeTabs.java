package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.EPCore;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.world.item.CreativeModeTab;

import com.tterrag.registrate.util.entry.RegistryEntry;

import static cn.dancingsnow.epcore.EPCoreCommon.registrate;


public class EPCoreCreativeModeTabs {
    public static final RegistryEntry<CreativeModeTab> EP_CORE = registrate()
            .defaultCreativeTab("core", builder -> builder
                    .displayItems(
                            new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("core", registrate()))
                    .title(registrate().addLang("itemGroup", EPCore.id("core"), EPCore.NAME))
                    .icon(EPCoreBlocks.DEIMOS_STONE::asStack)
                    .build())
            .register();

    public static void init() {}
}
