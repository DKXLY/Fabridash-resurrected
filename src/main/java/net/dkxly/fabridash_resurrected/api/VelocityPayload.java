package net.dkxly.fabridash_resurrected.api;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import static net.dkxly.fabridash_resurrected.FabridashResurrectedMod.MOD_ID;

public record VelocityPayload(Vec3d vec3d) implements CustomPayload {
    public static PacketCodec<io.netty.buffer.ByteBuf, Vec3d> VEC3D_PACKET_CODEC = new PacketCodec<>() {
        public Vec3d decode(ByteBuf byteBuf) {
            return new Vec3d(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        }

        public void encode(ByteBuf byteBuf, Vec3d vec3d) {
            byteBuf.writeDouble(vec3d.getX());
            byteBuf.writeDouble(vec3d.getY());
            byteBuf.writeDouble(vec3d.getZ());
        }
    };

    public static final CustomPayload.Id<VelocityPayload> ID = new CustomPayload.Id<>(Identifier.of(MOD_ID, "velocity_payload"));
    public static final PacketCodec<RegistryByteBuf, VelocityPayload> CODEC = PacketCodec.tuple(VEC3D_PACKET_CODEC, VelocityPayload::vec3d, VelocityPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
