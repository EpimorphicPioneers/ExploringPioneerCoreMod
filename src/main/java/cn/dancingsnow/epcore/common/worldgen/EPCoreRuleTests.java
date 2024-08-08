package cn.dancingsnow.epcore.common.worldgen;

import cn.dancingsnow.epcore.EPCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPCoreRuleTests {
    private static final DeferredRegister<RuleTestType<?>> RULE_TEST_TYPES =
            DeferredRegister.create(Registries.RULE_TEST, EPCore.MOD_ID);

    public static final RegistryObject<RuleTestType<AnyMatchRuleTest>> ANY_MATCH =
            RULE_TEST_TYPES.register("any_match", () -> () -> AnyMatchRuleTest.CODEC);

    public static void register(IEventBus bus) {
        RULE_TEST_TYPES.register(bus);
    }
}
