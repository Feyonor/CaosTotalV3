package com.feyonor.caostaotal.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.feyonor.caostaotal.CaosTotalMod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosItems {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-items");
    
    // Items del Caos
    public static Item CHAOS_LIGHTER;
    public static Item CHAOS_GRENADE;
    public static Item ROCKET_LAUNCHER;
    public static Item BAZOOKA;
    public static Item SURPRISE_BOX;
    public static Item CHAOS_ARMOR_PIECE;
    public static Item CHAOS_INGOT;
    public static Item CHAOS_GEM;

    public static void registerItems() {
        LOGGER.info("🎒 Registrando items de Caos Total V3...");
        
        CHAOS_LIGHTER = registerItem("chaos_lighter", new ChaosLighter(new Item.Settings().maxCount(1)));
        CHAOS_GRENADE = registerItem("chaos_grenade", new Item(new Item.Settings().maxCount(64)));
        ROCKET_LAUNCHER = registerItem("rocket_launcher", new Item(new Item.Settings().maxCount(1)));
        BAZOOKA = registerItem("bazooka", new Item(new Item.Settings().maxCount(1)));
        SURPRISE_BOX = registerItem("surprise_box", new Item(new Item.Settings().maxCount(64)));
        CHAOS_ARMOR_PIECE = registerItem("chaos_armor_piece", new Item(new Item.Settings().maxCount(64)));
        CHAOS_INGOT = registerItem("chaos_ingot", new Item(new Item.Settings().maxCount(64)));
        CHAOS_GEM = registerItem("chaos_gem", new Item(new Item.Settings().maxCount(64)));
        
        LOGGER.info("✅ Items registrados correctamente!");
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CaosTotalMod.MOD_ID, name), item);
    }
}
