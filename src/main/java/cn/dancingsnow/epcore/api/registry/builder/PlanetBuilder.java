package cn.dancingsnow.epcore.api.registry.builder;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import earth.terrarium.adastra.api.planets.Planet;
import earth.terrarium.adastra.common.constants.PlanetConstants;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Setter
@Accessors(fluent = true, chain = true)
public class PlanetBuilder extends RegisterBuilder<Planet> {

    private ResourceKey<Level> dimension;
    private boolean oxygen;
    private int temperature;
    private float gravity;
    private int solarPower;
    private ResourceLocation solarSystem;
    private ResourceKey<Level> orbitDimension;
    private Planet orbit;
    private int tier;
    private List<ResourceKey<Level>> additionalLaunchDimensions;

    protected PlanetBuilder(ResourceLocation id, Object... args) {
        super(id, args);
    }

    public static PlanetBuilder of(ResourceLocation id) {
        return new PlanetBuilder(id);
    }

    public PlanetBuilder orbit(Consumer<OrbitBuilder> consumer) {
        var builder = new OrbitBuilder();
        consumer.accept(builder);
        this.orbit = builder.build();
        this.orbitDimension = orbit.dimension();
        return this;
    }

    @Override
    public Planet register() {
        Validate.exclusiveBetween(
                Short.MIN_VALUE,
                Short.MAX_VALUE,
                temperature,
                "Temperature must be between %s and %s".formatted(Short.MIN_VALUE, Short.MAX_VALUE));
        return new Planet(
                dimension,
                oxygen,
                (short) temperature,
                gravity,
                solarPower,
                Objects.requireNonNull(solarSystem, "Solar System is not set."),
                Optional.ofNullable(orbitDimension),
                tier,
                Objects.requireNonNullElseGet(additionalLaunchDimensions, Collections::emptyList));
    }

    @Override
    public void buildAndRegister(BiConsumer<ResourceLocation, Planet> registrar) {
        super.buildAndRegister(registrar);
        if (orbit != null) {
            registrar.accept(orbitDimension.location(), orbit);
        }
    }

    @Setter
    @Accessors(fluent = true, chain = true)
    public class OrbitBuilder {
        private ResourceKey<Level> dimension;
        private int solarPower;
        private ResourceLocation galaxy;
        private int tier;

        protected OrbitBuilder() {}

        protected Planet build() {
            return new Planet(
                    Objects.requireNonNull(dimension, "Dimension is not set."),
                    false,
                    PlanetConstants.SPACE_TEMPERATURE,
                    PlanetConstants.SPACE_GRAVITY,
                    solarPower,
                    Objects.requireNonNullElse(
                            galaxy, Objects.requireNonNull(solarSystem, "Galaxy is not set.")),
                    Optional.empty(),
                    tier,
                    Collections.emptyList());
        }
    }
}
