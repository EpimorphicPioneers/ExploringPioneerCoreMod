package cn.dancingsnow.epcore.data.provider;

import cn.dancingsnow.epcore.EPCore;

import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;

import java.util.Collections;

public abstract class CodecProvider<T> extends JsonCodecProvider<T> {

    public CodecProvider(
            PackOutput output,
            ExistingFileHelper existingFileHelper,
            PackType packType,
            ResourceKey<Registry<T>> registry,
            Codec<T> codec) {
        super(
                output,
                existingFileHelper,
                EPCore.MOD_ID,
                JsonOps.INSTANCE,
                packType,
                registry.location().getPath(),
                codec,
                Collections.emptyMap());
    }

    public CodecProvider(
            PackOutput output,
            ExistingFileHelper existingFileHelper,
            ResourceKey<Registry<T>> registry,
            Codec<T> codec) {
        super(
                output,
                existingFileHelper,
                EPCore.MOD_ID,
                JsonOps.INSTANCE,
                PackType.SERVER_DATA,
                registry.location().getPath(),
                codec,
                Collections.emptyMap());
    }
}
