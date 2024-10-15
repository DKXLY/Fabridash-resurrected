package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class LootTableModifications {
    private static final Identifier IGLOO_CHEST = Identifier.of("minecraft", "chests/igloo_chest");
    private static final Identifier MINESHAFT_CHEST = Identifier.of("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier SHIPWRECK_MAP_CHEST = Identifier.of("minecraft", "chests/shipwreck_map");
    private static final Identifier SIMPLE_DUNGEON_CHEST = Identifier.of("minecraft", "chests/simple_dungeon");
    private static final Identifier PILLAGER_OUTPOST_CHEST = Identifier.of("minecraft", "chests/pillager_outpost");
    private static final Identifier STRONGHOLD_LIBRARY_CHEST = Identifier.of("minecraft", "chests/stronghold_library");
    private static final Identifier STRONGHOLD_CORRIDOR_CHEST = Identifier.of("minecraft", "chests/stronghold_corridor");
    private static final Identifier STRONGHOLD_CROSSING_CHEST = Identifier.of("minecraft", "chests/stronghold_crossing");
    private static final Identifier END_CITY_TREASURE_CHEST = Identifier.of("minecraft", "chests/end_city_treasure");
    private static final Identifier ANCIENT_CITY_CHEST = Identifier.of("minecraft", "chests/ancient_city");



    public static void modifyLootTables() {
        float chance = 0.38f;

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, IGLOO_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, MINESHAFT_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance-0.06f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, SHIPWRECK_MAP_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.1f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, SIMPLE_DUNGEON_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, PILLAGER_OUTPOST_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.03f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (
                    RegistryKey.of(RegistryKeys.LOOT_TABLE, STRONGHOLD_LIBRARY_CHEST).equals(key)
                    || RegistryKey.of(RegistryKeys.LOOT_TABLE, STRONGHOLD_CORRIDOR_CHEST).equals(key)
                    || RegistryKey.of(RegistryKeys.LOOT_TABLE, STRONGHOLD_CROSSING_CHEST).equals(key)
            ) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.08f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, END_CITY_TREASURE_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance+0.15f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (RegistryKey.of(RegistryKeys.LOOT_TABLE, ANCIENT_CITY_CHEST).equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(chance + 0.06f))
                        .with(ItemEntry.builder(FabridashResurrectedItems.DASH_GLOBE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
