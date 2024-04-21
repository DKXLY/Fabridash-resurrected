package net.dkxly.fabridash_resurrected.config;

import blue.endless.jankson.Comment;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.*;

@Modmenu(modId = "fabridash_resurrected")
@Config(name = "fabridash_resurrected", wrapperName = "FabridashResurrectedConfig")
public class FabridashResurrectedConfigModel {
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public boolean item_functionality = true;

    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    public boolean dash_cancel_fall_damage = true;

    @RestartRequired @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    @Comment("nigga")
    public boolean dash_globe_generation = true;
}
