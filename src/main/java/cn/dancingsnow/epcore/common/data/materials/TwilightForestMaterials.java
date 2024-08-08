package cn.dancingsnow.epcore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;

import static cn.dancingsnow.epcore.common.data.EPCoreMaterials.Builder;
import static cn.dancingsnow.epcore.common.data.EPCoreMaterials.SteelLeaf;

public class TwilightForestMaterials {

    private TwilightForestMaterials() {}

    public static void register() {
        SteelLeaf = Builder("steel_leaf")
                .wood()
                .color(0x518539)
                .toolStats(
                        ToolProperty.Builder.of(12, 6, 614400, 3, GTToolType.SOFT_MALLET).build())
                .buildAndRegister();
    }
}
