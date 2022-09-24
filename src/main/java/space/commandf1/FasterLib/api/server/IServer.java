package space.commandf1.FasterLib.api.server;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.*;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class IServer {
    private final Server server;

    private IServer(Server server) {
        this.server = server;
    }

    /**
     *
     * 踢出所有玩家
     * 需要提供原因
     *
     * @author commandf1
     * */
    public void kickAllPlayers(String reason) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kickPlayer(reason);
        }
    }

    /**
     * 踢出所有玩家
     * 可以指定不踢出的玩家
     * @author commandf1
     *
     * */
    public void kickAllPlayers(String reason, Player ig) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(ig)) {
                player.kickPlayer(reason);
            }
        }
    }

    /**
     * 暂停服务器线程
     * 指定假卡顿 不要使用多线程调用
     *
     * @author commandf1
     *
     * */
    public void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    /**
     * 取消服务器所有OP
     *
     * @author commandf1
     *
     * */
    public void unsetAllOperators() {
        for (OfflinePlayer operator : this.server.getOperators()) {
            operator.setOp(false);
        }
    }

    /**
     * 发消息给后台
     *
     * @author commandf1
     *
     * */
    public void sendMessage(String message) {
        this.server.getConsoleSender().sendMessage(message);
    }

    /**
     * 转换到IServer实例
     *
     * */
    public static IServer toIServer(Server server) {
        return new IServer(server);
    }

    /**
     * 获取Server实例
     *
     * */
    public Server getServer() {
        return this.server;
    }

    public String getName() {
        return this.server.getName();
    }

    public String getVersion() {
        return this.server.getVersion();
    }

    public String getBukkitVersion() {
        return this.server.getBukkitVersion();
    }

    public Collection<? extends Player> getOnlinePlayers() {
        return this.server.getOnlinePlayers();
    }

    public int getMaxPlayers() {
        return this.server.getMaxPlayers();
    }

    public int getPort() {
        return this.server.getPort();
    }

    public int getViewDistance() {
        return this.server.getViewDistance();
    }

    public String getIp() {
        return this.server.getIp();
    }

    public String getServerName() {
        return this.server.getServerName();
    }

    public String getServerId() {
        return this.server.getServerId();
    }

    public String getWorldType() {
        return this.server.getWorldType();
    }

    public boolean getGenerateStructures() {
        return this.server.getGenerateStructures();
    }

    public boolean getAllowEnd() {
        return this.server.getAllowEnd();
    }

    public boolean getAllowNether() {
        return this.server.getAllowNether();
    }

    public boolean hasWhitelist() {
        return this.server.hasWhitelist();
    }

    public IServer setWhitelist(boolean b) {
        this.server.setWhitelist(b);
        return this;
    }

    public Set<OfflinePlayer> getWhitelistedPlayers() {
        return this.server.getWhitelistedPlayers();
    }

    public IServer reloadWhitelist() {
        this.server.reloadWhitelist();
        return this;
    }

    public int broadcastMessage(String s) {
        return this.server.broadcastMessage(s);
    }

    public String getUpdateFolder() {
        return this.server.getUpdateFolder();
    }

    public File getUpdateFolderFile() {
        return this.server.getUpdateFolderFile();
    }

    public long getConnectionThrottle() {
        return this.server.getConnectionThrottle();
    }

    public int getTicksPerAnimalSpawns() {
        return this.server.getTicksPerAnimalSpawns();
    }

    public int getTicksPerMonsterSpawns() {
        return this.server.getTicksPerMonsterSpawns();
    }

    public Player getPlayer(String s) {
        return this.server.getPlayer(s);
    }

    public Player getPlayerExact(String s) {
        return this.server.getPlayerExact(s);
    }

    public List<Player> matchPlayer(String s) {
        return this.server.matchPlayer(s);
    }

    public Player getPlayer(UUID uuid) {
        return this.server.getPlayer(uuid);
    }

    public PluginManager getPluginManager() {
        return this.server.getPluginManager();
    }

    public BukkitScheduler getScheduler() {
        return this.server.getScheduler();
    }

    public ServicesManager getServicesManager() {
        return this.server.getServicesManager();
    }

    public List<World> getWorlds() {
        return this.server.getWorlds();
    }

    public World createWorld(WorldCreator worldCreator) {
        return this.server.createWorld(worldCreator);
    }

    public boolean unloadWorld(String s, boolean b) {
        return this.server.unloadWorld(s, b);
    }

    public boolean unloadWorld(World world, boolean b) {
        return this.server.unloadWorld(world, b);
    }

    public World getWorld(String s) {
        return this.server.getWorld(s);
    }

    public World getWorld(UUID uuid) {
        return this.server.getWorld(uuid);
    }

    /**
     * @deprecated
     */
    public MapView getMap(short i) {
        return this.server.getMap(i);
    }

    public MapView createMap(World world) {
        return this.server.createMap(world);
    }

    public IServer reload() {
        this.server.reload();
        return this;
    }

    public Logger getLogger() {
        return this.server.getLogger();
    }

    public PluginCommand getPluginCommand(String s) {
        return this.server.getPluginCommand(s);
    }

    public IServer savePlayers() {
        this.server.savePlayers();
        return this;
    }

    public boolean dispatchCommand(CommandSender commandSender, String s) throws CommandException {
        return this.server.dispatchCommand(commandSender, s);
    }

    public IServer configureDbConfig(ServerConfig serverConfig) {
        this.server.configureDbConfig(serverConfig);
        return this;
    }

    public boolean addRecipe(Recipe recipe) {
        return this.server.addRecipe(recipe);
    }

    public List<Recipe> getRecipesFor(ItemStack itemStack) {
        return this.server.getRecipesFor(itemStack);
    }

    public Iterator<Recipe> recipeIterator() {
        return this.server.recipeIterator();
    }

    public IServer clearRecipes() {
        this.server.clearRecipes();
        return this;
    }

    public IServer resetRecipes() {
        this.server.resetRecipes();
        return this;
    }

    public Map<String, String[]> getCommandAliases() {
        return this.server.getCommandAliases();
    }

    public int getSpawnRadius() {
        return this.server.getSpawnRadius();
    }

    public IServer setSpawnRadius(int i) {
        this.server.setSpawnRadius(i);
        return this;
    }

    public boolean getOnlineMode() {
        return this.server.getOnlineMode();
    }

    public boolean getAllowFlight() {
        return this.server.getAllowFlight();
    }

    public boolean isHardcore() {
        return this.server.isHardcore();
    }

    /**
     * @deprecated
     */
    public boolean useExactLoginLocation() {
        return this.server.useExactLoginLocation();
    }

    public IServer shutdown() {
        this.server.shutdown();
        return this;
    }

    public int broadcast(String s, String s1) {
        return this.server.broadcast(s, s1);
    }

    /**
     * @deprecated
     */
    public OfflinePlayer getOfflinePlayer(String s) {
        return this.server.getOfflinePlayer(s);
    }

    public OfflinePlayer getOfflinePlayer(UUID uuid) {
        return this.server.getOfflinePlayer(uuid);
    }

    public Set<String> getIPBans() {
        return this.server.getIPBans();
    }

    public IServer banIP(String s) {
        this.server.banIP(s);
        return this;
    }

    public IServer unbanIP(String s) {
        this.server.unbanIP(s);
        return this;
    }

    public Set<OfflinePlayer> getBannedPlayers() {
        return this.server.getBannedPlayers();
    }

    public BanList getBanList(BanList.Type type) {
        return this.server.getBanList(type);
    }

    public Set<OfflinePlayer> getOperators() {
        return this.server.getOperators();
    }

    public GameMode getDefaultGameMode() {
        return this.server.getDefaultGameMode();
    }

    public IServer setDefaultGameMode(GameMode gameMode) {
        this.server.setDefaultGameMode(gameMode);
        return this;
    }

    public ConsoleCommandSender getConsoleSender() {
        return this.server.getConsoleSender();
    }

    public File getWorldContainer() {
        return this.server.getWorldContainer();
    }

    public OfflinePlayer[] getOfflinePlayers() {
        return this.server.getOfflinePlayers();
    }

    public Messenger getMessenger() {
        return this.server.getMessenger();
    }

    public HelpMap getHelpMap() {
        return this.server.getHelpMap();
    }

    public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType) {
        return this.server.createInventory(inventoryHolder, inventoryType);
    }

    public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType, String s) {
        return this.server.createInventory(inventoryHolder, inventoryType, s);
    }

    public Inventory createInventory(InventoryHolder inventoryHolder, int i) throws IllegalArgumentException {
        return this.server.createInventory(inventoryHolder, i);
    }

    public Inventory createInventory(InventoryHolder inventoryHolder, int i, String s) throws IllegalArgumentException {
        return this.server.createInventory(inventoryHolder, i, s);
    }

    public int getMonsterSpawnLimit() {
        return this.server.getMonsterSpawnLimit();
    }

    public int getAnimalSpawnLimit() {
        return this.server.getAnimalSpawnLimit();
    }

    public int getWaterAnimalSpawnLimit() {
        return this.server.getWaterAnimalSpawnLimit();
    }

    public int getAmbientSpawnLimit() {
        return this.server.getAmbientSpawnLimit();
    }

    public boolean isPrimaryThread() {
        return this.server.isPrimaryThread();
    }

    public String getMotd() {
        return this.server.getMotd();
    }

    public String getShutdownMessage() {
        return this.server.getShutdownMessage();
    }

    public Warning.WarningState getWarningState() {
        return this.server.getWarningState();
    }

    public ItemFactory getItemFactory() {
        return this.server.getItemFactory();
    }

    public ScoreboardManager getScoreboardManager() {
        return this.server.getScoreboardManager();
    }

    public CachedServerIcon getServerIcon() {
        return this.server.getServerIcon();
    }

    public CachedServerIcon loadServerIcon(File file) throws Exception {
        return this.server.loadServerIcon(file);
    }

    public CachedServerIcon loadServerIcon(BufferedImage bufferedImage) throws Exception {
        return this.server.loadServerIcon(bufferedImage);
    }

    public IServer setIdleTimeout(int i) {
        this.server.setIdleTimeout(i);
        return this;
    }

    public int getIdleTimeout() {
        return this.server.getIdleTimeout();
    }

    public ChunkGenerator.ChunkData createChunkData(World world) {
        return this.server.createChunkData(world);
    }

    /**
     * @deprecated
     */
    public UnsafeValues getUnsafe() {
        return this.server.getUnsafe();
    }

    public Server.Spigot spigot() {
        return this.server.spigot();
    }

    public IServer sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
        this.server.sendPluginMessage(plugin, s, bytes);
        return this;
    }

    public Set<String> getListeningPluginChannels() {
        return this.server.getListeningPluginChannels();
    }
}
