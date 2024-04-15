package net.dkxly.fabridash_resurrected.sounds;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.LOGGER;

public class FabridashResurrectedSounds {

    public static SoundEvent DASH = registerSoundEvent("dash");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FabridashResurrectedMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        LOGGER.info("Registering sound effects...");
    }

}
