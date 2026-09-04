package com.feyonor.caostaotal.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.feyonor.caostaotal.CaosTotalMod;

public class CaosBlocks {
    
    // Bloques del Caos
    public static Block CHAOS_PORTAL_BLOCK;

    public static void registerBlocks() {
        // Registrar bloque del portal del Caos
        CHAOS_PORTAL_BLOCK = registerBlock("chaos_portal", 
            new ChaosPortalBlock(Block.Settings.copy(Blocks.OBSIDIAN)
                .strength(-1.0f, 3600000.0f)
                .luminance(state -> 15)
                .noCollision()));
        
        CaosTotalMod.LOGGER.info("✨ Bloques del Caos registrados!");
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CaosTotalMod.MOD_ID, name), block);
    }
}
