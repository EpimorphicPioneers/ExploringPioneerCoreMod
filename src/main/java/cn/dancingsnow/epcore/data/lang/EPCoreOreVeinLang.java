package cn.dancingsnow.epcore.data.lang;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

public class EPCoreOreVeinLang {
    public static void init(MOLangProvider provider) {
        addOreVeinLang(provider, "diamond", "Diamond veins", "钻石矿脉");
        addOreVeinLang(provider, "lapis", "Lapis veins", "青金石矿脉");
        addOreVeinLang(provider, "iron", "Iron veins", "铁矿脉");
        addOreVeinLang(provider, "vermiculite", "Vermiculite veins", "蛭石矿脉");
        addOreVeinLang(provider, "oil_sand", "Oil sand veins", "油砂矿脉");
        addOreVeinLang(provider, "coal", "Coal veins", "煤矿脉");
        addOreVeinLang(provider, "manganese", "Manganese veins", "锰矿脉");
        addOreVeinLang(provider, "redstone", "Redstone veins", "红石矿脉");
        addOreVeinLang(provider, "mica", "Mica veins", "云母矿脉");
        addOreVeinLang(provider, "copper", "Copper veins", "铜矿脉");
        addOreVeinLang(provider, "talc", "Talc veins", "滑石矿脉");
        addOreVeinLang(provider, "gold", "Gold veins", "金矿脉");
        addOreVeinLang(provider, "zeolite", "Zeolite veins", "沸石矿脉");
        addOreVeinLang(provider, "lignite", "Lignite veins", "褐煤矿脉");
        addOreVeinLang(provider, "apatite", "Apatite veins", "磷灰石矿脉");
        addOreVeinLang(provider, "basaltic_mineral_sand", "Basaltic mineral sand veins", "玄武岩矿砂矿脉");
        addOreVeinLang(provider, "magnetite", "Magnetite veins", "磁铁矿脉");
        addOreVeinLang(provider, "garnet_sand", "Garnet sand veins", "石榴石砂矿脉");
        addOreVeinLang(provider, "salt", "Salt veins", "盐矿脉");
        addOreVeinLang(provider, "cassiterite", "Cassiterite veins", "锡石矿脉");
        addOreVeinLang(provider, "olivine", "Olivine veins", "橄榄石矿脉");
        addOreVeinLang(provider, "molybdenum", "Molybdenum veins", "钼矿脉");
        addOreVeinLang(provider, "sapphire", "Sapphire veins", "蓝宝石矿脉");
        addOreVeinLang(provider, "lead", "Lead veins", "铅矿脉");
        addOreVeinLang(provider, "nickel", "Nickel veins", "镍矿脉");
        addOreVeinLang(provider, "quartzite", "Quartzite veins", "石英岩矿脉");
        addOreVeinLang(provider, "monazite", "Monazite veins", "独居石矿脉");
        addOreVeinLang(provider, "ilmenite", "Ilmenite veins", "钛铁矿脉");
        addOreVeinLang(provider, "bauxite", "Bauxite veins", "铝土矿脉");
        addOreVeinLang(provider, "galena", "Galena veins", "方铅矿脉");
        addOreVeinLang(provider, "sulfur_small", "Sulfur veins", "硫矿脉");
        addOreVeinLang(provider, "molybdenum_small", "Molybdenum veins", "钼矿脉");
        addOreVeinLang(provider, "redstone_small", "Redstone veins", "红石矿脉");
        addOreVeinLang(provider, "copper_small", "Copper veins", "铜矿脉");
        addOreVeinLang(provider, "iron_small", "Iron veins", "铁矿脉");
        addOreVeinLang(provider, "beryllium_small", "Beryllium veins", "铍矿脉");
        addOreVeinLang(provider, "electrotine_small", "Electrotine veins", "蓝石矿脉");
        addOreVeinLang(provider, "tetrahedrite_small", "Tetrahedrite veins", "黝铜矿脉");
        addOreVeinLang(provider, "nether_quartz_small", "Nether Quartz veins", "下界石英矿脉");
        addOreVeinLang(provider, "quartzite_small", "Quartzite veins", "石英岩矿脉");
        addOreVeinLang(provider, "manganese_small", "Manganese veins", "锰矿脉");
        addOreVeinLang(provider, "gold_small", "Gold veins", "金矿脉");
        addOreVeinLang(provider, "magnetite_small", "Magnetite veins", "磁铁矿脉");
        addOreVeinLang(provider, "cassiterite_small", "Cassiterite veins", "锡石矿脉");
        addOreVeinLang(provider, "olivine_small", "Olivine veins", "橄榄石矿脉");
        addOreVeinLang(provider, "nickel_small", "Nickel veins", "镍矿脉");
        addOreVeinLang(provider, "lapis_small", "Lapis veins", "青金石矿脉");
        addOreVeinLang(provider, "scheelite_small", "Scheelite veins", "白钨矿脉");
    }

    public static void addOreVeinLang(
            MOLangProvider provider, String key, String en_name, String cn_name) {
        provider.add("gtceu.jei.ore_vein." + key, en_name, cn_name);
    }
}
