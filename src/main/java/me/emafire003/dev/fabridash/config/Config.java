package me.emafire003.dev.fabridash.config;

import com.mojang.datafixers.util.Pair;
import me.emafire003.dev.fabridash.FabridashMod;

import static me.emafire003.dev.fabridash.FabridashMod.LOGGER;

public class Config {
    public static SimpleConfig CONFIG;
    private static ConfigProvider configs;

    public static boolean ITEMS_ENABLED;

    public static void registerConfigs() {
        configs = new ConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(FabridashMod.MOD_ID + "_config").provider(configs).request();

        assignConfigs();
        LOGGER.info("All " + configs.getConfigsList().size() + " have been set properly");
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("items_enabled", true), "Should dash items be in game? (Requires restart)");
    }

    public static void reloadConfig(){
        registerConfigs();
        LOGGER.info("All " + configs.getConfigsList().size() + " have been reloaded properly");

    }

    private static void assignConfigs() {
        ITEMS_ENABLED = CONFIG.getOrDefault("items_enabled", true);

    }
}

