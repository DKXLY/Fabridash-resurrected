package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.itemList;

public class FabridashResurrectedItems {

    public static final Item IRON_DASHER = registerItem("iron_dasher",
            new IronDasher(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));

    public static final Item DIAMOND_DASHER = registerItem("diamond_dasher",
            new DiamondDasher(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));

    public static final Item OBSIDIAN_DASHER = registerItem("obsidian_dasher",
            new ObsidianDasher(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));

    public static final Item DASH_GLOBE = registerItem("dash_globe",
            new DashGlobe(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(64)));

    private static Item registerItem(String name, Item item){
        Item registryEntry = Registry.register(Registries.ITEM, new Identifier(FabridashResurrectedMod.MOD_ID, name), item);
        itemList.add(registryEntry);
        return registryEntry;
    }

    public static void registerItems(){
        FabridashResurrectedMod.LOGGER.info("Registering items...");
    }
}
