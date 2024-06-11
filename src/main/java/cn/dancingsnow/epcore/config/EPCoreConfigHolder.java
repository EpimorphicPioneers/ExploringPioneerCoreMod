package cn.dancingsnow.epcore.config;

import cn.dancingsnow.epcore.EPCoreMod;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = EPCoreMod.MODID)
public class EPCoreConfigHolder {
    public static EPCoreConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(EPCoreConfigHolder.class, ConfigFormats.yaml())
                    .getConfigInstance();
        }
    }
}
