package com.feyonor.caostaotal.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class HomeCommand {
    private static final Map<String, Map<String, Vec3d>> playerHomes = new HashMap<>();
    private static final int MAX_HOMES = 5;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("home")
            .then(argument("name", StringArgumentType.word())
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayerOrThrow();
                    String homeName = StringArgumentType.getString(context, "name");
                    
                    return teleportHome(player, homeName);
                }))
            .executes(context -> {
                ServerCommandSource source = context.getSource();
                ServerPlayerEntity player = source.getPlayerOrThrow();
                
                player.sendMessage(Text.literal("§e=== Tus homes ==="), false);
                player.sendMessage(Text.literal("§7/home set <nombre> - Guardar ubicación actual"), false);
                player.sendMessage(Text.literal("§7/home <nombre> - Teletransportarse a home"), false);
                player.sendMessage(Text.literal("§7/home delete <nombre> - Eliminar home"), false);
                player.sendMessage(Text.literal("§7/home list - Ver todos tus homes"), false);
                
                return 1;
            }));

        dispatcher.register(literal("home")
            .then(literal("set")
                .then(argument("name", StringArgumentType.word())
                    .executes(context -> {
                        ServerCommandSource source = context.getSource();
                        ServerPlayerEntity player = source.getPlayerOrThrow();
                        String homeName = StringArgumentType.getString(context, "name");
                        
                        return setHome(player, homeName);
                    }))));

        dispatcher.register(literal("home")
            .then(literal("delete")
                .then(argument("name", StringArgumentType.word())
                    .executes(context -> {
                        ServerCommandSource source = context.getSource();
                        ServerPlayerEntity player = source.getPlayerOrThrow();
                        String homeName = StringArgumentType.getString(context, "name");
                        
                        return deleteHome(player, homeName);
                    }))));

        dispatcher.register(literal("home")
            .then(literal("list")
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    ServerPlayerEntity player = source.getPlayerOrThrow();
                    
                    return listHomes(player);
                })));
    }

    private static int setHome(ServerPlayerEntity player, String homeName) {
        String playerUuid = player.getUuidAsString();
        Map<String, Vec3d> homes = playerHomes.computeIfAbsent(playerUuid, k -> new HashMap<>());

        if (homes.size() >= MAX_HOMES && !homes.containsKey(homeName)) {
            player.sendMessage(Text.literal("§cHas alcanzado el máximo de homes (" + MAX_HOMES + ")"), false);
            return 0;
        }

        Vec3d pos = player.getPos();
        homes.put(homeName, pos);
        player.sendMessage(Text.literal("§aHome '" + homeName + "' guardado en: " + (int)pos.x + ", " + (int)pos.y + ", " + (int)pos.z), false);
        
        return 1;
    }

    private static int teleportHome(ServerPlayerEntity player, String homeName) {
        String playerUuid = player.getUuidAsString();
        Map<String, Vec3d> homes = playerHomes.getOrDefault(playerUuid, new HashMap<>());

        if (!homes.containsKey(homeName)) {
            player.sendMessage(Text.literal("§cNo tienes un home llamado '" + homeName + "'"), false);
            return 0;
        }

        Vec3d pos = homes.get(homeName);
        player.teleport(player.getServerWorld(), pos.x, pos.y, pos.z, player.getYaw(), player.getPitch());
        player.sendMessage(Text.literal("§aTeletransportado a home '" + homeName + "'"), false);
        
        return 1;
    }

    private static int deleteHome(ServerPlayerEntity player, String homeName) {
        String playerUuid = player.getUuidAsString();
        Map<String, Vec3d> homes = playerHomes.getOrDefault(playerUuid, new HashMap<>());

        if (!homes.containsKey(homeName)) {
            player.sendMessage(Text.literal("§cNo tienes un home llamado '" + homeName + "'"), false);
            return 0;
        }

        homes.remove(homeName);
        player.sendMessage(Text.literal("§aHome '" + homeName + "' eliminado"), false);
        
        return 1;
    }

    private static int listHomes(ServerPlayerEntity player) {
        String playerUuid = player.getUuidAsString();
        Map<String, Vec3d> homes = playerHomes.getOrDefault(playerUuid, new HashMap<>());

        if (homes.isEmpty()) {
            player.sendMessage(Text.literal("§cNo tienes homes guardados"), false);
            return 0;
        }

        player.sendMessage(Text.literal("§e=== Tus Homes ==="), false);
        homes.forEach((name, pos) -> {
            player.sendMessage(Text.literal("§7- §b" + name + " §7en " + (int)pos.x + ", " + (int)pos.y + ", " + (int)pos.z), false);
        });
        
        return 1;
    }
}