package com.feyonor.caostotal.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import com.feyonor.caostotal.home.HomeManager;
import com.feyonor.caostotal.stats.DeathCounter;

public class CaosTotalEvents {
    private static int tickCounter = 0;
    private static final int EVENT_INTERVAL = 12000; // 10 minutos en ticks (600 segundos * 20 ticks/segundo)
    
    public static void register() {
        // Evento de inicio del servidor
        ServerLifecycleEvents.SERVER_STARTED.register(CaosTotalEvents::onServerStart);
        
        // Evento de parada del servidor
        ServerLifecycleEvents.SERVER_STOPPING.register(CaosTotalEvents::onServerStop);
        
        // Evento de tick del servidor
        ServerTickEvents.END_SERVER_TICK.register(CaosTotalEvents::onServerTick);
    }
    
    private static void onServerStart(MinecraftServer server) {
        // Inicializar HomeManager con el directorio de datos del servidor
        HomeManager.setDataDirectory(server.getWorldPath(net.minecraft.world.level.storage.LevelResource.ROOT).toFile());
        // Inicializar DeathCounter
        DeathCounter.setDataDirectory(server.getWorldPath(net.minecraft.world.level.storage.LevelResource.ROOT).toFile());
    }
    
    private static void onServerStop(MinecraftServer server) {
        // Guardar todos los homes antes de apagar el servidor
        HomeManager.saveAll();
        DeathCounter.saveAll();
    }
    
    private static void onServerTick(MinecraftServer server) {
        tickCounter++;
        
        // Ejecutar un evento cada 10 minutos
        if (tickCounter % EVENT_INTERVAL == 0) {
            for (ServerWorld world : server.getWorlds()) {
                Random random = Random.create();
                int eventType = random.nextInt(4);
                
                switch (eventType) {
                    case 0: triggerTntRain(world); break;
                    case 1: triggerMobInvasion(world); break;
                    case 2: triggerMeteorite(world); break;
                    case 3: triggerWitherAttack(world); break;
                }
            }
        }
    }
    
    private static void triggerTntRain(ServerWorld world) {
        // Lluvia de TNT en el cielo
        if (world.getPlayers(p -> true).isEmpty()) return;
        
        net.minecraft.text.Text announcement = net.minecraft.text.Text.literal("⚡ ¡LLUVIA DE TNT HA LLEGADO! ⚡")
            .formatted(net.minecraft.util.Formatting.RED, net.minecraft.util.Formatting.BOLD);
        
        world.getServer().getPlayerManager().broadcast(announcement, false);
        
        // Generar TNT aleatorio en el cielo
        Random random = Random.create();
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(200) - 100;
            int z = random.nextInt(200) - 100;
            int y = 256; // Altura máxima
            
            // Generar TNT
            net.minecraft.entity.Entity tnt = new net.minecraft.entity.TntEntity(world, (double)x, (double)y, (double)z, null);
            world.spawnEntity(tnt);
        }
    }
    
    private static void triggerMobInvasion(ServerWorld world) {
        // Invasión de mobs
        if (world.getPlayers(p -> true).isEmpty()) return;
        
        net.minecraft.text.Text announcement = net.minecraft.text.Text.literal("💀 ¡INVASIÓN DE MOBS! 💀")
            .formatted(net.minecraft.util.Formatting.RED, net.minecraft.util.Formatting.BOLD);
        
        world.getServer().getPlayerManager().broadcast(announcement, false);
        
        // Generar mobs aleatorios
        Random random = Random.create();
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(200) - 100;
            int z = random.nextInt(200) - 100;
            
            BlockPos pos = new BlockPos(x, 100, z);
            
            int mobType = random.nextInt(3);
            net.minecraft.entity.Entity mob = null;
            
            switch (mobType) {
                case 0:
                    mob = new CreeperEntity(EntityType.CREEPER, world);
                    break;
                case 1:
                    mob = new ZombieEntity(world);
                    break;
                case 2:
                    mob = new net.minecraft.entity.mob.SkeletonEntity(EntityType.SKELETON, world);
                    break;
            }
            
            if (mob != null) {
                mob.setPosition(pos.getX(), pos.getY(), pos.getZ());
                world.spawnEntity(mob);
            }
        }
    }
    
    private static void triggerMeteorite(ServerWorld world) {
        // Meteoritos cayendo
        if (world.getPlayers(p -> true).isEmpty()) return;
        
        net.minecraft.text.Text announcement = net.minecraft.text.Text.literal("🌠 ¡METEORITOS CAYENDO! 🌠")
            .formatted(net.minecraft.util.Formatting.GOLD, net.minecraft.util.Formatting.BOLD);
        
        world.getServer().getPlayerManager().broadcast(announcement, false);
        
        // Generar meteoritos (TNT gigante)
        Random random = Random.create();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(200) - 100;
            int z = random.nextInt(200) - 100;
            
            // Meteorito de TNT
            for (int j = 0; j < 10; j++) {
                net.minecraft.entity.Entity tnt = new net.minecraft.entity.TntEntity(world, 
                    (double)(x + random.nextInt(20) - 10), 
                    (double)(256 - j * 2), 
                    (double)(z + random.nextInt(20) - 10), 
                    null);
                world.spawnEntity(tnt);
            }
        }
    }
    
    private static void triggerWitherAttack(ServerWorld world) {
        // Ataque de Wither
        if (world.getPlayers(p -> true).isEmpty()) return;
        
        net.minecraft.text.Text announcement = net.minecraft.text.Text.literal("💀 ¡EL WITHER HA DESPERTADO! 💀")
            .formatted(net.minecraft.util.Formatting.DARK_RED, net.minecraft.util.Formatting.BOLD);
        
        world.getServer().getPlayerManager().broadcast(announcement, false);
        
        // Generar un Wither en el cielo
        Random random = Random.create();
        int x = random.nextInt(200) - 100;
        int z = random.nextInt(200) - 100;
        
        WitherEntity wither = new WitherEntity(EntityType.WITHER, world);
        wither.setPosition(x, 150, z);
        world.spawnEntity(wither);
    }
}
