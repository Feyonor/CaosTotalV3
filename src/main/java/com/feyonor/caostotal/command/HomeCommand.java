package com.feyonor.caostotal.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandBuildContext;
import net.minecraft.command.CommandManager;
import net.minecraft.command.argument.MessageArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

import com.feyonor.caostotal.home.HomeManager;
import com.feyonor.caostotal.home.HomeData;

public class HomeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            CommandManager.literal("home")
                .then(
                    CommandManager.literal("set")
                        .then(
                            CommandManager.argument("nombre", StringArgumentType.string())
                                .executes(context -> setHome(context.getSource(), StringArgumentType.getString(context, "nombre")))
                        )
                )
                .then(
                    CommandManager.argument("nombre", StringArgumentType.string())
                        .executes(context -> teleportHome(context.getSource(), StringArgumentType.getString(context, "nombre")))
                )
                .then(
                    CommandManager.literal("delete")
                        .then(
                            CommandManager.argument("nombre", StringArgumentType.string())
                                .executes(context -> deleteHome(context.getSource(), StringArgumentType.getString(context, "nombre")))
                        )
                )
                .then(
                    CommandManager.literal("list")
                        .executes(HomeCommand::listHomes)
                )
                .executes(context -> showHelp(context.getSource()))
        );
    }

    private static int setHome(ServerCommandSource source, String homeName) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        BlockPos pos = player.getBlockPos();

        int currentHomes = HomeManager.getHomeCount(player.getUuid());
        int maxHomes = HomeManager.getMaxHomes();

        // Verificar si ya existe un home con ese nombre
        HomeData existing = HomeManager.getHome(player.getUuid(), homeName);
        
        if (existing == null && currentHomes >= maxHomes) {
            player.sendMessage(Text.literal("❌ Ya tienes el máximo de homes (" + maxHomes + ")").formatted(Formatting.RED), false);
            return 0;
        }

        boolean success = HomeManager.setHome(player.getUuid(), homeName, player.getServerWorld(), pos);

        if (success) {
            if (existing != null) {
                player.sendMessage(Text.literal("✏️ Home '" + homeName + "' actualizado en: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ())
                    .formatted(Formatting.YELLOW), false);
            } else {
                player.sendMessage(Text.literal("✅ Home '" + homeName + "' guardado en: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ())
                    .formatted(Formatting.GREEN), false);
            }
            return 1;
        } else {
            player.sendMessage(Text.literal("❌ No se pudo guardar el home").formatted(Formatting.RED), false);
            return 0;
        }
    }

    private static int teleportHome(ServerCommandSource source, String homeName) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        
        HomeData home = HomeManager.getHome(player.getUuid(), homeName);

        if (home == null) {
            player.sendMessage(Text.literal("❌ Home '" + homeName + "' no encontrado").formatted(Formatting.RED), false);
            return 0;
        }

        try {
            player.teleport(player.getServer().getWorld(net.minecraft.util.Identifier.of(home.dimension)), 
                home.x + 0.5, home.y + 1, home.z + 0.5, 
                player.getYaw(), player.getPitch());
            
            player.sendMessage(Text.literal("🏠 Teletransportado a '" + homeName + "'")
                .formatted(Formatting.AQUA), false);
            
            source.sendFeedback(() -> Text.literal("El jugador " + player.getName().getString() + " se teletransportó a su home '" + homeName + "'")
                .formatted(Formatting.GRAY), true);
            
            return 1;
        } catch (Exception e) {
            player.sendMessage(Text.literal("❌ Error al teletransportarse al home").formatted(Formatting.RED), false);
            return 0;
        }
    }

    private static int deleteHome(ServerCommandSource source, String homeName) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();

        boolean success = HomeManager.deleteHome(player.getUuid(), homeName);

        if (success) {
            player.sendMessage(Text.literal("🗑️ Home '" + homeName + "' eliminado").formatted(Formatting.RED), false);
            return 1;
        } else {
            player.sendMessage(Text.literal("❌ Home '" + homeName + "' no encontrado").formatted(Formatting.RED), false);
            return 0;
        }
    }

    private static int listHomes(ServerCommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        var homes = HomeManager.getPlayerHomes(player.getUuid());

        if (homes.isEmpty()) {
            player.sendMessage(Text.literal("\n📍 No tienes ningún home guardado\n").formatted(Formatting.GRAY), false);
            return 1;
        }

        Text message = Text.literal("\n📍 Tus Homes:\n").formatted(Formatting.GOLD);
        for (HomeData home : homes.values()) {
            message = message.copy().append(
                Text.literal(" • " + home.name + " -> " + home.dimension + " (" + (int)home.x + ", " + (int)home.y + ", " + (int)home.z + ")\n")
                    .formatted(Formatting.YELLOW)
            );
        }
        message = message.copy().append(
            Text.literal("Máximo: " + homes.size() + "/" + HomeManager.getMaxHomes() + "\n")
                .formatted(Formatting.GRAY)
        );

        player.sendMessage(message, false);
        return 1;
    }

    private static int showHelp(ServerCommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        
        Text help = Text.literal("\n📍 Comando /home:\n")
            .formatted(Formatting.AQUA)
            .append(Text.literal("/home set <nombre> ")
                .formatted(Formatting.YELLOW))
            .append(Text.literal("- Guardar ubicación\n")
                .formatted(Formatting.GRAY))
            .append(Text.literal("/home <nombre> ")
                .formatted(Formatting.YELLOW))
            .append(Text.literal("- Teletransportarse\n")
                .formatted(Formatting.GRAY))
            .append(Text.literal("/home delete <nombre> ")
                .formatted(Formatting.YELLOW))
            .append(Text.literal("- Eliminar\n")
                .formatted(Formatting.GRAY))
            .append(Text.literal("/home list ")
                .formatted(Formatting.YELLOW))
            .append(Text.literal("- Ver todos tus homes\n")
                .formatted(Formatting.GRAY));
        
        player.sendMessage(help, false);
        return 1;
    }
}
