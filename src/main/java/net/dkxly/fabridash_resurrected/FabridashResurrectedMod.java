package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.config.FabridashResurrectedConfig;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItemGroups;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems;
import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.api.ModInitializer;
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
    public static boolean playerJoinedSingleplayerWorld = false;

    public static boolean fallDamageImmune = false;

    public static ArrayList<Item> itemList = new ArrayList<>();

    public static final String MOD_ID = "fabridash_resurrected";
    public static final Logger LOGGER = LoggerFactory.getLogger("Fabridash Resurrected");

    public static final GameRules.Key<GameRules.IntRule> DASH_MULTIPLIER =
            GameRuleRegistry.register("dashMultiplier", GameRules.Category.MISC, GameRuleFactory.createIntRule(1));

    public static final FabridashResurrectedConfig FABRIDASH_RESURRECTED_CONFIG = FabridashResurrectedConfig.createAndLoad();

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Fabridash Resurrected!");

        FabridashResurrectedItems.registerItems();
        FabridashResurrectedSounds.registerSounds();

        if (FABRIDASH_RESURRECTED_CONFIG.dash_globe_generation()){
            LootTableModifier.modifyLootTables();
        }

        Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(MOD_ID, MOD_ID),
                FabridashResurrectedItemGroups.FABRIDASH_RESURRECTED
        );
    }
}