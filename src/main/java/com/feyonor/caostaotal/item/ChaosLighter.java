package com.feyonor.caostaotal.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import com.feyonor.caostaotal.dimension.ChaosDimension;

public class ChaosLighter extends Item {
    public ChaosLighter(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient && player != null) {
            // Verificar si hay un portal de diamante en el área
            if (isPortalValid(world, pos)) {
                // Teletransportar al jugador a la Dimensión del Caos
                if (world.getDimensionKey().getValue().toString().equals("minecraft:overworld")) {
                    // Ir a la dimensión del Caos
                    player.sendMessage(Text.literal("§c¡ENTRANDO AL CAOS TOTAL!"), false);
                    teleportToChaos(player);
                } else if (world.getDimensionKey().getValue().toString().equals("caostaotal:chaos")) {
                    // Volver al mundo normal
                    player.sendMessage(Text.literal("§e¡ESCAPANDO DEL CAOS!"), false);
                    teleportToOverworld(player);
                }
                return ActionResult.SUCCESS;
            } else if (player != null) {
                player.sendMessage(Text.literal("§cNecesita un portal de bloques de diamante"), false);
            }
        }

        return ActionResult.PASS;
    }

    private boolean isPortalValid(World world, BlockPos pos) {
        // Verificar si hay un patrón de portal de diamante (3x3 o similar)
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos checkPos = pos.add(x, 0, z);
                if (world.getBlockState(checkPos).getBlock() != Blocks.DIAMOND_BLOCK) {
                    return false;
                }
            }
        }
        return true;
    }

    private void teleportToChaos(PlayerEntity player) {
        if (player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer) {
            ServerWorld chaosWorld = serverPlayer.getServer().getWorld(net.minecraft.util.Identifier.of("caostaotal", "chaos"));
            if (chaosWorld != null) {
                serverPlayer.teleport(chaosWorld, 100, 100, 100, 0, 0);
                serverPlayer.sendMessage(Text.literal("§6✨ Bienvenido a la Dimensión del Caos ✨"), false);
            } else {
                player.sendMessage(Text.literal("§cLa dimensión no existe"), false);
            }
        }
    }

    private void teleportToOverworld(PlayerEntity player) {
        if (player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer) {
            ServerWorld overworldWorld = serverPlayer.getServer().getWorld(net.minecraft.util.Identifier.of("minecraft", "overworld"));
            if (overworldWorld != null) {
                serverPlayer.teleport(overworldWorld, 0, 100, 0, 0, 0);
                serverPlayer.sendMessage(Text.literal("§aHas escapado del Caos"), false);
            }
        }
    }
}
