package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class FabridashResurrectedItems {

    public static final Item IRON_DASHER = registerItem("iron_dasher",
            new IronDasher(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_DASHER = registerItem("diamond_dasher",
            new DiamondDasher(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item OBSIDIAN_DASHER = registerItem("obsidian_dasher",
            new ObsidianDasher(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item DASH_GLOBE = registerItem("dash_globe",
            new DashGlobe(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(64).group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabridashResurrectedMod.MOD_ID, name), item);
    }

    public static void registerItems(){
        FabridashResurrectedMod.LOGGER.info("Registering items...");
    }
}
