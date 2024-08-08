package cn.dancingsnow.epcore;

import cn.dancingsnow.epcore.common.data.EPCoreTagPrefixes;
import cn.dancingsnow.epcore.common.data.worldgen.EPCoreOreVeins;

import cn.dancingsnow.epcore.common.data.worldgen.EPCoreWorldGenLayers;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

@GTAddon
public class EPCoreGTAddon implements IGTAddon {


    @Override
    public String addonModId() {
        return EPCore.MOD_ID;
    }

    @Override
    public GTRegistrate getRegistrate() {
        return EPCoreCommon.registrate();
    }

    @Override
    public void initializeAddon() {}

    @Override
    public void registerOreVeins() {
        EPCoreOreVeins.init();
    }

    @Override
    public void registerWorldgenLayers() {
        EPCoreWorldGenLayers.init();
    }

    @Override
    public void registerTagPrefixes() {
        EPCoreTagPrefixes.init();
    }
}
