package space.commandf1.FasterLib;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.command.CommandManager;
import space.commandf1.FasterLib.api.config.Config;
import space.commandf1.FasterLib.api.listener.ListenerManager;
import space.commandf1.FasterLib.api.util.utils.LoggerUtils;
import space.commandf1.FasterLib.commands.FasterLibCommand;
import space.commandf1.FasterLib.commands.GetHelpsCommand;
import space.commandf1.FasterLib.commands.GetLicenseCommand;
import space.commandf1.FasterLib.listeners.GUIListener;
import space.commandf1.FasterLib.utils.*;

import java.io.*;
import java.nio.file.Files;

/**
 * For visitors:
 * My development level is not very good with bad English.
 * I think that there will many problems with the plugin.
 * If you have enough time if ok please send "Pull requests" that improve the plugin.
 *
 * THANKS TO EVERY CONTRIBUTOR FOR OPEN-SOURCE
 *
 * You are the most selfless people
 *
 * Commandf1 2022.9.24 in China
 * */
@SuppressWarnings("unused")
public class FasterLib extends JavaPlugin {
    private static FasterLib instance;
    private static Metrics bStats;
    private static Config settings;
    private final java.util.logging.Logger logger = this.getLogger();
    @Override
    public void onEnable() {
        instance = this;
        saveResource("settings.yml", false);
        settings = new Config("settings.yml", this);
        bStats = settings.getConfig().getBoolean("stats.bStats") ? new Metrics(this, 16491) : null;
        ((Logger) LogManager.getRootLogger()).addFilter(new Filter() {
            public Filter.Result filter(LogEvent event) {
                if (LoggerUtils.getStrings().contains(event.getMessage().toString())) {
                    return Filter.Result.DENY;
                }
                return null;
            }

            @Override
            public Result getOnMismatch() {
                return null;
            }

            @Override
            public Result getOnMatch() {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, String s, Object... objects) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, Object o, Throwable throwable) {
                return null;
            }

            @Override
            public Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
                return null;
            }
        });
        ListenerManager.registerListeners(this, new GUIListener());
        CommandManager.registerCommandsWithoutRegisterOnPluginYmlFile(this, new FasterLibCommand(), new GetLicenseCommand(), new GetHelpsCommand());
        logger.info("Plugin loaded successful.");
        logger.info(bStats == null || !bStats.isEnabled() ? "Metrics has been disabled" : "Metrics has been enabled");
        logger.info("Made By commandf1 v" + getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FasterLib getInstance() {
        return instance;
    }

    public static Metrics getBStats() {
        return bStats;
    }

    public static void setBStats(Metrics metrics) {
        bStats = metrics;
    }

    public static Config getSettings() {
        return settings;
    }

    @Override
    public void saveResource(String resourcePath, boolean replace) {
        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = this.getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("插件配置文件损坏，请重新下载插件!" + '\n' + "The plugin file may have been broken, please re-download the plugin.");
        }
        File outFile = new File(this.getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf(47);
        File outDir = new File(this.getDataFolder(), resourcePath.substring(0, Math.max(lastIndex, 0)));
        if (!outDir.exists() && !outDir.mkdirs()) {
            throw new IllegalArgumentException("无法创建目录" + "\n" + "Can not create the dir.");
        }
        try {
            if (!(outFile.exists() && !replace)) {
                OutputStream out = Files.newOutputStream(outFile.toPath());
                byte[] buf = new byte[1024];

                int len;
                while((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                out.close();
                in.close();
            }
        } catch (IOException e) {
            this.logger.log(java.util.logging.Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, e);
        }
    }
}
