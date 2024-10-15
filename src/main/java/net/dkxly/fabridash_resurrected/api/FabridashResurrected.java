package net.dkxly.fabridash_resurrected.api;

import net.dkxly.fabridash_resurrected.sounds.FabridashResurrectedSounds;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.LOGGER;

public class FabridashResurrected {
    
    private static Random random = new Random();

    /**
     * With this you can launch (or "dash") an entity to 4 directions
     *
     * @param entity The entity that will perform the dash/will be launched
     * @param power The power of the dash AKA how far it will go
     * @param direction The direction in which the dash will go, 0 - forwards, 1 - to the right, 2 - backwards, 3 - to the left
     * */
    public static void dash(Entity entity, float power, int direction){
        float f = entity.getYaw();
        float g = entity.getPitch();

        if (direction == 1) {
            f += 90;
            if (f > 360) {
                f = f - 360;
            }
        } else if (direction == 2) {
            f += 180;
            if (f > 360) {
                f = f - 360;
            }
        } else if (direction == 3) {
            f += 270;
            if (f > 360) {
                f = f - 360;
            }
        }

        float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
        float k = -MathHelper.sin(g * 0.017453292F);
        float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
        float m = MathHelper.sqrt(h * h + k * k + l * l);
        float n = 3.0F * ((1.0F + power) / 4.0F);
        h *= n / m;
        k *= n / m;
        l *= n / m;
        entity.addVelocity(h, k, l);

        if (entity instanceof ServerPlayerEntity) {
            sendVelocityPacket((ServerPlayerEntity) entity, entity.getVelocity());
        }
        for (int i = 0; i<50; i++) {
            entity.getWorld().addParticle(ParticleTypes.CLOUD, entity.getX()+random.nextFloat(), entity.getY()+random.nextFloat(), entity.getZ()+random.nextFloat(), 0, 0.1, 0);
        }

        entity.playSound(FabridashResurrectedSounds.DASH, 1, 1);
    }

    public static void sendVelocityPacket(ServerPlayerEntity player, Vec3d vec3d){
        try {
            ServerPlayNetworking.send(player, new VelocityPayload(vec3d));
        } catch(Exception e) {
            LOGGER.error("FAILED to send velocity packet to the client!");
            e.printStackTrace();
        }
    }
}
