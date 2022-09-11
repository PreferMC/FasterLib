package space.commandf1.FasterLib.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import space.commandf1.FasterLib.FasterLib;
import space.commandf1.FasterLib.api.command.Command;
import space.commandf1.FasterLib.api.inventory.action.Action;
import space.commandf1.FasterLib.api.inventory.action.GUIAction;
import space.commandf1.FasterLib.api.text.Text;
import space.commandf1.FasterLib.listeners.GUIListener;

import java.util.HashSet;
import java.util.Set;

public class FasterLibCommand extends Command {

    public FasterLibCommand() {
        super("FasterLib", "The main command of the FasterLib plugin.", false, null, null, false, null);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (commandSender instanceof Player) {
            ((Player) commandSender).sendTitle("§bFasterLib", "§fA easy lib for developers");
        }
        Set<Action> actions = new HashSet<>();
        for (GUIAction guiAction : GUIListener.actions.keySet()) {
            actions.add(guiAction.getAction());
        }
        commandSender.sendMessage(new String[] {
                "§fFasterLib " + "§fBy §b" + "commandf1",
                "§aVersion §f-> §c" + FasterLib.getInstance().getDescription().getVersion(),
                "§aWebsite §f-> §c" + FasterLib.getInstance().getDescription().getWebsite(),
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
            commandSender.sendMessage(new String[] {
                    "",
            });
            ((Player) commandSender).spigot().sendMessage(new Text("§a[Open-Source License]").
                    setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to get the license").setClickEvent(ClickEvent.Action.RUN_COMMAND, "/getLicense").getTextComponent());
        }
        return true;
    }
}
