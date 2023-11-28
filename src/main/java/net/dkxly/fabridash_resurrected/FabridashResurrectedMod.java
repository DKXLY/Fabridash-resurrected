package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.config.Config;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems;
import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabridashResurrectedMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "fabridash_resurrected";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRules.Key<GameRules.IntRule> DASH_MULTIPLIER =
            GameRuleRegistry.register("dashMultiplier", GameRules.Category.MISC, GameRuleFactory.createIntRule(1));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        LOGGER.info("Loading Fabridash Resurrected!");
        Config.registerConfigs();
        FabridashResurrectedSounds.registerSounds();
        if(Config.ITEMS_ENABLED){
            FabridashResurrectedItems.registerItems();
            LootTableModifier.modifyLootTables();
        }
    }

    /**
     * Should items (iron dasher, diamond dasher, ecc)
     * be added by this mod instance?
     *
     * @param b Set this to falso to disable items, true (default) to enable them
     * */
    public static void toggleItems(boolean b){
        Config.ITEMS_ENABLED = b;
        Config.reloadConfig();
    }
}