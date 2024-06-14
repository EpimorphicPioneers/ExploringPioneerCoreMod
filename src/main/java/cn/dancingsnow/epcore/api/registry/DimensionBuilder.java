package cn.dancingsnow.epcore.api.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

public class DimensionBuilder extends KeyRegisterBuilder<LevelStem> {
    public DimensionBuilder(ResourceKey<LevelStem> key, Object... args) {
        super(key, args);
    }

    @Override
    public LevelStem build() {
        return null;
    }
}
