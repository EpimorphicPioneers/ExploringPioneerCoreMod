package cn.dancingsnow.epcore.api.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.OptionalLong;
import java.util.function.BiConsumer;

@Setter
@Accessors(fluent = true, chain = true)
public class DimensionTypeBuilder extends KeyRegisterBuilder<DimensionType> {
    private OptionalLong fixedTime = OptionalLong.empty();
    private boolean hasSkyLight = true;
    private boolean hasCeiling;
    private boolean ultrawarm;
    private boolean natural = true;
    private double coordinateScale = 1.0;
    private boolean bedWorks = true;
    private boolean respawnAnchorWorks;
    private int minY = -64;
    private int height = 384;
    private int logicalHeight = 384;
    private TagKey<Block> infiniburn = BlockTags.INFINIBURN_OVERWORLD;
    private ResourceLocation effects = BuiltinDimensionTypes.OVERWORLD_EFFECTS;
    private float ambientLight = 0.0F;
    private boolean piglinSafe;
    private boolean hasRaids = true;
    private IntProvider monsterSpawnLightTest = UniformInt.of(0, 7);
    private int monsterSpawnBlockLightLimit = 0;

    protected DimensionTypeBuilder(ResourceKey<DimensionType> key) {
        super(key);
    }

    public static DimensionTypeBuilder of(ResourceKey<DimensionType> key) {
        return new DimensionTypeBuilder(key);
    }

    public DimensionType build() {
        return new DimensionType(
                fixedTime,
                hasSkyLight,
                hasCeiling,
                ultrawarm,
                natural,
                coordinateScale,
                bedWorks,
                respawnAnchorWorks,
                minY,
                height,
                logicalHeight,
                infiniburn,
                effects,
                ambientLight,
                new DimensionType.MonsterSettings(
                        piglinSafe, hasRaids, monsterSpawnLightTest, monsterSpawnBlockLightLimit));
    }

    public void buildAndRegister(BiConsumer<ResourceKey<DimensionType>, DimensionType> registrar) {
        registrar.accept(key, build());
    }
}
