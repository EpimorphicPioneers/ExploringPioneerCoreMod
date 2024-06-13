package cn.dancingsnow.epcore;

import cn.dancingsnow.epcore.client.ClientProxy;
import cn.dancingsnow.epcore.common.CommonProxy;
import cn.dancingsnow.epcore.config.EPCoreConfigHolder;
import cn.dancingsnow.epcore.data.lang.EPCoreLangHandler;
import cn.dancingsnow.epcore.data.tag.EPCoreTagHandler;
import cn.dancingsnow.epcore.integration.ad.EPCoreAdAstraEvent;

import com.epimorphismmc.monomorphism.MOMod;
import com.epimorphismmc.monomorphism.datagen.MOProviderTypes;
import com.epimorphismmc.monomorphism.registry.registrate.MORegistrate;

import com.gregtechceu.gtceu.utils.FormattingUtil;

import com.lowdragmc.lowdraglib.networking.INetworking;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import com.tterrag.registrate.providers.ProviderType;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EPCoreMod.MODID)
public class EPCoreMod extends MOMod<CommonProxy> {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "epcore";
    public static final String NAME = "ExploringPioneerCoreMod";

    public static EPCoreMod instance;

    public EPCoreMod() {
        super();
    }

    @Override
    public String getModId() {
        return MODID;
    }

    @Override
    public String getModName() {
        return NAME;
    }

    @Override
    protected void onModConstructed() {
        instance = this;
        EPCoreConfigHolder.init();
        EPCoreAdAstraEvent.init();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected CommonProxy createClientProxy() {
        return new ClientProxy();
    }

    @Override
    @OnlyIn(Dist.DEDICATED_SERVER)
    protected CommonProxy createServerProxy() {
        return new CommonProxy();
    }

    @Override
    public void addDataGenerator(MORegistrate registrate) {
        registrate.addDataGenerator(MOProviderTypes.MO_LANG, EPCoreLangHandler::init);
        registrate.addDataGenerator(ProviderType.ITEM_TAGS, EPCoreTagHandler::init);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MODID, FormattingUtil.toLowerCaseUnder(path));
    }

    public static Logger logger() {
        return instance.getLogger();
    }

    public static CommonProxy proxy() {
        return instance.getProxy();
    }

    public static MORegistrate registrate() {
        return instance.getRegistrate();
    }

    public static INetworking network() {
        return instance.getNetwork();
    }
}
