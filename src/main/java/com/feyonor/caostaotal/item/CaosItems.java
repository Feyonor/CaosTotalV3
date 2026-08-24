package com.feyonor.caostaotal.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.feyonor.caostaotal.CaosTotalMod;

public class CaosItems {
    
    // Items del Caos
    public static Item CHAOS_LIGHTER;
    public static Item CHAOS_GRENADE;
    public static Item ROCKET_LAUNCHER;
    public static Item BAZOOKA;
    public static Item SURPRISE_BOX;
    public static Item CHAOS_ARMOR_PIECE;

    public static void registerItems() {
        CHAOS_LIGHTER = registerItem("chaos_lighter", new ChaosLighter(new Item.Settings()));
        CHAOS_GRENADE = registerItem("chaos_grenade", new Item(new Item.Settings()));
        ROCKET_LAUNCHER = registerItem("rocket_launcher", new Item(new Item.Settings()));
        BAZOOKA = registerItem("bazooka", new Item(new Item.Settings()));
        SURPRISE_BOX = registerItem("surprise_box", new Item(new Item.Settings()));
        CHAOS_ARMOR_PIECE = registerItem("chaos_armor_piece", new Item(new Item.Settings()));
        
        CaosTotalMod.LOGGER.info("Items del Caos registrados!");
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CaosTotalMod.MOD_ID, name), item);
    }
}
