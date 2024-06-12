package cn.dancingsnow.epcore.common.materials;

import static cn.dancingsnow.epcore.common.data.EPCoreMaterials.*;
import static cn.dancingsnow.epcore.common.data.EPCoreMaterials.Builder;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.FLAMMABLE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.MORTAR_GRINDABLE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.LIGNITE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class SecondDegreeMaterials {

    private SecondDegreeMaterials() {}

    public static void register() {
        Vermiculite = Builder("vermiculite")
                .ore()
                .dust()
                .color(0xE7E088)
                .components(Iron, 3, /*Alumina, 10,*/ Silicon, 4, Water, 4, Oxygen, 6, Hydrogen, 2)
                .buildAndRegister();

        Lignite = Builder("lignite")
                .gem(1, 1200)
                .ore(2, 1)
                .color(0x513939)
                .iconSet(LIGNITE)
                .flags(FLAMMABLE, NO_SMASHING, MORTAR_GRINDABLE)
                .components(Carbon, 3, Water, 1)
                .buildAndRegister();
    }
}
