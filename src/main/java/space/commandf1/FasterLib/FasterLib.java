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
import space.commandf1.FasterLib.api.listener.ListenerManager;
import space.commandf1.FasterLib.api.util.utils.LoggerUtils;
import space.commandf1.FasterLib.commands.FasterLibCommand;
import space.commandf1.FasterLib.commands.GetLicenseCommand;
import space.commandf1.FasterLib.listeners.GUIListener;

@SuppressWarnings("unused")
public class FasterLib extends JavaPlugin {
    private static FasterLib instance;
    private final java.util.logging.Logger logger = this.getLogger();
    @Override
    public void onEnable() {
        instance = this;
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
        CommandManager.registerCommandsWithoutRegisterOnPluginYmlFile(this, new FasterLibCommand(), new GetLicenseCommand());
        logger.info("Plugin loaded successful.");
        logger.info("Made By commandf1 v" + getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FasterLib getInstance() {
        return instance;
    }
}
