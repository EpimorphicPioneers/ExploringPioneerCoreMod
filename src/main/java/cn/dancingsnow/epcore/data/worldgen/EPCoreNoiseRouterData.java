package cn.dancingsnow.epcore.data.worldgen;

import cn.dancingsnow.epcore.EPCoreMod;
import cn.dancingsnow.epcore.integration.EPCoreIntegration;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class EPCoreNoiseRouterData {

    private static final HolderOwner<DensityFunction> HOLDER_OWNER = new HolderOwner<>() {
        @Override
        public boolean canSerializeIn(HolderOwner<DensityFunction> owner) {
            return true;
        }
    };

    private static final ResourceKey<DensityFunction> AD_BASE3D_NOISE = ad("base_3d_noise");
    private static final ResourceKey<DensityFunction> AD_CRATERS = ad("craters");
    private static final ResourceKey<DensityFunction> AD_DEPTH = ad("depth");
    private static final ResourceKey<DensityFunction> AD_FACTOR = ad("factor");
    private static final ResourceKey<DensityFunction> AD_SLOPED_CHEESE = ad("sloped_cheese");

    private static final ResourceKey<DensityFunction> SHIFT_X = mc("shift_x");
    private static final ResourceKey<DensityFunction> SHIFT_Z = mc("shift_z");
    private static final ResourceKey<DensityFunction> Y = mc("y");

    private static final ResourceKey<DensityFunction> CONTINENTS = mc("overworld/continents");
    private static final ResourceKey<DensityFunction> EROSION = mc("overworld/erosion");
    private static final ResourceKey<DensityFunction> RIDGES = mc("overworld/ridges");

    private static final ResourceKey<DensityFunction> ENTRANCES = mc("overworld/caves/entrances");
    private static final ResourceKey<DensityFunction> NOODLE = mc("overworld/caves/noodle");
    private static final ResourceKey<DensityFunction> PILLARS = mc("overworld/caves/pillars");

    private static final ResourceKey<DensityFunction> SPAGHETTI_ROUGHNESS_FUNCTION =
            mc("overworld/caves/spaghetti_roughness_function");
    private static final ResourceKey<DensityFunction> SPAGHETTI_2D =
            mc("overworld/caves/spaghetti_2d");

    private static ResourceKey<DensityFunction> register(String name) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, EPCoreMod.id(name));
    }

    private static ResourceKey<DensityFunction> ad(String name) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, EPCoreIntegration.ad(name));
    }

    private static ResourceKey<DensityFunction> mc(String name) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(name));
    }

    public static void bootstrap(BootstapContext<DensityFunction> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
    }

    private static DensityFunction registerAndWrap(
            BootstapContext<DensityFunction> context,
            ResourceKey<DensityFunction> key,
            DensityFunction densityFunction) {
        return new DensityFunctions.HolderHolder(context.register(key, densityFunction));
    }

    private static DensityFunction getFunction(
            HolderGetter<DensityFunction> densityFunctions, ResourceKey<DensityFunction> key) {
        return new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(key));
    }

    private static DensityFunction getFunctionUnsafe(ResourceKey<DensityFunction> key) {
        return new DensityFunctions.HolderHolder(Holder.Reference.createStandAlone(HOLDER_OWNER, key));
    }

    public static class PlanetNoiseRouterBuilder {
        private final HolderGetter<DensityFunction> densityFunctions;
        private final HolderGetter<NormalNoise.NoiseParameters> noises;
        private double barrierXZScale = 1;
        private double barrierYScale = 0.5;

        private double floodednessXZScale = 1;
        private double floodednessYScale = 0.67;

        private double spreadXZScale = 1;
        private double spreadYScale = 0.7142857142857143;

        private double lavaXZScale = 1;
        private double lavaYScale = 1;

        private double temperatureXZScale = 0.25;

        private double vegetationXZScale = 0.25;

        private double initialDensityFactor = 4;

        private double veinToggleXZScale = 1.5;
        private double veinToggleYScale = 1.5;

        private double veinRidgedXZScale = 4;
        private double veinRidgedYScale = 4;

        private double veinRidgedFactor = -0.07999999821186066;

        private double veinGapXZScale = 1;
        private double veinGapYScale = 1;

        private double veinYMinInclusive = -60;
        private double veinYMaxExclusive = 51;

        protected PlanetNoiseRouterBuilder(HolderGetter<DensityFunction> densityFunctions,
                                         HolderGetter<NormalNoise.NoiseParameters> noises) {

            this.densityFunctions = densityFunctions;
            this.noises = noises;
        }

        public static PlanetNoiseRouterBuilder of(HolderGetter<DensityFunction> densityFunctions,
                                                  HolderGetter<NormalNoise.NoiseParameters> noises) {
            return new PlanetNoiseRouterBuilder(densityFunctions, noises);
        }

        public PlanetNoiseRouterBuilder barrierNoiseScale(double xzScale, double yScale) {
            this.barrierXZScale = xzScale;
            this.barrierYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder fluidLevelFloodednessNoiseScale(double xzScale, double yScale) {
            this.floodednessXZScale = xzScale;
            this.floodednessYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder fluidLevelSpreadNoiseScale(double xzScale, double yScale) {
            this.spreadXZScale = xzScale;
            this.spreadYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder lavaNoiseScale(double xzScale, double yScale) {
            this.lavaXZScale = xzScale;
            this.lavaYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder temperatureNoiseScale(double xzScale) {
            this.temperatureXZScale = xzScale;
            return this;
        }

        public PlanetNoiseRouterBuilder vegetationNoiseScale(double xzScale) {
            this.vegetationXZScale = xzScale;
            return this;
        }

        public PlanetNoiseRouterBuilder initialDensityFactor(double factor) {
            this.initialDensityFactor = factor;
            return this;
        }

        public PlanetNoiseRouterBuilder veinToggleNoiseScale(double xzScale, double yScale) {
            this.veinToggleXZScale = xzScale;
            this.veinToggleYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder veinRidgedNoiseScale(double xzScale, double yScale) {
            this.veinRidgedXZScale = xzScale;
            this.veinRidgedYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder veinGapNoiseScale(double xzScale, double yScale) {
            this.veinGapXZScale = xzScale;
            this.veinGapYScale = yScale;
            return this;
        }

        public PlanetNoiseRouterBuilder veinRidgedFactor(double factor) {
            this.veinRidgedFactor = factor;
            return this;
        }

        public PlanetNoiseRouterBuilder veinRange(double minInclusive, double maxExclusive) {
            this.veinYMinInclusive = minInclusive;
            this.veinYMaxExclusive = maxExclusive;
            return this;
        }

        public NoiseRouter build() {
            var barrierNoise = DensityFunctions.noise(noises.getOrThrow(Noises.AQUIFER_BARRIER), barrierXZScale, barrierYScale);
            var fluidLevelFloodednessNoise =
                    DensityFunctions.noise(noises.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), floodednessXZScale, floodednessYScale);
            var fluidLevelSpreadNoise = DensityFunctions.noise(
                    noises.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), spreadXZScale, spreadYScale);
            var lavaNoise = DensityFunctions.noise(noises.getOrThrow(Noises.AQUIFER_LAVA), lavaXZScale, lavaYScale);
            var temperature = DensityFunctions.shiftedNoise2d(
                    getFunction(densityFunctions, SHIFT_X),
                    getFunction(densityFunctions, SHIFT_Z),
                    temperatureXZScale,
                    noises.getOrThrow(Noises.TEMPERATURE));
            var vegetation = DensityFunctions.shiftedNoise2d(
                    getFunction(densityFunctions, SHIFT_X),
                    getFunction(densityFunctions, SHIFT_Z),
                    vegetationXZScale,
                    noises.getOrThrow(Noises.VEGETATION));
            var continents = getFunction(densityFunctions, CONTINENTS);
            var erosion = getFunction(densityFunctions, EROSION);
            var depth = getFunctionUnsafe(AD_DEPTH);
            var ridges = getFunction(densityFunctions, RIDGES);
            var initialDensityWithoutJaggedness = DensityFunctions.mul(
                    DensityFunctions.constant(initialDensityFactor),
                    DensityFunctions.mul(
                                    getFunctionUnsafe(AD_DEPTH), DensityFunctions.cache2d(getFunctionUnsafe(AD_FACTOR)))
                            .quarterNegative());
            var finalDensity = DensityFunctions.max(
                    DensityFunctions.yClampedGradient(-64, -63, 1, -1),
                    DensityFunctions.min(
                            getFunction(densityFunctions, NOODLE),
                            DensityFunctions.mul(
                                            DensityFunctions.constant(0.64),
                                            DensityFunctions.interpolated(
                                                    DensityFunctions.blendDensity(DensityFunctions.add(
                                                            DensityFunctions.constant(-10),
                                                            DensityFunctions.mul(
                                                                    DensityFunctions.yClampedGradient(297, 320, 1, 0),
                                                                    DensityFunctions.add(
                                                                            DensityFunctions.constant(10),
                                                                            DensityFunctions.rangeChoice(
                                                                                    getFunctionUnsafe(AD_SLOPED_CHEESE),
                                                                                    -1000000,
                                                                                    1.5625,
                                                                                    DensityFunctions.min(
                                                                                            getFunctionUnsafe(AD_SLOPED_CHEESE),
                                                                                            DensityFunctions.mul(
                                                                                                    DensityFunctions.constant(5),
                                                                                                    getFunction(densityFunctions, ENTRANCES))),
                                                                                    DensityFunctions.max(
                                                                                            DensityFunctions.rangeChoice(
                                                                                                    getFunction(densityFunctions, PILLARS),
                                                                                                    -1000000,
                                                                                                    0.03,
                                                                                                    DensityFunctions.constant(-1000000),
                                                                                                    getFunction(densityFunctions, PILLARS)),
                                                                                            DensityFunctions.min(
                                                                                                    DensityFunctions.add(
                                                                                                            getFunction(densityFunctions, SPAGHETTI_2D),
                                                                                                            getFunction(
                                                                                                                    densityFunctions,
                                                                                                                    SPAGHETTI_ROUGHNESS_FUNCTION)),
                                                                                                    DensityFunctions.min(
                                                                                                            getFunction(densityFunctions, ENTRANCES),
                                                                                                            DensityFunctions.add(
                                                                                                                    DensityFunctions.mul(
                                                                                                                            DensityFunctions.constant(4),
                                                                                                                            DensityFunctions.noise(
                                                                                                                                            noises.getOrThrow(
                                                                                                                                                    Noises.CAVE_LAYER),
                                                                                                                                            1,
                                                                                                                                            8)
                                                                                                                                    .square()),
                                                                                                                    DensityFunctions.add(
                                                                                                                            DensityFunctions.add(
                                                                                                                                            DensityFunctions.constant(0.27),
                                                                                                                                            DensityFunctions.noise(
                                                                                                                                                    noises.getOrThrow(
                                                                                                                                                            Noises.CAVE_CHEESE),
                                                                                                                                                    1,
                                                                                                                                                    0.6666666666666666))
                                                                                                                                    .clamp(-1, 1),
                                                                                                                            DensityFunctions.add(
                                                                                                                                            DensityFunctions.constant(1.5),
                                                                                                                                            DensityFunctions.mul(
                                                                                                                                                    DensityFunctions.constant(
                                                                                                                                                            -0.64),
                                                                                                                                                    getFunctionUnsafe(
                                                                                                                                                            AD_SLOPED_CHEESE)))
                                                                                                                                    .clamp(0, 0.5)))))))))))))
                                    .squeeze()));
            var veinToggle = DensityFunctions.interpolated(DensityFunctions.rangeChoice(
                    getFunction(densityFunctions, Y),
                    veinYMinInclusive,
                    veinYMaxExclusive,
                    DensityFunctions.noise(noises.getOrThrow(Noises.ORE_VEININESS), veinToggleXZScale, veinToggleYScale),
                    DensityFunctions.zero()));
            var veinRidged = DensityFunctions.add(
                    DensityFunctions.constant(veinRidgedFactor),
                    DensityFunctions.max(
                            DensityFunctions.interpolated(DensityFunctions.rangeChoice(
                                            getFunction(densityFunctions, Y),
                                            veinYMinInclusive,
                                            veinYMaxExclusive,
                                            DensityFunctions.noise(noises.getOrThrow(Noises.ORE_VEIN_A), veinRidgedXZScale, veinRidgedYScale),
                                            DensityFunctions.zero())
                                    .abs()),
                            DensityFunctions.interpolated(DensityFunctions.rangeChoice(
                                            getFunction(densityFunctions, Y),
                                            veinYMinInclusive,
                                            veinYMaxExclusive,
                                            DensityFunctions.noise(noises.getOrThrow(Noises.ORE_VEIN_A), veinRidgedXZScale, veinRidgedYScale),
                                            DensityFunctions.zero())
                                    .abs())));
            var veinGap = DensityFunctions.noise(noises.getOrThrow(Noises.ORE_GAP), veinGapXZScale, veinGapYScale);
            return new NoiseRouter(
                    barrierNoise,
                    fluidLevelFloodednessNoise,
                    fluidLevelSpreadNoise,
                    lavaNoise,
                    temperature,
                    vegetation,
                    continents,
                    erosion,
                    depth,
                    ridges,
                    initialDensityWithoutJaggedness,
                    finalDensity,
                    veinToggle,
                    veinRidged,
                    veinGap);
        }
    }
}
