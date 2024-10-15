package net.dkxly.fabridash_resurrected.mixin;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.LOGGER;
import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.playerJoinedSingleplayerWorld;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(method = "onPlayerConnect", at = @At("HEAD"))
    public void injected(ClientConnection connection, @NotNull ServerPlayerEntity player, ConnectedClientData data, CallbackInfo ci) {
        playerJoinedSingleplayerWorld = player.server.isSingleplayer();
    }
}
