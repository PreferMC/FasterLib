package space.commandf1.FasterLib.api.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings("unused")
public abstract class Command implements CommandExecutor, TabCompleter {
    private final String command, description, permission, noPermissionMessage, noPlayerMessage;
    private final boolean playerOnly, isPermissionEquals;

    /**
     * 注册一个命令
     * @author commandf1
     * @param command cmd
     * @param description des
     * @param permission perms
     * @param noPermissionMessage npm
     * @param playerOnly po
     * @param noPlayerMessage ipm
     *
     * */
    public Command(String command, String description, boolean isPermissionEquals, String permission, String noPermissionMessage, boolean playerOnly, String noPlayerMessage) {
        this.command = command;
        this.description = description;
        this.permission = permission;
        this.noPermissionMessage = noPermissionMessage;
        this.noPlayerMessage = noPlayerMessage;
        this.playerOnly = playerOnly;
        this.isPermissionEquals = isPermissionEquals;
    }

    /**
     * 获取命令
     * @author commandf1
     * @return command
     * */
    public final String getCommand() {
        return this.command;
    }

    /**
     * 获取解释
     * @author commandf1
     * @return description
     * */
    public final String getDescription() {
        return this.description;
    }

    /**
     * 获取权限
     * @author commandf1
     * @return permission
     * */
    public final String getPermission() {
        return this.permission;
    }

    /**
     * 获取没有权限时的消息
     * @author commandf1
     * @return noPermissionMessage
     * */
    public final String getNoPermissionMessage() {
        return this.noPermissionMessage;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        if (isPermissionEquals && !commandSender.hasPermission(this.permission)) {
            if (!(noPermissionMessage == null)) {
                commandSender.sendMessage(this.noPermissionMessage);
            }
            return true;
        }
        if (this.playerOnly && !(commandSender instanceof Player)) {
            commandSender.sendMessage(noPlayerMessage);
            return true;
        }
        return onExecute(commandSender, command, label, args);
    }

    /**
     * 命令运行时执行的方法
     * @author commandf1
     * @param commandSender cs
     * @param cmd cmd
     * @param label l
     * @param args args
     * */
    public abstract boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args);


    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return null;
    }
}
