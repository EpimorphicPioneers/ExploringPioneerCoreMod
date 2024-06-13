package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreTagPrefixes;
import cn.dancingsnow.epcore.common.data.worldgen.EPCoreOreVeins;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

public class EPCoreLangHandler {

    private EPCoreLangHandler() {}

    public static void init(MOLangProvider provider) {
        EPCoreBlockLang.init(provider);
        EPCoreMaterialLang.init(provider);
        EPCoreWorldLang.init(provider);

        EPCoreOreVeins.ALL_ORES.forEach(
                ore -> provider.add(ore.getTranslateKey(), ore.en_name(), ore.cn_name()));

        EPCoreTagPrefixes.ALL_TAG_PREFIXES.forEach(
                prefix -> provider.add(prefix.getTranslateKey(), prefix.en_lang(), prefix.cn_lang()));
    }
}
