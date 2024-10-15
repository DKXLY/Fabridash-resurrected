package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.api.VelocityPayload;
import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.NoSuchElementException;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.LOGGER;

public class FabridashResurrectedClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        registerVelocityPacket();
    }

    private void registerVelocityPacket(){
        ClientPlayNetworking.registerGlobalReceiver(VelocityPayload.ID, (payload, context) -> context.client().execute(() -> {
            try {
                context.player().setVelocity(payload.vec3d());
                context.player().playSound(FabridashResurrectedSounds.DASH, 1, 1);
            } catch (NoSuchElementException noSuchElementException){
                LOGGER.warn("No value in the payload, probably not a big problem");
            } catch (Exception exception){
                LOGGER.error("There was an error while getting the velocity payload!");
                exception.printStackTrace();
            }
        }));
    }
}
