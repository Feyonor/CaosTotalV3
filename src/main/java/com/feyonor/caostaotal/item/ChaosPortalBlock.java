package com.feyonor.caostaotal.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;

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
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
