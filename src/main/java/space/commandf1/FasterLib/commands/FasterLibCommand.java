package space.commandf1.FasterLib.commands;

import org.bukkit.command.CommandSender;
import space.commandf1.FasterLib.FasterLib;
import space.commandf1.FasterLib.api.command.Command;

public class FasterLibCommand extends Command {

    public FasterLibCommand() {
        super("FasterLib", "The main command of the FasterLib plugin.", false, null, null, false, null);
    }

    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        commandSender.sendMessage(new String[] {
                "§fFasterLib " + "§fBy §b" + "commandf1",
                "§aVersion §f-> §c" + FasterLib.getInstance().getDescription().getVersion()
        });
        return true;
    }
}
