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

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.fallDamageImmune;

public class IronDasher extends Item {

    public IronDasher(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Right-click to dash").formatted(Formatting.GOLD));
        tooltip.add(Text.empty());
        tooltip.add(Text.literal("TIP: Jump while dashing to go farther.").formatted(Formatting.GRAY));

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 120);
        if (!world.isClient) {
            FabridashResurrected.dash(user, world.getGameRules().getInt(FabridashResurrectedMod.DASH_MULTIPLIER), 0);
        }
        fallDamageImmune = true;

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
