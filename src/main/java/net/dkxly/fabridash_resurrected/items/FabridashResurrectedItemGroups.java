package net.dkxly.fabridash_resurrected.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.*;

public class FabridashResurrectedItemGroups {
    public static void registerItemGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(MOD_ID, MOD_ID),
                FabridashResurrectedItemGroups.FABRIDASH_RESURRECTED
        );
    }

    public static final ItemGroup FABRIDASH_RESURRECTED = FabricItemGroup.builder()
            .displayName(Text.literal("Fabridash Resurrected"))
            .icon(() -> new ItemStack(FabridashResurrectedItems.FABRIDASH_RESURRECTED_LOGO))
            .entries((displayContext, entries) -> {
                for(int i = 0; i < itemList.size(); i++) {
                    entries.add(itemList.get(i));
                }
            })
            .build();
}
