package net.dkxly.fabridash_resurrected.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.*;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Unique
    private static boolean startSecondHandling;

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    public void injected(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (fallDamageImmune) {
            fallDamageImmune = false;
            startSecondHandling = true;

            cir.setReturnValue(false);
        } else if (startSecondHandling && playerJoinedSingleplayerWorld) {
            startSecondHandling = false;
            cir.setReturnValue(false);
        }
    }
}
