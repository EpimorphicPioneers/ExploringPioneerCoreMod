package cn.dancingsnow.epcore.common.data;

import cn.dancingsnow.epcore.common.data.materials.SecondDegreeMaterials;
import cn.dancingsnow.epcore.common.data.materials.TwilightForestMaterials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

public class EPCoreMaterials {

    public static Material SteelLeaf;
    public static Material Vermiculite;
    public static Material Lignite;

    private EPCoreMaterials() {}

    public static void init() {
        SecondDegreeMaterials.register();
        TwilightForestMaterials.register();
    }

    public static Material.Builder Builder(String name) {
        return new Material.Builder(GTCEu.id(name));
    }
}
