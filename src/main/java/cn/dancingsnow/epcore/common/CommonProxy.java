package cn.dancingsnow.epcore.common;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.common.worldgen.EPCoreRuleTests;
import cn.dancingsnow.epcore.data.worldgen.EPCoreWorldGenLayers;

import com.epimorphismmc.monomorphism.proxy.base.ICommonProxyBase;

import net.minecraftforge.eventbus.api.IEventBus;

public class CommonProxy implements ICommonProxyBase {

    public CommonProxy() {
        EPCoreMod.logger().info("ExampleMod's Initialization Completed!");
    }

    @Override
    public void registerEventHandlers() {}

    @Override
    public void registerCapabilities() {}

    @Override
    public void registerWorldgenLayers() {
        EPCoreWorldGenLayers.init();
    }

    @Override
    public void registerModBusEventHandlers(IEventBus bus) {
        ICommonProxyBase.super.registerModBusEventHandlers(bus);

        EPCoreRuleTests.init(bus);
    }
}
