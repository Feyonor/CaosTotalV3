package com.feyonor.caostaotal.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.feyonor.caostaotal.CaosTotalMod;

public class CaosItems {
    // Libro del Caos
    public static final Item CHAOS_BOOK = registerItem("chaos_book", new Item(new Item.Settings()));

    // Armas
    public static final Item CHAOS_GRENADE = registerItem("chaos_grenade", new Item(new Item.Settings()));
    public static final Item ROCKET_LAUNCHER = registerItem("rocket_launcher", new Item(new Item.Settings().maxDamage(64)));
    public static final Item BAZOOKA = registerItem("bazooka", new Item(new Item.Settings().maxDamage(64)));
    public static final Item CHAOS_ROCKET = registerItem("chaos_rocket", new Item(new Item.Settings()));

    // Armaduras
    public static final Item ANTI_EXPLOSION_HELMET = registerItem("anti_explosion_helmet", new Item(new Item.Settings()));
    public static final Item ANTI_EXPLOSION_CHESTPLATE = registerItem("anti_explosion_chestplate", new Item(new Item.Settings()));
    public static final Item ANTI_EXPLOSION_LEGGINGS = registerItem("anti_explosion_leggings", new Item(new Item.Settings()));
    public static final Item ANTI_EXPLOSION_BOOTS = registerItem("anti_explosion_boots", new Item(new Item.Settings()));

    // Armadura Suprema (no crafteable)
    public static final Item SUPREME_CHAOS_HELMET = registerItem("supreme_chaos_helmet", new Item(new Item.Settings()));
    public static final Item SUPREME_CHAOS_CHESTPLATE = registerItem("supreme_chaos_chestplate", new Item(new Item.Settings()));
    public static final Item SUPREME_CHAOS_LEGGINGS = registerItem("supreme_chaos_leggings", new Item(new Item.Settings()));
    public static final Item SUPREME_CHAOS_BOOTS = registerItem("supreme_chaos_boots", new Item(new Item.Settings()));

    // Cajas Sorpresa
    public static final Item CHAOS_CHEST = registerItem("chaos_chest", new Item(new Item.Settings()));

    // Mechero del Caos
    public static final Item CHAOS_LIGHTER = registerItem("chaos_lighter", new Item(new Item.Settings().maxDamage(16)));

    // Rey Creeper
    public static final Item CREEPER_KING_SPAWN_EGG = registerItem("creeper_king_spawn_egg", new Item(new Item.Settings()));

    public static void registerItems() {
        // Items registrados automáticamente en la inicialización
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CaosTotalMod.MOD_ID, name), item);
    }
}