package space.commandf1.FasterLib.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static space.commandf1.FasterLib.FasterLib.*;
import space.commandf1.FasterLib.api.command.Command;
import space.commandf1.FasterLib.api.inventory.action.Action;
import space.commandf1.FasterLib.api.inventory.action.GUIAction;
import space.commandf1.FasterLib.api.text.Text;
import space.commandf1.FasterLib.listeners.GUIListener;
import space.commandf1.FasterLib.utils.Metrics;

import static space.commandf1.FasterLib.FasterLib.*;

import java.util.HashSet;
import java.util.Set;

public class FasterLibCommand extends Command {

    public FasterLibCommand() {
        super("FasterLib", "The main command of the FasterLib plugin.", false, null, null, false, null);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (args.length > 0) {
            if ("reload".equalsIgnoreCase(args[0])) {
                getSettings().reloadConfig();
                commandSender.sendMessage("§aConfigs have been reloaded!");
            }
            return true;
        }
        if (commandSender instanceof Player) {
            ((Player) commandSender).sendTitle("§bFasterLib", "§fA easy lib for developers");
        }
        Set<Action> actions = new HashSet<>();
        for (GUIAction guiAction : GUIListener.actions.keySet()) {
            actions.add(guiAction.getAction());
        }
        commandSender.sendMessage(new String[] {
                "§fFasterLib " + "§fBy §b" + "commandf1",
                "§eVersion §f-> §c" + getInstance().getDescription().getVersion(),
                "§eWebsite §f-> §c" + getInstance().getDescription().getWebsite(),
                "§ebStats §f-> §" + (getBStats() == null ? "c" + "false" : "a" + getBStats().isEnabled()),
                "",
                "§fGUIActions §f-> §b" + GUIListener.actions.keySet().size(),
                "§fActions §f-> §b" + actions.size(),
                "§fInventories §f-> §b" + new HashSet<>(GUIListener.actions.values()).size(),
                "",
                "§aGUIAction Info"
        });
        if (GUIListener.actions.keySet().size() <= 0) {
            commandSender.sendMessage("§fNo GUIAction Found");
        }
        for (GUIAction guiAction : GUIListener.actions.keySet()) {
            commandSender.sendMessage("§f" + GUIListener.actions.get(guiAction).getTitle() + " §f-> " + "§b" + guiAction.getAction().toString());
        }
        if (commandSender instanceof Player) {
            commandSender.sendMessage("");
            ((Player) commandSender).spigot().sendMessage(new Text("§a[Open-Source License]").
                    setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to get the license").setClickEvent(ClickEvent.Action.RUN_COMMAND, "/getLicense").getTextComponent());
            ((Player) commandSender).spigot().sendMessage(new Text("§a[Github Link]").setClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/PreferMC/FasterLib")
                    .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to open link").getTextComponent());
            ((Player) commandSender).spigot().sendMessage(new Text("§a[Command Help]").
                    setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to get the helps").setClickEvent(ClickEvent.Action.RUN_COMMAND, "/getHelps").getTextComponent());
        }
        return true;
    }
}
