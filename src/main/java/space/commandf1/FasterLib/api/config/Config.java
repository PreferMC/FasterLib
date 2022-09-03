package space.commandf1.FasterLib.api.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import space.commandf1.FasterLib.api.plugin.IPlugin;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class Config {
    private final IPlugin plugin;
    private final File config;
    private YamlConfiguration yaml;

    /**
     * 指定一个config文件
     *
     * */
    public Config(File config) {
        this.config = config;
        this.plugin = null;
        this.yaml = YamlConfiguration.loadConfiguration(this.config);
    }

    /**
     * 仅仅填写配置文件名字
     * 不需要填写完整目录
     *
     * */
    public Config(String config, Plugin plugin) {
        this.config = new File(plugin.getDataFolder(), config);
        this.plugin = IPlugin.toIPlugin(plugin);
    }

    /**
     * 仅仅填写配置文件名字
     * 不需要填写完整目录
     *
     * */
    public Config(String config, IPlugin plugin) {
        this.config = new File(plugin.getPlugin().getDataFolder(), config);
        this.plugin = plugin;
    }

    /**
     * 保存config文件(不忽略可能存在的错误)
     *
     * */
    public void save() throws IOException {
        this.yaml.save(this.config);
    }

    /**
     * 保存config文件(忽略可能存在的错误)
     *
     * */
    public void saveWithoutException() {
        try {
            this.yaml.save(this.config);
        } catch (IOException ignored) {}
    }

    /**
     * 获取config文件YamlConfiguration实例
     *
     * */
    public YamlConfiguration getConfig() {
        return this.yaml;
    }

    /**
     * 重新载入config文件
     *
     * */
    public void reloadConfig() {
        this.yaml = YamlConfiguration.loadConfiguration(this.config);
    }

    /**
     * 设置指定项，即刻生效(忽略可能存在的错误)
     *
     * */
    public void setWithoutException(String path, Object value) {
        this.yaml.set(path, value);
        this.saveWithoutException();
    }

    /**
     * 设置指定项，即刻生效(不忽略可能存在的错误)
     *
     * */
    public void set(String path, Object value) throws IOException {
        this.yaml.set(path, value);
        this.save();
    }
}
