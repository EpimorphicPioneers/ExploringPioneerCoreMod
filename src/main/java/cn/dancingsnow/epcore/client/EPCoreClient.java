package cn.dancingsnow.epcore.client;

import cn.dancingsnow.epcore.EPCoreCommon;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.common.MinecraftForge;

public class EPCoreClient extends EPCoreCommon {
    public EPCoreClient() {
        super();
        MinecraftForge.EVENT_BUS.addListener(EPCoreClient::onRenderGui);
    }

    public static void onRenderGui(RenderGuiEvent.Post event) {
        OverlayScreen.render(event.getGuiGraphics(), event.getPartialTick());
    }
}
