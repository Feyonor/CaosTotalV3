package com.feyonor.caostaotal.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;

public class PlayerDeathCounter {
    private static final Map<String, Integer> deathCounts = new HashMap<>();

    public static void recordDeath(PlayerEntity player) {
        String playerName = player.getName().getString();
        int deaths = deathCounts.getOrDefault(playerName, 0);
        deathCounts.put(playerName, deaths + 1);
        
        // Broadcast
        player.sendMessage(Text.literal("§c☠️ Muertes: " + (deaths + 1)), false);
    }

    public static int getDeaths(PlayerEntity player) {
        return deathCounts.getOrDefault(player.getName().getString(), 0);
    }

    public static void updateAll(MinecraftServer server) {
        // Se puede implementar mostrar contador de muertes aquí
        // Por ahora solo se registran las muertes
    }

    public static void reset() {
        deathCounts.clear();
    }
}
