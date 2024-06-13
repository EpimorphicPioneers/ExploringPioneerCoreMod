package cn.dancingsnow.epcore.api.registry;

import cn.dancingsnow.epcore.EPCoreMod;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.registrate.BuilderBase;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Objects;
import java.util.function.Supplier;

@Setter
@Accessors(fluent = true, chain = true)
public class OreTagPrefixBuilder extends BuilderBase<TagPrefix> {
    private final TagPrefix base;

    private Supplier<BlockState> stateSupplier;

    private Supplier<Material> materialSupplier;

    private ResourceLocation baseModelLocation;

    private Supplier<BlockBehaviour.Properties> templateProperties;

    private boolean doubleDrops;

    private boolean isSand;

    private boolean shouldDropAsItem;

    protected OreTagPrefixBuilder(ResourceLocation id, TagKey<Block> miningToolTag, Object... args) {
        super(id, args);
        this.base = TagPrefix.oreTagPrefix(id.getPath(), miningToolTag);
    }

    protected OreTagPrefixBuilder(ResourceLocation id, TagPrefix base, Object... args) {
        super(id, args);
        this.base = base;
    }

    public static OreTagPrefixBuilder create(String name, TagKey<Block> miningToolTag) {
        return new OreTagPrefixBuilder(EPCoreMod.id(name), miningToolTag);
    }

    public static OreTagPrefixBuilder create(TagPrefix base) {
        return new OreTagPrefixBuilder(EPCoreMod.id(base.name()), base);
    }

    @Override
    public TagPrefix register() {
        this.value = base.registerOre(
                Objects.requireNonNull(stateSupplier, "State Supplier is not set."),
                materialSupplier,
                Objects.requireNonNullElse(templateProperties, () -> null),
                Objects.requireNonNull(baseModelLocation, "Base Model Location is not set."),
                doubleDrops,
                isSand,
                shouldDropAsItem);
        return value;
    }
}
