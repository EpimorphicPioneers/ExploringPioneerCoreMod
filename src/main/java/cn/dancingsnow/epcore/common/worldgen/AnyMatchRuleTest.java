package cn.dancingsnow.epcore.common.worldgen;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;

import com.mojang.serialization.Codec;

import java.util.ArrayList;
import java.util.List;

public class AnyMatchRuleTest extends RuleTest {
    public static final Codec<AnyMatchRuleTest> CODEC = RuleTest.CODEC
            .listOf()
            .fieldOf("rules")
            .xmap(AnyMatchRuleTest::new, t -> t.rules)
            .codec();

    public final List<RuleTest> rules;

    public AnyMatchRuleTest() {
        this(new ArrayList<>());
    }

    public AnyMatchRuleTest(List<RuleTest> rules) {
        this.rules = rules;
    }

    @Override
    public boolean test(BlockState state, RandomSource random) {
        for (RuleTest rule : rules) {
            if (rule.test(state, random)) {
                return true;
            }
        }
        return rules.isEmpty();
    }

    @Override
    protected RuleTestType<?> getType() {
        return EPCoreRuleTests.ANY_MATCH.get();
    }
}
