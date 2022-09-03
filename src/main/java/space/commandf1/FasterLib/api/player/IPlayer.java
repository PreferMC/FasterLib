package space.commandf1.FasterLib.api.player;

import java.util.*;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class IPlayer {
    private final Player player;
    
    private IPlayer(Player player) {
        this.player = player;
    }

    public static IPlayer toIPlayer(Player player) {
        return new IPlayer(player);
    }

    /**
     *
     * 崩溃玩家的客户端
     *
     * @param packetNum 需要传入包的数量
     * @author commandf1
     * */
    public void crashPlayer(int packetNum) {
        if (packetNum <= 0) {
            packetNum = 600;
        }
        Location location = player.getLocation();
        PacketPlayOutExplosion packetPlayOutExplosion = new PacketPlayOutExplosion(
                location.getX(), location.getY(), location.getZ(), Float.MAX_VALUE,
                new ArrayList<>(), new Vec3D(location.getX(), location.getY(), location.getZ())
        );
        CraftPlayer craftPlayer = (CraftPlayer) (Player) this;
        for (int i = 0; i < packetNum; i++) {
            craftPlayer.getHandle().playerConnection.sendPacket(packetPlayOutExplosion);
        }
    }

    /**
     *
     * 崩溃玩家的客户端
     *
     * @author commandf1
     * */
    public void crashPlayer() {
        Location location = player.getLocation();
        PacketPlayOutExplosion packetPlayOutExplosion = new PacketPlayOutExplosion(
                location.getX(), location.getY(), location.getZ(), Float.MAX_VALUE,
                new ArrayList<>(), new Vec3D(location.getX(), location.getY(), location.getZ())
        );
        CraftPlayer craftPlayer = (CraftPlayer) (Player) this;
        for (int i = 0; i < 600; i++) {
            craftPlayer.getHandle().playerConnection.sendPacket(packetPlayOutExplosion);
        }
    }

    /**
     * 使用十六进制颜色发送消息
     * @author commandf1
     *
     * 注意: 仅限高版本使用
     * */
    public void sendMessage(String message, Color color) {
        player.sendRawMessage("{\"text\":\"" + message + "\",\"color\":\"#" + color.asBGR() + "\"}");
    }

    /**
     * 使用十六进制颜色发送消息
     * @author commandf1
     *
     * 注意: 仅限高版本使用
     * */
    public void sendMessage(String message, int color) {
        player.sendRawMessage("{\"text\":\"" + message + "\",\"color\":\"#" + color + "\"}");
    }

    /**
     * 以内部错误踢出玩家
     * @author commandf1
     *
     * */
    public void errorKick() {
        String[] errors = {"Internal Exception: io.netty.handler.codec.DecoderException: java.lang.IllegalArgumentException: java.lang.ClassCastException" , "java.net.SocketTimeoutException: Time out" , "Internal Exception: java.io.IOException: Connection reset by peer" , "Timed out" , "Internal Exception: io.netty.handler.codec.DecoderException: java.lang.RuntimeException: An internal error occured." , "Internal Exception: java.io.IOException: Error while read(...): Connection reset by peer" , "Internal Exception: java.io.IOException: 远程主机强迫关闭了一个现有的连接" , "Internal Exception: java.io.IOException: 您的主机中的软件终止了一个已建立的连接" , "Internal Exception: io.netty.handler.timeout.ReadTimeoutException"};
        player.kickPlayer(errors[new Random().nextInt(errors.length - 1)]);
    }

    /**
     * 获取Player实例
     *
     * */
    public Player getPlayer() {
        return player;
    }
}
