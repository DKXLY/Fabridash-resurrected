package net.dkxly.fabridash_resurrected.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.MOD_ID;
import static net.dkxly.fabridash_resurrected.items.FabridashResurrectedItems.FABRIDASH_RESURRECTED_LOGO;

public class FabridashResurrectedItemGroups {
    public static final ItemGroup FABRIDASH_RESURRECTED = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "fabridash_resurrected"), () -> new ItemStack(FABRIDASH_RESURRECTED_LOGO));
}
