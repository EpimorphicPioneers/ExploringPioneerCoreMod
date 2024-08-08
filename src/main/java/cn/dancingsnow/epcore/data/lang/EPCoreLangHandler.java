package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreTagPrefixes;
import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

public class EPCoreLangHandler {

    private EPCoreLangHandler() {
    }

    public static void init(MOLangProvider provider) {
        EPCoreBlockLang.init(provider);
        EPCoreMaterialLang.init(provider);
        EPCoreWorldLang.init(provider);
        EPCoreOreVeinLang.init(provider);

        EPCoreTagPrefixes.ALL_TAG_PREFIXES.forEach(
                prefix -> provider.add(prefix.getTranslateKey(), prefix.en_lang(), prefix.cn_lang()));
    }
}
