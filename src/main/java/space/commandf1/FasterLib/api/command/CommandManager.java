package space.commandf1.FasterLib.api.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public final class CommandManager {
    private CommandManager() {}

    /**
     * 注册命令
     * @author commandf1
     * */
    public static void registerCommand(Command command) {
        PluginCommand cmd = Bukkit.getPluginCommand(command.getCommand());
        cmd.setExecutor(command);
    }

    /**
     * 注册命令
     * @author commandf1
     * */
    public static void registerCommands(Command... commands) {
        for (Command command : commands) {
            registerCommand(command);
        }
    }

    public static void registerCommandWithoutRegisterOnPluginYmlFile(Command command, String prefix) {
        try {
            SimplePluginManager pm = ((SimplePluginManager) Bukkit.getPluginManager());
            Class<?> clazz = pm.getClass();

            Field commandMapField = clazz.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);

            CommandMap commandMap = (CommandMap) commandMapField.get(pm);
            commandMap.register(command.getCommand(), prefix, new org.bukkit.command.Command(command.getCommand()) {
                @Override
                public boolean execute(CommandSender commandSender, String s, String[] strings) {
                    return command.onCommand(commandSender, this, s, strings);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerCommandWithoutRegisterOnPluginYmlFile(Command command, Plugin plugin) {
        try {
            SimplePluginManager pm = ((SimplePluginManager) Bukkit.getPluginManager());
            Class<?> clazz = pm.getClass();

            Field commandMapField = clazz.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);

            CommandMap commandMap = (CommandMap) commandMapField.get(pm);
            commandMap.register(command.getCommand(), plugin.getDescription().getName(), new org.bukkit.command.Command(command.getCommand()) {
                @Override
                public boolean execute(CommandSender commandSender, String s, String[] strings) {
                    return command.onCommand(commandSender, this, s, strings);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerCommandsWithoutRegisterOnPluginYmlFile(Plugin plugin, Command... commands) {
        for (Command command : commands) {
            registerCommandWithoutRegisterOnPluginYmlFile(command, plugin);
        }
    }
}
