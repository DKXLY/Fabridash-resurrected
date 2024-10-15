package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.api.VelocityPayload;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItemGroups;
import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems;
import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
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

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Fabridash Resurrected!");

        PayloadTypeRegistry.playS2C().register(VelocityPayload.ID, VelocityPayload.CODEC);

        FabridashResurrectedItems.registerItems();
        FabridashResurrectedSounds.registerSounds();
        FabridashResurrectedItemGroups.registerItemGroups();
        LootTableModifications.modifyLootTables();
    }
}