package com.feyonor.caostaotal.config;

public class CaosConfig {
    // Salud de jugadores
    public static final float PLAYER_MAX_HEALTH = 1000f;

    // Homes
    public static final int MAX_HOMES = 5;

    // Eventos - AHORA MÁS FRECUENTES (números más bajos = más frecuentes)
    public static final int RANDOM_EVENT_CHANCE = 20; // cada 20 ticks
    public static final int TNT_RAIN_CHANCE = 400; // cada 400 ticks (~20 segundos)
    public static final int MOB_INVASION_CHANCE = 300; // cada 300 ticks (~15 segundos)
    public static final int METEORITE_CHANCE = 500; // cada 500 ticks (~25 segundos)
    public static final int CREEPER_KING_CHANCE = 800; // cada 800 ticks (~40 segundos)
    public static final int CHAOS_EVENT_CHANCE = 600; // eventos caóticos aleatorios

    // Items iniciales
    public static final int SPAWN_DIAMONDS = 64;
    public static final int SPAWN_REDSTONE = 64;
    public static final int SPAWN_IRON = 64;

    // Items
    public static final int DIAMOND_VEIN_SIZE = 12;
    public static final int REDSTONE_VEIN_SIZE = 16;

    // Rey Creeper
    public static final float CREEPER_KING_HEALTH = 500f;
    public static final int CREEPER_KING_EXPLOSION_POWER = 10;

    // Bosses
    public static final float CHAOS_BOSS_HEALTH = 1000f;
    public static final float CHAOS_GOLEM_HEALTH = 750f;

    // Dimension del Caos
    public static final String CHAOS_DIMENSION = "caostaotal:chaos";

    public static void load() {
        // Cargar desde archivo si existe, por ahora usar defaults
    }
}
