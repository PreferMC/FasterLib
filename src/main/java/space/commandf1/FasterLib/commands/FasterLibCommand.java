package space.commandf1.FasterLib.commands;

import org.bukkit.command.CommandSender;
import space.commandf1.FasterLib.FasterLib;
import space.commandf1.FasterLib.api.command.Command;
import space.commandf1.FasterLib.api.inventory.action.GUIAction;
import space.commandf1.FasterLib.listeners.GUIListener;

public class FasterLibCommand extends Command {

    public FasterLibCommand() {
        super("FasterLib", "The main command of the FasterLib plugin.", false, null, null, false, null);
    }

    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        commandSender.sendMessage(new String[] {
                "§fFasterLib " + "§fBy §b" + "commandf1",
                "§aVersion §f-> §c" + FasterLib.getInstance().getDescription().getVersion(),
                "",
                "§fGUIActions §f-> §b" + GUIListener.actions.keySet().size(),
                "§fActions §f-> §b" + GUIListener.actions.size(),
                "§fInventories §f-> §b" + GUIListener.actions.values().size(),
                "",
                "§aGUIAction Info"
        });
        for (GUIAction guiAction : GUIListener.actions.keySet()) {
            commandSender.sendMessage("§f" + GUIListener.actions.get(guiAction).getTitle() + " §f-> " + "§b" + guiAction.getAction().toString());
        }
        return true;
    }
}
