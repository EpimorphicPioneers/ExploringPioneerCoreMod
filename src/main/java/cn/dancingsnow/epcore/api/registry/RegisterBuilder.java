package cn.dancingsnow.epcore.api.registry;

import com.gregtechceu.gtceu.api.registry.registrate.BuilderBase;

import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public abstract class RegisterBuilder<T> extends BuilderBase<T> {

    public RegisterBuilder(ResourceLocation id, Object... args) {
        super(id, args);
    }

    public void buildAndRegister(BiConsumer<ResourceLocation, T> registrar) {
        registrar.accept(id, register());
    }
}
