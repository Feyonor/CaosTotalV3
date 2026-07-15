package com.feyonor.caostotal.recipe;

import net.fabricmc.fabric.api.recipe.v1.compat.vanilla.RecipeManagerHelper;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import com.feyonor.caostotal.CaosTotalMod;
import com.feyonor.caostotal.item.CaosTotalItems;

public class CaosTotalRecipes {
    
    public static void register() {
        CaosTotalMod.LOGGER.info("Registrando recetas de Caos Total...");
    }
    
    // Los crafteos se definen en JSON en src/main/resources/data/caostotal/recipes/
    // Este archivo solo indica que existen
}
