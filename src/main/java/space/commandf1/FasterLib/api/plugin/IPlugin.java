package space.commandf1.FasterLib.api.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import space.commandf1.FasterLib.api.server.IServer;

import java.io.File;

@SuppressWarnings("unused")
public class IPlugin {
    private final Plugin plugin;

    private IPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 将一个Plugin实例转换为IPlugin实例
     *
     * */
    public static IPlugin toIPlugin(Plugin plugin) {
        return new IPlugin(plugin);
    }

    /**
     * 以此插件的名义注册事件
     * @author commandf1
     *
     * */
    public void registerListener(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, this.plugin);
    }

    /**
     * 执行该插件的onEnable方法
     * @author commandf1
     *
     * */
    public void runOnEnable() {
        this.plugin.onEnable();
    }

    /**
     * 执行该插件的onDisable方法
     * @author commandf1
     *
     * */
    public void runOnDisable() {
        this.plugin.onDisable();
    }

    /**
     * 执行该插件的onLoad方法
     * @author commandf1
     *
     * */
    public void runOnLoad() {
        this.plugin.onLoad();
    }

    /**
     * 获取该插件的IServer实例
     * @author commandf1
     *
     * */
    public IServer getIServer() {
        return IServer.toIServer(plugin.getServer());
    }

    /**
     * 获取plugins文件夹的File实例
     * @author commandf1
     *
     * */
    public File getPluginsFolder() {
        return this.plugin.getDataFolder().getParentFile();
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public Server getServer() {
        return this.plugin.getServer();
    }
}
