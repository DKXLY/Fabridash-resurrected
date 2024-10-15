package net.dkxly.fabridash_resurrected.sounds;

import net.dkxly.fabridash_resurrected.FabridashResurrectedMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.LOGGER;

public class FabridashResurrectedSounds {

    public static SoundEvent DASH = registerSoundEvent("dash");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(FabridashResurrectedMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        LOGGER.info("Registering sound effects...");
    }

}
