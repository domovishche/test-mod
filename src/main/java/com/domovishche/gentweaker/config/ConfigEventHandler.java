package com.domovishche.gentweaker.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// Replace "yourmod" with your actual Mod ID!
@Mod.EventBusSubscriber(modid = "gentweaker")
public class ConfigEventHandler {

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        // Check if the config being changed belongs to your mod
        if (event.getModID().equals("gentweaker")) {
            // Force Forge to save the changes from memory to the .cfg file on your disk
            ConfigManager.sync("gentweaker", Config.Type.INSTANCE);
        }
    }
}
