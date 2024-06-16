package cn.dancingsnow.epcore.api.registry.builder;

import net.minecraft.resources.ResourceKey;

import java.util.function.BiConsumer;

public abstract class KeyRegisterBuilder<T> {

    public final ResourceKey<T> key;
    protected T value = null;

    public KeyRegisterBuilder(ResourceKey<T> key, Object... args) {
        this.key = key;
    }

    public abstract T build();

    public void buildAndRegister(BiConsumer<ResourceKey<T>, T> registrar) {
        registrar.accept(key, build());
    }
}
