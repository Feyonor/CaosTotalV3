package com.feyonor.caostaotal.events;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import com.feyonor.caostaotal.config.CaosConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosEventManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-events");
    private static int tickCounter = 0;

    public static void onServerStart(MinecraftServer server) {
        LOGGER.info("Inicializando gestor de eventos caóticos...");
    }

    public static void onServerTick(MinecraftServer server) {
        tickCounter++;

        // Lluvia de TNT aleatorio
        if (tickCounter % CaosConfig.TNT_RAIN_CHANCE == 0) {
            triggerTntRain(server);
        }

        // Invasión de mobs
        if (tickCounter % CaosConfig.MOB_INVASION_CHANCE == 0) {
            triggerMobInvasion(server);
        }

        // Meteoritos
        if (tickCounter % CaosConfig.METEORITE_CHANCE == 0) {
            triggerMeteorite(server);
        }

        // Rey Creeper
        if (tickCounter % CaosConfig.CREEPER_KING_CHANCE == 0) {
            triggerCreeperKing(server);
        }

        if (tickCounter > 1000000) {
            tickCounter = 0;
        }
    }

    private static void triggerTntRain(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        LOGGER.info("¡LLUVIA DE TNT en " + (int)pos.x + ", " + (int)pos.z + "!");
        
        for (int i = 0; i < 20; i++) {
            double x = pos.x + (Math.random() * 50 - 25);
            double y = pos.y + 50;
            double z = pos.z + (Math.random() * 50 - 25);

            var tnt = new net.minecraft.entity.TntEntity(world, x, y, z, null);
            world.spawnEntity(tnt);
        }
    }

    private static void triggerMobInvasion(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        LOGGER.info("¡INVASIÓN DE MOBS!");
        
        for (int i = 0; i < 15; i++) {
            double x = pos.x + (Math.random() * 40 - 20);
            double y = pos.y + 2;
            double z = pos.z + (Math.random() * 40 - 20);

            CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
            creeper.setPosition(x, y, z);
            world.spawnEntity(creeper);
        }
    }

    private static void triggerMeteorite(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        LOGGER.info("¡METEORITO!");
        
        // Crear explosión
        world.createExplosion(null, pos.x, pos.y + 50, pos.z, 8.0f, net.minecraft.world.explosion.Explosion.DestructionType.BREAK);
    }

    private static void triggerCreeperKing(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        LOGGER.info("¡¡¡REY CREEPER INVOCADO!!!");
        
        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
        creeper.setPosition(pos.x, pos.y + 10, pos.z);
        creeper.setHealth(CaosConfig.CREEPER_KING_HEALTH);
        world.spawnEntity(creeper);
    }
}