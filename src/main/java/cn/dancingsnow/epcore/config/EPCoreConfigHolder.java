package cn.dancingsnow.epcore.config;

import cn.dancingsnow.epcore.EPCore;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = EPCore.MOD_ID)
public class EPCoreConfigHolder {
    public static EPCoreConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(EPCoreConfigHolder.class, ConfigFormats.yaml())
                    .getConfigInstance();
        }
    }
}
