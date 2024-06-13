package cn.dancingsnow.epcore.data.tag;

import cn.dancingsnow.epcore.common.data.EPCoreTags;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import earth.terrarium.adastra.common.tags.ModItemTags;

public class EPCoreTagHandler {
    public static void init(RegistrateItemTagsProvider provider) {
        provider.addTag(EPCoreTags.Items.NANO_SPACE_SUITE)
                .add(GTItems.NANO_HELMET.get())
                .add(GTItems.NANO_CHESTPLATE.get())
                .add(GTItems.NANO_CHESTPLATE_ADVANCED.get())
                .add(GTItems.NANO_LEGGINGS.get())
                .add(GTItems.NANO_BOOTS.get());

        provider.addTag(EPCoreTags.Items.QUANTUM_SPACE_SUITE)
                .add(GTItems.QUANTUM_HELMET.get())
                .add(GTItems.QUANTUM_CHESTPLATE.get())
                .add(GTItems.QUANTUM_CHESTPLATE_ADVANCED.get())
                .add(GTItems.QUANTUM_LEGGINGS.get())
                .add(GTItems.QUANTUM_BOOTS.get());

        provider.addTag(ModItemTags.SPACE_SUITS)
                .addTag(EPCoreTags.Items.NANO_SPACE_SUITE)
                .addTag(EPCoreTags.Items.QUANTUM_SPACE_SUITE);

        provider.addTag(ModItemTags.HEAT_RESISTANT_ARMOR)
                .addTag(EPCoreTags.Items.NANO_SPACE_SUITE)
                .addTag(EPCoreTags.Items.QUANTUM_SPACE_SUITE);
    }
}
