package cn.dancingsnow.epcore;

import com.epimorphismmc.monomorphism.utility.DistLogger;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public interface EPCore {
    String MOD_ID = "epcore";
    String NAME = "ExploringPioneerCoreMod";

    Logger LOGGER = new DistLogger(NAME);

    static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, FormattingUtil.toLowerCaseUnder(path));
    }
}
