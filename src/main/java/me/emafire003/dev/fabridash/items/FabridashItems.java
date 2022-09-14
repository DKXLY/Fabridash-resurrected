package me.emafire003.dev.fabridash.items;

import me.emafire003.dev.fabridash.FabridashMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabridashItems {

    public static final Item IRON_DASHER = registerItem("iron_dasher",
            new IronDasher(new FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item DIAMOND_DASHER = registerItem("diamond_dasher",
            new DiamondDasher(new FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item OBSIDIAN_DASHER = registerItem("obsidian_dasher",
            new ObsidianDasher(new FabricItemSettings().maxCount(1).group(ItemGroup.COMBAT)));

    public static final Item DASH_GLOBE = registerItem("dash_globe",
            new DashGlobe(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FabridashMod.MOD_ID, name), item);
    }

    public static void registerItems(){
        FabridashMod.LOGGER.info("Registering items...");
    }
}
