package com.feyonor.caostaotal.dimension;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import com.feyonor.caostaotal.CaosTotalMod;

public class ChaosDimension {
    public static final Identifier CHAOS_DIMENSION_ID = new Identifier(CaosTotalMod.MOD_ID, "chaos");
    public static DimensionType CHAOS_TYPE;

    public static void register() {
        // La dimensión se registrará automáticamente cuando se acceda al mundo
        CaosTotalMod.LOGGER.info("Dimensión del Caos registrada!");
    }

    public static Identifier getDimensionId() {
        return CHAOS_DIMENSION_ID;
    }
}
