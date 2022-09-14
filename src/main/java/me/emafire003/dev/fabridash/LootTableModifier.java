package me.emafire003.dev.fabridash;

import me.emafire003.dev.fabridash.items.FabridashItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

//Will be able to find the globe in various loot chests, with a chance between 9%-30% in the end city
public class LootTableModifier {
    private static final Identifier ANCIENT_CITY
            = new Identifier("minecraft", "chests/ancient_city");

    private static final Identifier MINESHAFT
            = new Identifier("minecraft", "chests/abandoned_mineshaft");

    private static final Identifier PILLAGER_OUTPOST
            = new Identifier("minecraft", "chests/pillager_outpost");

    private static final Identifier SIMPLE_DUNGEON
            = new Identifier("minecraft", "chests/simple_dungeon");

    private static final Identifier SHIPWRECK_MAP
            = new Identifier("minecraft", "chests/shipwreck_map");

    private static final Identifier STRONGHOLD_LIBRARY
            = new Identifier("minecraft", "chests/stronghold_library");

    private static final Identifier END_CITY_TREASURE
            = new Identifier("minecraft", "chests/end_city_treasure");

    private static final Identifier IGLOO_STRUCTURE_CHEST_ID
            = new Identifier("minecraft", "chests/igloo_chest");



    public static void modifyLootTables() {
        FabridashMod.LOGGER.info("Modifying loot tables to generate the dash globe...");
        float chance = 0.15f;
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (IGLOO_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());

            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (MINESHAFT.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance-0.06f))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                supplier.pool(poolBuilder1.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (SHIPWRECK_MAP.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.1f))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (SIMPLE_DUNGEON.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (PILLAGER_OUTPOST.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.03f))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());

            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (STRONGHOLD_LIBRARY.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());

            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (END_CITY_TREASURE.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.1f))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (ANCIENT_CITY.equals(id)) {

                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.06f))
                        .with(ItemEntry.builder(FabridashItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder1.build());
            }
        }));
    }
}
