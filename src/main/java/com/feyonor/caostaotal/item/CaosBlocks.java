package com.feyonor.caostaotal.item;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.feyonor.caostaotal.CaosTotalMod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosBlocks {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-blocks");
    
    // Bloques del Caos
    public static Block CHAOS_BLOCK;
    public static Block CHAOS_ORE;
    public static Block CHAOS_BRICKS;

    public static void registerBlocks() {
        LOGGER.info("🧱 Registrando bloques de Caos Total V3...");
        
        // Bloque de Caos
        CHAOS_BLOCK = registerBlock("chaos_block", new Block(
            AbstractBlock.Settings.of(Material.STONE).strength(50f, 50f)
        ));
        
        // Mineral de Caos
        CHAOS_ORE = registerBlock("chaos_ore", new Block(
            AbstractBlock.Settings.of(Material.STONE).strength(5f, 5f)
        ));
        
        // Ladrillos de Caos
        CHAOS_BRICKS = registerBlock("chaos_bricks", new Block(
            AbstractBlock.Settings.of(Material.STONE).strength(3f, 3f)
        ));
        
        LOGGER.info("✅ Bloques registrados correctamente");
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CaosTotalMod.MOD_ID, name), block);
    }
}
