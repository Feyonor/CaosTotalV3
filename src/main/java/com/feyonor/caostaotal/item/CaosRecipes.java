package com.feyonor.caostaotal.item;

import net.fabricmc.fabric.api.recipe.v1.FurnaceRecipeRegistry;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosRecipes {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-recipes");

    public static void registerRecipes() {
        LOGGER.info("Registrando recetas de Caos Total V3...");

        // Las recetas JSON se cargan desde: src/main/resources/data/caostaotal/recipes/
        // Se cargan automáticamente por Fabric
    }
}