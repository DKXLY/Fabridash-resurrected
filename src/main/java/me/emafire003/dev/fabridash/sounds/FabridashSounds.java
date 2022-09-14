package me.emafire003.dev.fabridash.sounds;

import me.emafire003.dev.fabridash.FabridashMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static me.emafire003.dev.fabridash.FabridashMod.LOGGER;

public class FabridashSounds {

    public static SoundEvent DASH = registerSoundEvent("dash");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FabridashMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        LOGGER.info("Registering sound effects...");
    }

}
