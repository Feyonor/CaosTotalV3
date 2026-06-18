package com.feyonor.caostaotal.config;

public class CaosConfig {
    // Salud de jugadores
    public static final float PLAYER_MAX_HEALTH = 1000f;

    // Homes
    public static final int MAX_HOMES = 5;

    // Eventos
    public static final int RANDOM_EVENT_CHANCE = 100; // tick entre eventos (menor = más frecuente)
    public static final int TNT_RAIN_CHANCE = 500;
    public static final int MOB_INVASION_CHANCE = 400;
    public static final int METEORITE_CHANCE = 600;
    public static final int CREEPER_KING_CHANCE = 800;

    // Items
    public static final int DIAMOND_VEIN_SIZE = 12;
    public static final int REDSTONE_VEIN_SIZE = 16;

    // Rey Creeper
    public static final float CREEPER_KING_HEALTH = 500f;
    public static final int CREEPER_KING_EXPLOSION_POWER = 10;

    // Dimension del Caos
    public static final String CHAOS_DIMENSION = "caostaotal:chaos";

    public static void load() {
        // Cargar desde archivo si existe, por ahora usar defaults
    }
}