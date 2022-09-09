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
        commandSender.sendMessage("§fFasterLib v§a" + FasterLib.getInstance().getDescription().getVersion() + " §fBy §a" + "commandf1");
        return true;
    }
}
