package space.commandf1.FasterLib;

import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.listener.ListenerManager;
import space.commandf1.FasterLib.listeners.GUIListener;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class FasterLib extends JavaPlugin {
    private static FasterLib instance;
    private final Logger logger = this.getLogger();
    @Override
    public void onEnable() {
        instance = this;
        ListenerManager.registerListeners(this, new GUIListener());
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
