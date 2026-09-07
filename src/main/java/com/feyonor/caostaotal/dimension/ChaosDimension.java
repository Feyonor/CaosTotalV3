package com.feyonor.caostaotal.dimension;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionTypes;
import com.feyonor.caostaotal.CaosTotalMod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChaosDimension {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-dimension");
    public static final Identifier CHAOS_DIMENSION_ID = new Identifier(CaosTotalMod.MOD_ID, "chaos");
    public static DimensionType CHAOS_TYPE;

    public static void register() {
        LOGGER.info("✨ Registrando Dimensión del Caos...");
        
        // Crear un tipo de dimensión similar al Nether
        CHAOS_TYPE = DimensionType.create(
            java.util.Optional.empty(), // respawn anchor works
            true, // has ceiling (como Nether)
            true, // has raids
            true, // natural
            false, // bed works
            1.0, // coordinate scale
            true, // piglin safe
            false, // has sky light
            true, // has enderdragon fight
            false, // min y
            256, // max y
            256, // logical height
            DimensionTypes.INFINIBURN_OVERWORLD, // infiniburn
            CHAOS_DIMENSION_ID, // effect location
            1.0f, // ambient light
            new net.minecraft.world.dimension.DimensionType.MonsterSettings(
                false, // piglin safe
                false, // has raids
                java.util.OptionalInt.empty(), // monster spawn block tag (empty = default)
                0 // monster spawn light level
            )
        );
        
        LOGGER.info("🌍 Dimensión del Caos registrada correctamente!");
    }

    public static Identifier getDimensionId() {
        return CHAOS_DIMENSION_ID;
    }

    public static DimensionType getChaosType() {
        return CHAOS_TYPE;
    }
}
