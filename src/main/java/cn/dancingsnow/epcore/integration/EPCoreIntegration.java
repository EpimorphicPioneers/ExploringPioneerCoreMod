package cn.dancingsnow.epcore.integration;

import cn.dancingsnow.epcore.api.EPCoreValues;

import net.minecraft.resources.ResourceLocation;

public class EPCoreIntegration {
    public static ResourceLocation ad(String path) {
        return new ResourceLocation(EPCoreValues.MODID_AD_ASTRA, path);
    }
}
