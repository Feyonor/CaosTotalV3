package com.feyonor.caostaotal.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.text.Text;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class ChaosPortalBlock extends Block {
    public ChaosPortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            // Efecto visual cuando alguien entra en el portal
            for (int i = 0; i < 10; i++) {
                world.addParticle(
                    ParticleTypes.SOUL_FIRE_FLAME,
                    pos.getX() + Math.random(),
                    pos.getY() + Math.random(),
                    pos.getZ() + Math.random(),
                    (Math.random() - 0.5) * 0.2,
                    (Math.random() - 0.5) * 0.2,
                    (Math.random() - 0.5) * 0.2
                );
            }

            // Teletransporte automático
            if (player instanceof ServerPlayerEntity serverPlayer) {
                // Determinar a dónde ir
                String currentDim = serverPlayer.getWorld().getDimensionKey().getValue().toString();
                
                if (currentDim.equals("minecraft:overworld")) {
                    // Ir a la dimensión del Caos
                    teletransportToChaos(serverPlayer);
                } else if (currentDim.equals("caostaotal:chaos")) {
                    // Volver al mundo normal
                    teletransportToOverworld(serverPlayer);
                }
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    private void teletransportToChaos(ServerPlayerEntity player) {
        ServerWorld chaosWorld = player.getServer().getWorld(new net.minecraft.util.Identifier("caostaotal", "chaos"));
        if (chaosWorld != null) {
            player.teleport(chaosWorld, 100.0d, 100.0d, 100.0d, 0.0f, 0.0f);
            player.sendMessage(Text.literal("§c✨ ¡ENTRASTE AL CAOS TOTAL! ✨"), false);
        } else {
            player.sendMessage(Text.literal("§cError: La dimensión del Caos no existe"), false);
        }
    }

    private void teletransportToOverworld(ServerPlayerEntity player) {
        ServerWorld overworldWorld = player.getServer().getWorld(new net.minecraft.util.Identifier("minecraft", "overworld"));
        if (overworldWorld != null) {
            player.teleport(overworldWorld, 0.0d, 100.0d, 0.0d, 0.0f, 0.0f);
            player.sendMessage(Text.literal("§a✨ ¡ESCAPASTE DEL CAOS! ✨"), false);
        } else {
            player.sendMessage(Text.literal("§cError: El mundo normal no existe"), false);
        }
    }
}
