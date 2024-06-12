package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.worldgen.EPCoreOreVeins;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

public class EPCoreLangHandler {

    private EPCoreLangHandler() {}

    public static void init(MOLangProvider provider) {
        EPCoreBlockLang.init(provider);
        EPCoreWorldLang.init(provider);

        EPCoreOreVeins.ALL_ORES.forEach(
                ore -> provider.add(ore.getTranslateKey(), ore.en_name(), ore.cn_name()));
    }
}
