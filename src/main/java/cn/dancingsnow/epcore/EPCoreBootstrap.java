package cn.dancingsnow.epcore;

import cn.dancingsnow.epcore.client.EPCoreClient;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(EPCore.MOD_ID)
public class EPCoreBootstrap {
    public EPCoreBootstrap() {
        DistExecutor.unsafeRunForDist(() -> EPCoreClient::new, () -> EPCoreServer::new);
    }
}
