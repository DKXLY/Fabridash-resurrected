package net.dkxly.fabridash_resurrected;

import net.dkxly.fabridash_resurrected.api.VelocityPacketS2C;
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
        ClientPlayNetworking.registerGlobalReceiver(VelocityPacketS2C.ID, ((client, handler, buf, responseSender) -> {
            var results = VelocityPacketS2C.read(buf);

            client.execute(() -> {
                try {
                    client.player.setVelocity(results);
                    client.player.playSound(FabridashResurrectedSounds.DASH, 1, 1);
                } catch (NoSuchElementException e){
                    LOGGER.warn("No value in the packet, probably not a big problem");
                } catch (Exception e){
                    LOGGER.error("There was an error while getting the packet!");
                    e.printStackTrace();
                }
            });
        }));
    }
}
