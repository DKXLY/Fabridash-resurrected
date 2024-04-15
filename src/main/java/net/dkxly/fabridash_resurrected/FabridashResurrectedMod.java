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
    }

    /**
     * Should items (iron dasher, diamond dasher, etc.)
     * be added by this mod instance?
     *
     * @param b Set this to false to disable items, true (default) to enable them
     *          CURRENTLY DOESN'T WORK!!!
     * */
    public static void toggleItems(boolean b){
        Config.ITEMS_ENABLED = b;
        Config.reloadConfig();
    }
}