package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreTagPrefixes;


import cn.dancingsnow.epcore.data.worldgen.EPCoreOreVeins;
import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

public class EPCoreLangHandler {

    private EPCoreLangHandler() {
        /**/
    }

    public static void init(MOLangProvider provider) {
        EPCoreOreVeins.ALL_ORES.forEach(
                ore -> provider.add(ore.getTranslateKey(), ore.en_name(), ore.cn_name()));
        EPCoreTagPrefixes.ALL_TAG_PREFIXES.forEach(
                tag -> provider.add(tag.getTranslateKey(), tag.en_lang(), tag.cn_lang()));
    }
}
