package com.feyonor.caostotal.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class CaosTotalCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        // Registrar comandos
        HomeCommand.register(dispatcher);
        
        // Comando /caosadmin
        dispatcher.register(
            CommandManager.literal("caosadmin")
                .requires(source -> source.hasPermissionLevel(3))
                .then(
                    CommandManager.literal("tntrain")
                        .executes(context -> tntRain(context.getSource()))
                )
                .then(
                    CommandManager.literal("invade")
                        .executes(context -> invade(context.getSource()))
                )
                .then(
                    CommandManager.literal("meteorite")
                        .executes(context -> meteorite(context.getSource()))
                )
                .then(
                    CommandManager.literal("summonking")
                        .executes(context -> summonKing(context.getSource()))
                )
        );
    }
    
    private static int tntRain(ServerCommandSource source) {
        source.sendFeedback(() -> Text.literal("¡LLUVIA DE TNT INICIADA!").formatted(Formatting.RED), true);
        return 1;
    }
    
    private static int invade(ServerCommandSource source) {
        source.sendFeedback(() -> Text.literal("¡INVASIÓN DE MOBS INICIADA!").formatted(Formatting.RED), true);
        return 1;
    }
    
    private static int meteorite(ServerCommandSource source) {
        source.sendFeedback(() -> Text.literal("¡METEORITOS CAYENDO!").formatted(Formatting.GOLD), true);
        return 1;
    }
    
    private static int summonKing(ServerCommandSource source) {
        source.sendFeedback(() -> Text.literal("¡EL REY CREEPER HA SIDO INVOCADO!").formatted(Formatting.RED), true);
        return 1;
    }
}
