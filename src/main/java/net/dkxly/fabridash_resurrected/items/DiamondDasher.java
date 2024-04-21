package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.dkxly.fabridash_resurrected.api.FabridashResurrected;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.FABRIDASH_RESURRECTED_CONFIG;
import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.fallDamageImmune;

public class DiamondDasher extends Item {

    public DiamondDasher(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (FABRIDASH_RESURRECTED_CONFIG.item_functionality()) {
            tooltip.add(Text.literal("Right-click to dash").formatted(Formatting.GOLD));
            tooltip.add(Text.empty());
            tooltip.add(Text.literal("TIP: Jump while dashing to go farther.").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.empty());
            tooltip.add(Text.literal("ITEM DISABLED").formatted(Formatting.DARK_RED, Formatting.BOLD));
            tooltip.add(Text.literal("Change the configuration in").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Mod menu or in the file to").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("enable item functionality.").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (FABRIDASH_RESURRECTED_CONFIG.item_functionality()) {
            user.getItemCooldownManager().set(this, 120);
            if (!world.isClient) {
                FabridashResurrected.dash(user, 3 * world.getGameRules().getInt(FabridashResurrectedMod.DASH_MULTIPLIER), 0);
            }

            fallDamageImmune = FABRIDASH_RESURRECTED_CONFIG.dash_cancel_fall_damage();
        }


        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
