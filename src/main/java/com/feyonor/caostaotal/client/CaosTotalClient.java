package com.feyonor.caostaotal.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class CaosTotalClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("caostaotal-client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Caos Total V3 - Cliente cargado!");
    }
}