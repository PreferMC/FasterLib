package space.commandf1.FasterLib.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import space.commandf1.FasterLib.api.command.Command;
import space.commandf1.FasterLib.api.text.Text;

public class GetHelpsCommand extends Command {
    private final TextComponent pass = new Text(" ").getTextComponent();

    public GetHelpsCommand() {
        super("getHelps", "Get the helps of the main command", false, null, null, false, null);
    }

    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.spigot().sendMessage(new Text("§b/FasterLib Reload §f- §eReload configs ").getTextComponent(),
                    new Text("§a[Suggest]")
                    .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to fill command to your text table")
                    .setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/FasterLib Reload").getTextComponent(),
                    pass,
                    new Text("§c[Run]")
                            .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "Click here to fill command to your text table")
                            .setClickEvent(ClickEvent.Action.RUN_COMMAND, "/FasterLib Reload").getTextComponent());
            return true;
        }
        commandSender.sendMessage(new String[] {
                "§b/FasterLib Reload §f- §eReload configs"
        });
        return true;
    }
}
