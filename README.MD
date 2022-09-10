# **FasterLib**
#### A good lib for minecraft bukkit developers

> English | [中文](README_zh.md)

FasterLib is a lib for developers.
It is very easy to use.

# *Usage*

**Color.java Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Color.toMinecraftColor("&aWow");
        // Change & to §
        Color.toMinecraftColor('&', "&aWow");
        //Change & to § by yourself
    }
}
~~~

**Command.java Usage**
~~~java
import space.commandf1.FasterLib.api.command.Command;

public class Cmd extends Command {

    public Cmd() {
        super("test", "This is a description", false, null, null, true, "You are not a player.");
    }


    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        Player player = (Player) commandSender;
        player.sendMessage("Test");
        return true;
    }
}
~~~
**Register commands on onEnable() method**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.command.CommandManager;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandManager.registerCommand(new Cmd());
        // Normal register, you must register command in plugin.yml.
        CommandManager.registerCommandWithoutRegisterOnPluginYmlFile(new Cmd(), this);
        // Register but you need not write things in plugin.yml
    }
}
~~~
**Config.java Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.config.Config;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config("config.yml", this);
        config.getConfig().getString("test");
        // Get string
        config.saveWithoutException();
        // save config
        config.set("test1", "test");
        // set config
        config.reloadConfig();
        //reload config
    }
}
~~~

**GUI.java Usage**

~~~java
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import space.commandf1.FasterLib.api.command.Command;
import space.commandf1.FasterLib.api.inventory.GUI;
import space.commandf1.FasterLib.api.inventory.action.Action;
import space.commandf1.FasterLib.api.inventory.action.GUIAction;
import space.commandf1.FasterLib.api.item.IItemStack;

public class GUICommand extends Command {
    private static GUI gui = new GUI(3 * 9, "This is a title");
    public Cmd() {
        super("gui", "This is a description", false, null, null, true, "You are not a player.");
    }


    @Override
    public boolean onExecute(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {
        Player player = (Player) commandSender;
        player.openInventory(gui.getInventory()); // open inventory
        return true;
    }
    
    static {
        IItemStack glass = new IItemStack(Material.GLASS, 1, (short) 5).setItemName("This is a item").setItemLore("§bThis is a lore here!\n§cLore 2!!!");
        gui.fullItem(glass.getItemStack());
        gui.addListener(new GUIAction(event -> {
            event.getWhoClicked().sendMessage("Clicked!"); // send message
            event.getWhoClicked().closeInventory(); // close inventory
            event.setCancelled(true); // must have else player can put things out
        }, glass.getItemStack()));
    }
}
~~~

**IItemStack.java Usage**

~~~java
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.item.IItemStack;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        Player player = Bukkit.getPlayer("player");
        IItemStack itemStack = new IItemStack(Material.GLASS, 1, (short) 5).setItemName("This is a item").setItemName("§aThis is a lore");
        // This is a itemStack instance
        player.getInventory().addItem(itemStack.getItemStack());
        // Add this item
    }
}
~~~

**ListenerManager.java Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.listener.ListenerManager;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ListenerManager.registerListeners(this, new ExampleListener());
    }
}
~~~

**Mysql.java Usage**
**Deleted on 1.5**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.mysql.Mysql;

import java.sql.SQLException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Mysql mysql = new Mysql("127.0.0.1", "root", "password");
            // add a mysql database
            mysql.delete("table", "where");
            // mysql delete
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
~~~

**IPlayer.java Usage**

~~~java
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.player.IPlayer;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Player player = Bukkit.getPlayer("player");
        IPlayer iPlayer = IPlayer.toIPlayer(player);
        iPlayer.errorKick();
        // kick the player by error
    }
}
~~~

**IPlugin.java Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.plugin.IPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        IPlugin plugin = IPlugin.toIPlugin(this);
        plugin.runOnEnable();
        // Run onEnable method
        // WARNING: This code will not work, do not use this one!
        // WARNING: This code just for test.
    }
}
~~~

**IServer.java Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.server.IServer;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        IServer server = IServer.toIServer(this.getServer());
        server.kickAllPlayers("kick test");
        // kick all players
    }
}
~~~

**Utils Usage**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.util.utils.StringUtils;
import space.commandf1.FasterLib.api.util.utils.SystemUtils;
import space.commandf1.FasterLib.api.util.utils.WebUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger logger = getLogger();
        logger.info(String.valueOf(SystemUtils.isLinux()));
        // check the system if the system is linux
        logger.info(StringUtils.getAfterString("aaabbbccc", "bbb"));
        // maybe return ccc
        logger.info(WebUtils.getHtml("github.com"));
        // get website source-code
        try {
            WebUtils.downloadFile("https://download.com/download.txt", "download.txt");
            // download file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
~~~

**Text.java Usage**

~~~java
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.text.Text;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Player player = Bukkit.getPlayer("player");
        player.spigot().sendMessage(new Text("Text")
                .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "text")
                .setClickEvent(ClickEvent.Action.RUN_COMMAND, "i clicked the text"));
    }
}
~~~

###### Powered By PreferMC