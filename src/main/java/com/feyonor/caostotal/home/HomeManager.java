package com.feyonor.caostotal.home;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.feyonor.caostotal.CaosTotalMod;

public class HomeManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final int MAX_HOMES_PER_PLAYER = 5;
    private static File DATA_DIRECTORY;
    private static final Map<UUID, Map<String, HomeData>> PLAYER_HOMES = new HashMap<>();

    public static void setDataDirectory(File worldDirectory) {
        DATA_DIRECTORY = new File(worldDirectory, "caostotal_homes");
        if (!DATA_DIRECTORY.exists()) {
            DATA_DIRECTORY.mkdirs();
        }
        loadAllHomes();
    }

    public static boolean setHome(UUID playerUUID, String homeName, ServerWorld world, BlockPos pos) {
        if (homeName.length() > 20) {
            return false;
        }

        Map<String, HomeData> playerHomes = PLAYER_HOMES.computeIfAbsent(playerUUID, k -> new HashMap<>());

        if (playerHomes.size() >= MAX_HOMES_PER_PLAYER && !playerHomes.containsKey(homeName)) {
            return false;
        }

        HomeData home = new HomeData(
            homeName,
            pos.getX(),
            pos.getY(),
            pos.getZ(),
            world.getRegistryKey().getValue().toString(),
            System.currentTimeMillis()
        );

        playerHomes.put(homeName, home);
        savePlayerHomes(playerUUID);
        return true;
    }

    public static HomeData getHome(UUID playerUUID, String homeName) {
        Map<String, HomeData> playerHomes = PLAYER_HOMES.get(playerUUID);
        if (playerHomes == null) {
            return null;
        }
        return playerHomes.get(homeName);
    }

    public static boolean deleteHome(UUID playerUUID, String homeName) {
        Map<String, HomeData> playerHomes = PLAYER_HOMES.get(playerUUID);
        if (playerHomes == null) {
            return false;
        }

        boolean removed = playerHomes.remove(homeName) != null;
        if (removed) {
            savePlayerHomes(playerUUID);
        }
        return removed;
    }

    public static Map<String, HomeData> getPlayerHomes(UUID playerUUID) {
        return PLAYER_HOMES.getOrDefault(playerUUID, new HashMap<>());
    }

    public static int getHomeCount(UUID playerUUID) {
        Map<String, HomeData> playerHomes = PLAYER_HOMES.get(playerUUID);
        return playerHomes == null ? 0 : playerHomes.size();
    }

    public static int getMaxHomes() {
        return MAX_HOMES_PER_PLAYER;
    }

    private static void savePlayerHomes(UUID playerUUID) {
        if (DATA_DIRECTORY == null) {
            return;
        }

        try {
            File playerFile = new File(DATA_DIRECTORY, playerUUID + ".json");
            Map<String, HomeData> playerHomes = PLAYER_HOMES.get(playerUUID);

            if (playerHomes == null || playerHomes.isEmpty()) {
                playerFile.delete();
                return;
            }

            JsonObject json = new JsonObject();
            JsonArray homesArray = new JsonArray();

            for (HomeData home : playerHomes.values()) {
                homesArray.add(home.toJson());
            }

            json.add("homes", homesArray);

            try (FileWriter writer = new FileWriter(playerFile)) {
                GSON.toJson(json, writer);
            }

            CaosTotalMod.LOGGER.info("Guardados homes para jugador: " + playerUUID);
        } catch (IOException e) {
            CaosTotalMod.LOGGER.error("Error guardando homes para jugador: " + playerUUID, e);
        }
    }

    private static void loadAllHomes() {
        if (DATA_DIRECTORY == null || !DATA_DIRECTORY.exists()) {
            return;
        }

        File[] files = DATA_DIRECTORY.listFiles((dir, name) -> name.endsWith(".json"));
        if (files == null) {
            return;
        }

        for (File file : files) {
            try {
                String filename = file.getName();
                UUID playerUUID = UUID.fromString(filename.substring(0, filename.length() - 5));

                try (FileReader reader = new FileReader(file)) {
                    JsonObject json = GSON.fromJson(reader, JsonObject.class);
                    JsonArray homesArray = json.getAsJsonArray("homes");

                    Map<String, HomeData> playerHomes = new HashMap<>();

                    for (JsonElement element : homesArray) {
                        HomeData home = HomeData.fromJson(element.getAsJsonObject());
                        playerHomes.put(home.name, home);
                    }

                    PLAYER_HOMES.put(playerUUID, playerHomes);
                }

                CaosTotalMod.LOGGER.info("Cargados homes para jugador: " + playerUUID);
            } catch (Exception e) {
                CaosTotalMod.LOGGER.error("Error cargando archivo de homes: " + file.getName(), e);
            }
        }
    }

    public static void saveAll() {
        for (UUID playerUUID : PLAYER_HOMES.keySet()) {
            savePlayerHomes(playerUUID);
        }
    }
}
