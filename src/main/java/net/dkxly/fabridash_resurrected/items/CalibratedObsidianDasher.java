package net.dkxly.fabridash_resurrected.items;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.dkxly.fabridash_resurrected.api.FabridashResurrected;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.fallDamageImmune;

public class CalibratedObsidianDasher extends Item {
    public CalibratedObsidianDasher(Settings settings) {
        super(settings);
    }

    public ItemStack getDefaultStack() {
        ItemStack stack = new ItemStack(this);
        stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(0));
        return stack;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        try {
            if (stack.get(DataComponentTypes.CUSTOM_MODEL_DATA).value() >= 4 || stack.get(DataComponentTypes.CUSTOM_MODEL_DATA).value() <= -1) {
                stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(0));

                world.getServer().sendMessage(Text.literal("Please dont change the components, thanks :)").formatted(Formatting.RED));
                world.getServer().sendMessage(Text.literal("Defaulting the custom_model_data component to 0").formatted(Formatting.RED));

                FabridashResurrectedMod.LOGGER.info("Please dont change the components, thanks :)");
                FabridashResurrectedMod.LOGGER.info("Defaulting the custom_model_data component to 0");
            }
        } catch (Exception e) {
            stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(0));
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Right-click to dash").formatted(Formatting.GOLD));
        tooltip.add(Text.literal("Shift Right-click to change the dash direction").formatted(Formatting.GRAY, Formatting.ITALIC));
        tooltip.add(Text.empty());
        tooltip.add(Text.literal("TIP: Jump while dashing to go farther.").formatted(Formatting.GRAY));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (user.isSneaking()) {
            try {
                switch (stack.get(DataComponentTypes.CUSTOM_MODEL_DATA).value()) {
                    case 0 -> stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(1));
                    case 1 -> stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(2));
                    case 2 -> stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(3));
                    case 3 -> stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(0));
                }
            } catch (Exception ignored) {
            }
        } else {
            user.getItemCooldownManager().set(this, 100);
            if (!world.isClient) {
                try {
                    FabridashResurrected.dash(user, 3 * world.getGameRules().getInt(FabridashResurrectedMod.DASH_MULTIPLIER), stack.get(DataComponentTypes.CUSTOM_MODEL_DATA).value());
                } catch (Exception ignored) {}
            }
            fallDamageImmune = true;
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
