package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.dkxly.fabridash_resurrected.api.FabridashResurrected;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ObsidianDasher extends Item {

    public ObsidianDasher(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 120);
        if(!world.isClient){
            FabridashResurrected.dash(user, 2*world.getGameRules().getInt(FabridashResurrectedMod.DASH_MULTIPLIER), true);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}
