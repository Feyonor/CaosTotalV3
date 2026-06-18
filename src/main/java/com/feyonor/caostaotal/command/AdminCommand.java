package com.feyonor.caostaotal.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

import static net.minecraft.server.command.CommandManager.literal;

public class AdminCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("caosadmin")
            .requires(source -> source.hasPermissionLevel(4))
            .then(literal("tntrain")
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    source.sendMessage(Text.literal("§eComando TNT rain ejecutado"));
                    return 1;
                }))
            .then(literal("invade")
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    source.sendMessage(Text.literal("§eInvasión de mobs iniciada"));
                    return 1;
                }))
            .then(literal("meteorite")
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    source.sendMessage(Text.literal("§eMeteoritos generados"));
                    return 1;
                }))
            .then(literal("summonking")
                .executes(context -> {
                    ServerCommandSource source = context.getSource();
                    source.sendMessage(Text.literal("§e¡Rey Creeper invocado!"));
                    return 1;
                })));
    }
}