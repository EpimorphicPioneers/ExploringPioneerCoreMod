package cn.dancingsnow.epcore.data.provider;

import cn.dancingsnow.epcore.EPCoreMod;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class CodecProvider<T> implements DataProvider {

    private final PackOutput.PathProvider pathProvider;
    private final Codec<T> codec;

    public CodecProvider(PackOutput packOutput, Codec<T> codec, ResourceKey<Registry<T>> registry) {
        this(packOutput, codec, registry, PackOutput.Target.DATA_PACK);
    }

    public CodecProvider(PackOutput packOutput, Codec<T> codec, ResourceKey<Registry<T>> registry, PackOutput.Target target) {
        this.pathProvider = packOutput.createPathProvider(target, registry.location().getPath());
        this.codec = codec;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        build((key, value) ->
            futures.add(DataProvider.saveStable(
                output,
                codec.encodeStart(JsonOps.INSTANCE, value).getOrThrow(false, EPCoreMod.logger()::error),
                pathProvider.json(key)
            ))
        );

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    protected abstract void build(BiConsumer<ResourceLocation, T> consumer);
}
