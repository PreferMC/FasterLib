# **FasterLib**
#### FasterLib是一个简单的前置

> [English](README.MD) | 中文

FasterLib是一个面向开发人员的库
它非常容易使用

# *使用方法*

**Color.java 使用**

~~~java
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Color.toMinecraftColor("&aWow");
        // 将&变为§
        Color.toMinecraftColor('&', "&aWow");
        // 将&变为§ 可以由开发人员自定义
    }
}
~~~

**Command.java 使用**
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
        // 正常注册，您必须在plugin.yml中注册命令
        CommandManager.registerCommandWithoutRegisterOnPluginYmlFile(new Cmd(), this);
        // 注册，但不需要在plugin.yml中写东西
    }
}
~~~
**Config.java 使用**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.config.Config;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config("config.yml", this);
        config.getConfig().getString("test");
        // 获取字符串
        config.saveWithoutException();
        // 保存配置
        config.set("test1", "test");
        // 设置test1项目为test
        config.reloadConfig();
        // 重载配置文件
    }
}
~~~

**GUI.java 使用**

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
        player.openInventory(gui.getInventory()); // 打开GUI
        return true;
    }
    
    static {
        IItemStack glass = new IItemStack(Material.GLASS, 1, (short) 5).setItemName("This is a item").setItemLore("§bThis is a lore here!\n§cLore 2!!!");
        gui.fullItem(glass.getItemStack());
        gui.addListener(new GUIAction(event -> {
            event.getWhoClicked().sendMessage("Clicked!"); // 发送消息
            event.getWhoClicked().closeInventory(); // 关闭GUI
            event.setCancelled(true); // 必须有 否则玩家可以把物品拿出来
        }, glass.getItemStack()));
    }
}
~~~

**IItemStack.java 使用**

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
        // 这是一个itemStack实例
        player.getInventory().addItem(itemStack.getItemStack());
        // 添加物品
    }
}
~~~

**ListenerManager.java 使用**

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

**Mysql.java 使用**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.mysql.Mysql;

import java.sql.SQLException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Mysql mysql = new Mysql("127.0.0.1", "root", "password");
            // 添加mysql数据库
            mysql.delete("table", "where");
            // 删除
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
~~~

**IPlayer.java 使用**

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
        // 以内部错误踢出玩家
    }
}
~~~

**IPlugin.java 使用**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.plugin.IPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        IPlugin plugin = IPlugin.toIPlugin(this);
        plugin.runOnEnable();
        // 运行onEnable方法
        // 警告: 此代码不会起作用，请不要使用此代码!
        // 警告: 这个代码只是用来测试
    }
}
~~~

**IServer.java 使用**

~~~java
import org.bukkit.plugin.java.JavaPlugin;
import space.commandf1.FasterLib.api.server.IServer;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        IServer server = IServer.toIServer(this.getServer());
        server.kickAllPlayers("kick test");
        // 踢出所有玩家
    }
}
~~~

**Utils 使用**

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
        // 检查系统是不是Linux
        logger.info(StringUtils.getAfterString("aaabbbccc", "bbb"));
        // 也许会返回 ccc
        logger.info(WebUtils.getHtml("github.com"));
        // 获取网页源码
        try {
            WebUtils.downloadFile("https://download.com/download.txt", "download.txt");
            // 下载文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
~~~

###### Powered By PreferMC