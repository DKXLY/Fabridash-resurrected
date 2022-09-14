package me.emafire003.dev.fabridash;

import me.emafire003.dev.fabridash.config.Config;
import me.emafire003.dev.fabridash.items.FabridashItems;
import me.emafire003.dev.fabridash.sounds.FabridashSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabridashMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "fabridash";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRules.Key<GameRules.IntRule> DASH_MULTIPLIER =
            GameRuleRegistry.register("dashMultiplier", GameRules.Category.MISC, GameRuleFactory.createIntRule(1));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        LOGGER.info("Loading Fabridash mod...");
        Config.registerConfigs();
        FabridashSounds.registerSounds();
        if(Config.ITEMS_ENABLED){
            FabridashItems.registerItems();
            LootTableModifier.modifyLootTables();
        }
    }
}