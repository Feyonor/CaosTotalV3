package com.feyonor.caostaotal.dimension;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ChaosChunkGenerator extends ChunkGenerator {
    private static final Identifier PLAINS_BIOME = new Identifier("minecraft:plains");

    public ChaosChunkGenerator(BiomeAccess biomeAccess) {
        super(biomeAccess, null);
    }

    @Override
    public void generateFeatures(ChunkRegion region, StructureAccessor structureAccessor) {
        // Generar características especiales del Caos
    }

    @Override
    public void carve(ChunkRegion region, long seed, BiomeAccess biomeAccess, Chunk chunk) {
        // Carving personalizado si es necesario
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Executor executor, StructureAccessor structureAccessor, Chunk chunk) {
        // Generar el terreno del Caos
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 256; y++) {
                    mutable.set(chunk.getPos().getStartX() + x, y, chunk.getPos().getStartZ() + z);
                    
                    if (y < 60) {
                        chunk.setBlockState(mutable, Blocks.OBSIDIAN.getDefaultState(), false);
                    } else if (y < 80) {
                        // Capa con bloques de diamante y obsidiana
                        if (Math.random() > 0.7) {
                            chunk.setBlockState(mutable, Blocks.DIAMOND_BLOCK.getDefaultState(), false);
                        } else {
                            chunk.setBlockState(mutable, Blocks.OBSIDIAN.getDefaultState(), false);
                        }
                    } else if (y < 120) {
                        // Plataformas flotantes de netherite y diamante
                        int localX = mutable.getX() % 16;
                        int localZ = mutable.getZ() % 16;
                        
                        if (localX % 3 == 0 && localZ % 3 == 0) {
                            chunk.setBlockState(mutable, Blocks.NETHERITE_BLOCK.getDefaultState(), false);
                        } else if (Math.random() > 0.8) {
                            chunk.setBlockState(mutable, Blocks.DIAMOND_BLOCK.getDefaultState(), false);
                        } else {
                            chunk.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                        }
                    } else if (y < 140) {
                        // Cielo con TNT flotante
                        if (Math.random() > 0.95) {
                            chunk.setBlockState(mutable, Blocks.TNT.getDefaultState(), false);
                        } else if (Math.random() > 0.9) {
                            chunk.setBlockState(mutable, Blocks.REDSTONE_BLOCK.getDefaultState(), false);
                        } else {
                            chunk.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                        }
                    } else {
                        chunk.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
        
        chunk.setHeightmap(Heightmap.Type.MOTION_BLOCKING, new int[256]);
        chunk.setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, new int[256]);
        
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmap) {
        return 100;
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z) {
        BlockState[] states = new BlockState[256];
        for (int i = 0; i < 256; i++) {
            if (i < 60) {
                states[i] = Blocks.OBSIDIAN.getDefaultState();
            } else if (i < 80) {
                states[i] = Blocks.DIAMOND_BLOCK.getDefaultState();
            } else if (i < 120) {
                states[i] = Blocks.NETHERITE_BLOCK.getDefaultState();
            } else {
                states[i] = Blocks.AIR.getDefaultState();
            }
        }
        return new VerticalBlockSample(0, states);
    }

    @Override
    public List<Biome> getBiomesForGeneration(int x, int z) {
        return List.of();
    }
}
