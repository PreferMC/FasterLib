package space.commandf1.FasterLib.api.server;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class IServer {
    private final Server server;

    private IServer(Server server) {
        this.server = server;
    }

    /**
     *
     * 踢出所有玩家
     * 需要提供原因
     *
     * @author commandf1
     * */
    public void kickAllPlayers(String reason) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kickPlayer(reason);
        }
    }

    /**
     * 踢出所有玩家
     * 可以指定不踢出的玩家
     * @author commandf1
     *
     * */
    public void kickAllPlayers(String reason, Player ig) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(ig)) {
                player.kickPlayer(reason);
            }
        }
    }

    /**
     * 暂停服务器线程
     * 指定假卡顿 不要使用多线程调用
     *
     * @author commandf1
     *
     * */
    public void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    /**
     * 取消服务器所有OP
     *
     * @author commandf1
     *
     * */
    public void unsetAllOperators() {
        for (OfflinePlayer operator : this.server.getOperators()) {
            operator.setOp(false);
        }
    }

    /**
     * 发消息给后台
     *
     * @author commandf1
     *
     * */
    public void sendMessage(String message) {
        this.server.getConsoleSender().sendMessage(message);
    }

    /**
     * 转换到IServer实例
     *
     * */
    public static IServer toIServer(Server server) {
        return new IServer(server);
    }

    /**
     * 获取Server实例
     *
     * */
    public Server getServer() {
        return this.server;
    }
}
