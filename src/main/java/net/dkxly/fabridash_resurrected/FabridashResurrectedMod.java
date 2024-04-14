package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.config.Config;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItemGroups;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems;
import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class FabridashResurrectedMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static ArrayList<Item> itemList = new ArrayList<>();
    public static final String MOD_ID = "fabridash_resurrected";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final GameRules.Key<GameRules.IntRule> DASH_MULTIPLIER =
            GameRuleRegistry.register("dashMultiplier", GameRules.Category.MISC, GameRuleFactory.createIntRule(1));

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Fabridash Resurrected!");

        Config.registerConfigs();
        FabridashResurrectedSounds.registerSounds();
        if(Config.ITEMS_ENABLED){
            FabridashResurrectedItems.registerItems();
            LootTableModifier.modifyLootTables();
        }

        Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(MOD_ID, MOD_ID),
                FabridashResurrectedItemGroups.FABRIDASH_RESURRECTED
        );
    }

    /**
     * Should items (iron dasher, diamond dasher, etc.)
     * be added by this mod instance?
     *
     * @param b Set this to falso to disable items, true (default) to enable them
     * */
    public static void toggleItems(boolean b){
        Config.ITEMS_ENABLED = b;
        Config.reloadConfig();
    }
}