package com.feyonor.caostaotal;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import com.feyonor.caostaotal.command.HomeCommand;
import com.feyonor.caostaotal.command.AdminCommand;
import com.feyonor.caostaotal.config.CaosConfig;
import com.feyonor.caostaotal.events.CaosEventManager;
import com.feyonor.caostaotal.events.PlayerSpawnEventListener;
import com.feyonor.caostaotal.item.CaosItems;
import com.feyonor.caostaotal.item.CaosRecipes;
import com.feyonor.caostaotal.item.CaosBlocks;
import com.feyonor.caostaotal.dimension.ChaosDimension;
import com.feyonor.caostaotal.util.PlayerDeathCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaosTotalMod implements ModInitializer {
    public static final String MOD_ID = "caostaotal";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("═══════════════════════════════════════");
        LOGGER.info("⚡ ¡Iniciando Caos Total V3! ⚡");
        LOGGER.info("═══════════════════════════════════════");

        // Cargar configuración
        CaosConfig.load();
        LOGGER.info("✅ Configuración cargada");

        // Registrar bloques
        CaosBlocks.registerBlocks();

        // Registrar items
        CaosItems.registerItems();

        // Registrar recetas
        CaosRecipes.registerRecipes();

        // Registrar dimensión
        ChaosDimension.register();

        // Registrar listeners de eventos
        PlayerSpawnEventListener.register();
        LOGGER.info("✅ Event listeners registrados");

        // Registrar comandos
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            HomeCommand.register(dispatcher);
            AdminCommand.register(dispatcher);
            LOGGER.info("✅ Comandos registrados");
        });

        // Eventos del servidor
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            LOGGER.info("🎮 Servidor iniciado - Caos Total V3 activo");
            CaosEventManager.onServerStart(server);
        });

        // Tick del servidor para eventos aleatorios
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            CaosEventManager.onServerTick(server);
            PlayerDeathCounter.updateAll(server);
        });

        LOGGER.info("═══════════════════════════════════════");
        LOGGER.info("✨ ¡Caos Total V3 cargado correctamente! ✨");
        LOGGER.info("═══════════════════════════════════════");
    }
}
