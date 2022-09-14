package me.emafire003.dev.fabridash;

import me.emafire003.dev.fabridash.api.VelocityPacketS2C;
import me.emafire003.dev.fabridash.sounds.FabridashSounds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.NoSuchElementException;

import static me.emafire003.dev.fabridash.FabridashMod.LOGGER;

public class FabridashClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        registerVelocityPacket();
    }

    private void registerVelocityPacket(){
        LOGGER.info("Registering windlight velocity packet receiver on client...");
        ClientPlayNetworking.registerGlobalReceiver(VelocityPacketS2C.ID, ((client, handler, buf, responseSender) -> {
            var results = VelocityPacketS2C.read(buf);

            client.execute(() -> {
                try{
                    client.player.setVelocity(results);
                    client.player.playSound(FabridashSounds.DASH, 1, 1);
                }catch (NoSuchElementException e){
                    LOGGER.warn("No value in the packet, probably not a big problem");
                }catch (Exception e){
                    LOGGER.error("There was an error while getting the packet!");
                    e.printStackTrace();
                }
            });
        }));
    }
}
