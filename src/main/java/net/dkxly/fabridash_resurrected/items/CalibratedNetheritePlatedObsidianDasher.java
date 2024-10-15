package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.dkxly.fabridash_resurrected.api.FabridashResurrected;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.fallDamageImmune;

public class CalibratedNetheritePlatedObsidianDasher extends Item {
    public CalibratedNetheritePlatedObsidianDasher(Item.Settings settings) {
        super(settings);
    }

    public ItemStack getDefaultStack() {
        ItemStack itemStack = new ItemStack(this);
        NbtCompound tag = itemStack.getOrCreateNbt();

        // 0 - forwards, 1 - right, 2 - backwards, 3 - left
        tag.putInt("direction", 0);

        // Apply the tag to the item
        itemStack.setNbt(tag);
        return itemStack;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        try {
            if (stack.getNbt().getInt("direction") >= 4 || stack.getNbt().getInt("direction") <= -1) {
                world.getServer().sendMessage(Text.literal("For the love of god please don't change NBT stuff if you don't want something to break really badly").formatted(Formatting.RED));
                world.getServer().sendMessage(Text.literal("Defaulting the direction NBT tag to 0").formatted(Formatting.RED));
                FabridashResurrectedMod.LOGGER.info("For the love of god please don't change NBT stuff if you don't want something to break really badly");
                FabridashResurrectedMod.LOGGER.info("Defaulting the direction NBT tag to 0");
                stack.getNbt().putInt("direction", 0);
            }
        } catch (Exception e) {
            NbtCompound tag = stack.getOrCreateNbt();

            // 0 - forwards, 1 - right, 2 - backwards, 3 - left
            tag.putInt("direction", 0);
            // Apply the tag to the item
            stack.setNbt(tag);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Right-click to dash").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Shift Right-click to change the dash direction").formatted(Formatting.GRAY, Formatting.ITALIC));
        tooltip.add(Text.empty());
        tooltip.add(Text.literal("TIP: Jump while dashing to go farther.").formatted(Formatting.GRAY));

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (user.isSneaking()) {
            try {
                switch ((stack.getNbt().getInt("direction"))) {
                    case 0 -> {
                        stack.getNbt().putInt("direction", 1);
                        stack.getNbt().putInt("CustomModelData", 1);
                    }
                    case 1 -> {
                        stack.getNbt().putInt("direction", 2);
                        stack.getNbt().putInt("CustomModelData", 2);
                    }
                    case 2 -> {
                        stack.getNbt().putInt("direction", 3);
                        stack.getNbt().putInt("CustomModelData", 3);
                    }
                    case 3 -> {
                        stack.getNbt().putInt("direction", 0);
                        stack.getNbt().putInt("CustomModelData", 0);
                    }
                }
            } catch (Exception ignored) {}
        } else {
            fallDamageImmune = true;

            user.getItemCooldownManager().set(this, 80);
            if (!world.isClient) {
                try {
                    FabridashResurrected.dash(user, 5 * world.getGameRules().getInt(FabridashResurrectedMod.DASH_MULTIPLIER), stack.getNbt().getInt("direction"));
                } catch (Exception ignored) {
                }
            }
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
