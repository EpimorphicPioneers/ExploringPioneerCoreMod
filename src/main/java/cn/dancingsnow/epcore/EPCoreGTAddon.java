package cn.dancingsnow.epcore;

import cn.dancingsnow.epcore.data.worldgen.EPCoreOreVeins;

import com.epimorphismmc.monomorphism.MOGTAddon;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import java.util.Set;

@GTAddon
public class EPCoreGTAddon extends MOGTAddon {

    public EPCoreGTAddon() {
        super(EPCoreMod.MODID);
    }

    @Override
    public void initializeAddon() {}

    @Override
    public void registerOreVeins() {
        Set.copyOf(GTRegistries.ORE_VEINS.keys()).forEach(GTRegistries.ORE_VEINS::remove);
        EPCoreOreVeins.init();
    }
}
