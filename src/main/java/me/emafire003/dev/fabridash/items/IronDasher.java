package me.emafire003.dev.fabridash.items;

import me.emafire003.dev.fabridash.FabridashMod;
import me.emafire003.dev.fabridash.api.Fabridash;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class IronDasher extends Item {

    public IronDasher(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 120);
        Fabridash.dash(user, world.getGameRules().getInt(FabridashMod.DASH_MULTIPLIER), false);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
