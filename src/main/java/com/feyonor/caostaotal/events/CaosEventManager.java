package com.feyonor.caostaotal.events;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.boss.wither.WitherEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.text.Text;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import com.feyonor.caostaotal.config.CaosConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosEventManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-events");
    private static int tickCounter = 0;
    private static Random random = Random.create();

    public static void onServerStart(MinecraftServer server) {
        LOGGER.info("✨ Inicializando gestor de eventos caóticos...");
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

        // Eventos caóticos aleatorios
        if (tickCounter % CaosConfig.CHAOS_EVENT_CHANCE == 0) {
            triggerRandomChaosEvent(server);
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

        broadcastMessage(server, "☄️ ¡¡¡LLUVIA DE TNT!!!");
        LOGGER.warn("☄️ LLUVIA DE TNT en " + (int)pos.x + ", " + (int)pos.z);
        
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

        broadcastMessage(server, "👹 ¡¡¡INVASIÓN DE MOBS!!!");
        LOGGER.warn("👹 INVASIÓN DE MOBS");
        
        for (int i = 0; i < 15; i++) {
            double x = pos.x + (Math.random() * 40 - 20);
            double y = pos.y + 2;
            double z = pos.z + (Math.random() * 40 - 20);

            // Alternancia entre diferentes tipos de mobs
            Entity mob = null;
            int type = i % 3;
            switch (type) {
                case 0:
                    CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
                    creeper.setPosition(x, y, z);
                    mob = creeper;
                    break;
                case 1:
                    SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, world);
                    skeleton.setPosition(x, y, z);
                    mob = skeleton;
                    break;
                case 2:
                    ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, world);
                    zombie.setPosition(x, y, z);
                    mob = zombie;
                    break;
            }
            if (mob != null) {
                world.spawnEntity(mob);
            }
        }
    }

    private static void triggerMeteorite(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        broadcastMessage(server, "🌍 ¡¡¡METEORITO ENTRANTE!!!");
        LOGGER.warn("🌍 METEORITO en " + (int)pos.x + ", " + (int)pos.z);
        
        // Crear múltiples explosiones
        for (int i = 0; i < 3; i++) {
            double offsetX = pos.x + (Math.random() * 20 - 10);
            double offsetZ = pos.z + (Math.random() * 20 - 10);
            world.createExplosion(null, offsetX, pos.y + 30, offsetZ, 8.0f, net.minecraft.world.explosion.Explosion.DestructionType.BREAK);
        }
    }

    private static void triggerCreeperKing(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();

        broadcastMessage(server, "👿 ¡¡¡REY CREEPER INVOCADO!!!");
        LOGGER.error("👿 REY CREEPER APARECIENDO");
        
        CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
        creeper.setPosition(pos.x, pos.y + 10, pos.z);
        creeper.setHealth(CaosConfig.CREEPER_KING_HEALTH);
        creeper.setMaxHealth(CaosConfig.CREEPER_KING_HEALTH);
        world.spawnEntity(creeper);
    }

    private static void triggerRandomChaosEvent(MinecraftServer server) {
        ServerWorld world = server.getOverworld();
        
        if (world.getPlayers().isEmpty()) return;

        var player = world.getPlayers().get(0);
        Vec3d pos = player.getPos();
        
        int eventType = random.nextInt(5);
        
        switch (eventType) {
            case 0: // Lluvia de fuego
                broadcastMessage(server, "🔥 ¡¡¡LLUVIA DE FUEGO!!!");
                for (int i = 0; i < 10; i++) {
                    double x = pos.x + (Math.random() * 30 - 15);
                    double z = pos.z + (Math.random() * 30 - 15);
                    BlockPos blockPos = new BlockPos((int)x, (int)pos.y + 50, (int)z);
                    world.setBlockState(blockPos, Blocks.FIRE.getDefaultState());
                }
                break;
                
            case 1: // Terremoto
                broadcastMessage(server, "⚡ ¡¡¡TERREMOTO!!!");
                for (int i = 0; i < 5; i++) {
                    double x = pos.x + (Math.random() * 40 - 20);
                    double z = pos.z + (Math.random() * 40 - 20);
                    world.createExplosion(null, x, pos.y, z, 3.0f, net.minecraft.world.explosion.Explosion.DestructionType.BREAK);
                }
                break;
                
            case 2: // Tormenta de hechizos
                broadcastMessage(server, "✨ ¡¡¡TORMENTA DE HECHIZOS!!!");
                for (int i = 0; i < 20; i++) {
                    double x = pos.x + (Math.random() * 50 - 25);
                    double y = pos.y + (Math.random() * 20 - 10);
                    double z = pos.z + (Math.random() * 50 - 25);
                    world.createExplosion(null, x, y, z, 2.0f, net.minecraft.world.explosion.Explosion.DestructionType.NONE);
                }
                break;
                
            case 3: // Destrucción de bloques
                broadcastMessage(server, "💥 ¡¡¡DESTRUCCIÓN TOTAL!!!");
                for (int i = 0; i < 50; i++) {
                    BlockPos destroyPos = new BlockPos(
                        (int)(pos.x + Math.random() * 30 - 15),
                        (int)(pos.y + Math.random() * 20 - 10),
                        (int)(pos.z + Math.random() * 30 - 15)
                    );
                    if (world.getBlockState(destroyPos).getMaterial().isReplaceable()) {
                        world.breakBlock(destroyPos, true);
                    }
                }
                break;
                
            case 4: // Resurrección de mobs
                broadcastMessage(server, "🧟 ¡¡¡RESURRECCIÓN!!!");
                for (int i = 0; i < 10; i++) {
                    double x = pos.x + (Math.random() * 40 - 20);
                    double y = pos.y + 2;
                    double z = pos.z + (Math.random() * 40 - 20);
                    
                    ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, world);
                    zombie.setPosition(x, y, z);
                    world.spawnEntity(zombie);
                }
                break;
        }
    }

    private static void broadcastMessage(MinecraftServer server, String message) {
        server.getPlayerManager().broadcast(Text.literal("§c" + message), false);
    }
}
