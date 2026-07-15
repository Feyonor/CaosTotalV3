package com.feyonor.caostotal.stats;

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

import com.feyonor.caostotal.CaosTotalMod;

public class DeathCounter {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static File DATA_DIRECTORY;
    private static final Map<UUID, Integer> PLAYER_DEATHS = new HashMap<>();

    public static void setDataDirectory(File worldDirectory) {
        DATA_DIRECTORY = new File(worldDirectory, "caostotal_deaths");
        if (!DATA_DIRECTORY.exists()) {
            DATA_DIRECTORY.mkdirs();
        }
        loadDeaths();
    }

    public static void addDeath(UUID playerUUID) {
        int currentDeaths = PLAYER_DEATHS.getOrDefault(playerUUID, 0);
        PLAYER_DEATHS.put(playerUUID, currentDeaths + 1);
        saveDeaths();
    }

    public static int getDeaths(UUID playerUUID) {
        return PLAYER_DEATHS.getOrDefault(playerUUID, 0);
    }

    public static Map<UUID, Integer> getAllDeaths() {
        return new HashMap<>(PLAYER_DEATHS);
    }

    public static void resetDeaths(UUID playerUUID) {
        PLAYER_DEATHS.remove(playerUUID);
        saveDeaths();
    }

    public static void resetAllDeaths() {
        PLAYER_DEATHS.clear();
        saveDeaths();
    }

    private static void saveDeaths() {
        if (DATA_DIRECTORY == null) {
            return;
        }

        try {
            File deathFile = new File(DATA_DIRECTORY, "deaths.json");
            JsonObject json = new JsonObject();

            for (Map.Entry<UUID, Integer> entry : PLAYER_DEATHS.entrySet()) {
                json.addProperty(entry.getKey().toString(), entry.getValue());
            }

            try (FileWriter writer = new FileWriter(deathFile)) {
                GSON.toJson(json, writer);
            }

            CaosTotalMod.LOGGER.info("Guardadas estadísticas de muertes");
        } catch (IOException e) {
            CaosTotalMod.LOGGER.error("Error guardando muertes", e);
        }
    }

    private static void loadDeaths() {
        if (DATA_DIRECTORY == null || !DATA_DIRECTORY.exists()) {
            return;
        }

        try {
            File deathFile = new File(DATA_DIRECTORY, "deaths.json");
            if (!deathFile.exists()) {
                return;
            }

            try (FileReader reader = new FileReader(deathFile)) {
                JsonObject json = GSON.fromJson(reader, JsonObject.class);

                for (String key : json.keySet()) {
                    try {
                        UUID playerUUID = UUID.fromString(key);
                        int deaths = json.get(key).getAsInt();
                        PLAYER_DEATHS.put(playerUUID, deaths);
                    } catch (IllegalArgumentException e) {
                        CaosTotalMod.LOGGER.warn("UUID inválido en deaths.json: " + key);
                    }
                }
            }

            CaosTotalMod.LOGGER.info("Cargadas estadísticas de muertes");
        } catch (Exception e) {
            CaosTotalMod.LOGGER.error("Error cargando muertes", e);
        }
    }

    public static void saveAll() {
        saveDeaths();
    }
}
