package com.feyonor.caostaotal.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import com.feyonor.caostaotal.config.CaosConfig;
import com.feyonor.caostaotal.item.CaosItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerSpawnEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-spawn");
    private static boolean initialized = false;

    public static void register() {
        ServerPlayerEvents.AFTER_RESPAWN.register((newPlayer, oldPlayer, alive) -> {
            onPlayerRespawn(newPlayer);
        });
    }

    private static void onPlayerRespawn(PlayerEntity player) {
        if (!player.getWorld().isClient) {
            // Establecer vida máxima a 1000
            player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(CaosConfig.PLAYER_MAX_HEALTH);
            player.setHealth(CaosConfig.PLAYER_MAX_HEALTH);

            // Dar items solo la primera vez
            if (!initialized) {
                giveSpawnItems(player);
                initialized = true;
                LOGGER.info("✨ Items de inicio dados al jugador: " + player.getName().getString());
            } else {
                // Restaurar salud máxima en respawns posteriores
                player.setHealth(CaosConfig.PLAYER_MAX_HEALTH);
            }
        }
    }

    private static void giveSpawnItems(PlayerEntity player) {
        // Diamantes fáciles de encontrar
        player.getInventory().offerOrDrop(new ItemStack(Items.DIAMOND, CaosConfig.SPAWN_DIAMONDS));
        
        // Redstone fácil de encontrar
        player.getInventory().offerOrDrop(new ItemStack(Items.REDSTONE, CaosConfig.SPAWN_REDSTONE));
        
        // Hierro fácil de encontrar
        player.getInventory().offerOrDrop(new ItemStack(Items.IRON_INGOT, CaosConfig.SPAWN_IRON));
        
        // Items del mod
        if (CaosItems.CHAOS_LIGHTER != null) {
            player.getInventory().offerOrDrop(new ItemStack(CaosItems.CHAOS_LIGHTER, 1));
        }
        if (CaosItems.CHAOS_GRENADE != null) {
            player.getInventory().offerOrDrop(new ItemStack(CaosItems.CHAOS_GRENADE, 16));
        }
        if (CaosItems.ROCKET_LAUNCHER != null) {
            player.getInventory().offerOrDrop(new ItemStack(CaosItems.ROCKET_LAUNCHER, 1));
        }
        if (CaosItems.BAZOOKA != null) {
            player.getInventory().offerOrDrop(new ItemStack(CaosItems.BAZOOKA, 1));
        }
        if (CaosItems.SURPRISE_BOX != null) {
            player.getInventory().offerOrDrop(new ItemStack(CaosItems.SURPRISE_BOX, 10));
        }
        
        // Mensaje de bienvenida
        player.sendMessage(Text.literal("§6════════════════════════════════════"), false);
        player.sendMessage(Text.literal("§c⚡ ¡BIENVENIDO AL CAOS TOTAL V3! ⚡"), false);
        player.sendMessage(Text.literal("§e✨ Vida: " + CaosConfig.PLAYER_MAX_HEALTH), false);
        player.sendMessage(Text.literal("§a💎 Tienes " + CaosConfig.SPAWN_DIAMONDS + " diamantes"), false);
        player.sendMessage(Text.literal("§b⛏️ Tienes " + CaosConfig.SPAWN_IRON + " hierro"), false);
        player.sendMessage(Text.literal("§e🔴 Tienes " + CaosConfig.SPAWN_REDSTONE + " redstone"), false);
        player.sendMessage(Text.literal("§d📦 Tienes items del mod en tu inventario"), false);
        player.sendMessage(Text.literal("§6🌍 ¡Crea un portal de diamante para entrar al CAOS!"), false);
        player.sendMessage(Text.literal("§6════════════════════════════════════"), false);
    }
}
