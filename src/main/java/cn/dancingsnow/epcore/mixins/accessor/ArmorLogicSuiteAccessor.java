package cn.dancingsnow.epcore.mixins.accessor;

import com.gregtechceu.gtceu.api.item.armor.ArmorLogicSuite;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ArmorLogicSuite.class, remap = false)
public interface ArmorLogicSuiteAccessor {
    @Accessor
    int getTier();

    @Accessor
    long getMaxCapacity();
}
