package cn.dancingsnow.epcore;



import cn.dancingsnow.epcore.data.worldgen.EPCoreOreVeins;
import com.epimorphismmc.monomorphism.MOGTAddon;

import com.gregtechceu.gtceu.api.addon.GTAddon;

@GTAddon
public class EPCoreGTAddon extends MOGTAddon {

    public EPCoreGTAddon() {
        super(EPCoreMod.MODID);
    }

    @Override
    public void initializeAddon() {}

    @Override
    public void registerOreVeins() {
        super.registerOreVeins();
        EPCoreOreVeins.init();
    }
}
