package cn.dancingsnow.epcore.data.lang;

import cn.dancingsnow.epcore.common.data.EPCoreMaterials;
import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;


public class EPCoreMaterialLang {
    public static void init(MOLangProvider provider) {
        provider.addMaterial(EPCoreMaterials.Lignite, "Lignite Coal", "褐煤");
        provider.addMaterial(EPCoreMaterials.Vermiculite, "Vermiculite", "蛭石");
        provider.addMaterial(EPCoreMaterials.SteelLeaf, "Steel Leaf", "钢叶");
    }
}
