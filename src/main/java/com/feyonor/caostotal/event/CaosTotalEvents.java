package com.feyonor.caostotal.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

import com.feyonor.caostotal.home.HomeManager;

public class CaosTotalEvents {
    private static int tickCounter = 0;
    
    public static void register() {
        // Evento de inicio del servidor
        ServerLifecycleEvents.SERVER_STARTED.register(CaosTotalEvents::onServerStart);
        
        // Evento de parada del servidor
        ServerLifecycleEvents.SERVER_STOPPING.register(CaosTotalEvents::onServerStop);
        
        // Event de tick del servidor
        ServerTickEvents.END_SERVER_TICK.register(CaosTotalEvents::onServerTick);
    }
    
    private static void onServerStart(MinecraftServer server) {
        // Inicializar HomeManager con el directorio de datos del servidor
        HomeManager.setDataDirectory(server.getWorldPath(net.minecraft.world.level.storage.LevelResource.ROOT).toFile());
    }
    
    private static void onServerStop(MinecraftServer server) {
        // Guardar todos los homes antes de apagar el servidor
        HomeManager.saveAll();
    }
    
    private static void onServerTick(MinecraftServer server) {
        tickCounter++;
        
        // Ejecutar eventos cada cierto tiempo
        if (tickCounter % 6000 == 0) { // Cada 5 minutos
            for (ServerWorld world : server.getWorlds()) {
                Random random = Random.create();
                int eventType = random.nextInt(4);
                
                switch (eventType) {
                    case 0: triggerTntRain(world); break;
                    case 1: triggerMobInvasion(world); break;
                    case 2: triggerMeteorite(world); break;
                    case 3: break; // Evento vacío
                }
            }
        }
    }
    
    private static void triggerTntRain(ServerWorld world) {
        // Lógica de lluvia de TNT
    }
    
    private static void triggerMobInvasion(ServerWorld world) {
        // Lógica de invasión de mobs
    }
    
    private static void triggerMeteorite(ServerWorld world) {
        // Lógica de meteoritos
    }
}
