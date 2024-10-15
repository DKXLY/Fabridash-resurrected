package net.dkxly.fabridash_resurrected.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.playerJoinedSingleplayerWorld;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(method = "onPlayerConnect", at = @At("HEAD"))
    public void injected(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        playerJoinedSingleplayerWorld = player.server.isSingleplayer();
    }
}
