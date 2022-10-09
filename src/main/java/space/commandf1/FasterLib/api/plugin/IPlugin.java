package space.commandf1.FasterLib.api.plugin;

import com.avaje.ebean.EbeanServer;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import space.commandf1.FasterLib.api.server.IServer;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class IPlugin implements Serializable {
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

    public File getDataFolder() {
        return this.plugin.getDataFolder();
    }

    public PluginDescriptionFile getDescription() {
        return this.plugin.getDescription();
    }

    public FileConfiguration getConfig() {
        return this.plugin.getConfig();
    }

    public InputStream getResource(String s) {
        return this.plugin.getResource(s);
    }

    public PluginLoader getPluginLoader() {
        return this.plugin.getPluginLoader();
    }

    public Server getServer() {
        return this.plugin.getServer();
    }

    public boolean isEnabled() {
        return this.plugin.isEnabled();
    }

    public boolean isNaggable() {
        return this.plugin.isNaggable();
    }

    public IPlugin setNaggable(boolean b) {
        this.plugin.setNaggable(b);
        return this;
    }

    public EbeanServer getDatabase() {
        return this.plugin.getDatabase();
    }

    public ChunkGenerator getDefaultWorldGenerator(String s, String s1) {
        return this.plugin.getDefaultWorldGenerator(s, s1);
    }

    public Logger getLogger() {
        return this.plugin.getLogger();
    }

    public String getName() {
        return this.plugin.getName();
    }

}
