package space.commandf1.FasterLib.api.player;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.*;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

@SuppressWarnings("unused")
public class IPlayer implements Serializable {
    private final Player player;
    
    private IPlayer(Player player) {
        this.player = player;
    }

    public static IPlayer toIPlayer(Player player) {
        return new IPlayer(player);
    }

    /**
     * 使用十六进制颜色发送消息
     * @author commandf1
     *
     * 注意: 仅限高版本使用
     * */
    public void sendMessage(String message, Color color) {
        player.sendRawMessage("{\"text\":\"" + message + "\",\"color\":\"#" + color.asBGR() + "\"}");
    }

    /**
     * 使用十六进制颜色发送消息
     * @author commandf1
     *
     * 注意: 仅限高版本使用
     * */
    public void sendMessage(String message, int color) {
        player.sendRawMessage("{\"text\":\"" + message + "\",\"color\":\"#" + color + "\"}");
    }

    /**
     * 以内部错误踢出玩家
     * @author commandf1
     *
     * */
    public void errorKick() {
        String[] errors = {"Internal Exception: io.netty.handler.codec.DecoderException: java.lang.IllegalArgumentException: java.lang.ClassCastException" , "java.net.SocketTimeoutException: Time out" , "Internal Exception: java.io.IOException: Connection reset by peer" , "Timed out" , "Internal Exception: io.netty.handler.codec.DecoderException: java.lang.RuntimeException: An internal error occured." , "Internal Exception: java.io.IOException: Error while read(...): Connection reset by peer" , "Internal Exception: java.io.IOException: 远程主机强迫关闭了一个现有的连接" , "Internal Exception: java.io.IOException: 您的主机中的软件终止了一个已建立的连接" , "Internal Exception: io.netty.handler.timeout.ReadTimeoutException"};
        player.kickPlayer(errors[new Random().nextInt(errors.length - 1)]);
    }

    public boolean isOnline() {
        return false;
    }

    public boolean isBanned() {
        return false;
    }

    /**
     * @deprecated
     */
    public void setBanned(boolean b) {

    }

    public boolean isWhitelisted() {
        return false;
    }

    public void setWhitelisted(boolean b) {

    }

    /**
     * 获取Player实例
     *
     * */
    public Player getPlayer() {
        return player;
    }

    public long getFirstPlayed() {
        return this.player.getFirstPlayed();
    }

    public long getLastPlayed() {
        return this.player.getLastPlayed();
    }

    public boolean hasPlayedBefore() {
        return this.player.hasPlayedBefore();
    }

    public String getDisplayName() {
        return this.player.getDisplayName();
    }

    public IPlayer setDisplayName(String s) {
        this.player.setDisplayName(s);
        return this;
    }

    public String getPlayerListName() {
        return this.player.getPlayerListName();
    }

    public IPlayer setPlayerListName(String s) {
        this.player.setPlayerListName(s);
        return this;
    }

    public IPlayer setCompassTarget(Location location) {
        this.player.setCompassTarget(location);
        return this;
    }

    public Location getCompassTarget() {
        return this.player.getCompassTarget();
    }

    public InetSocketAddress getAddress() {
        return this.player.getAddress();
    }

    public boolean isConversing() {
        return this.player.isConversing();
    }

    public IPlayer acceptConversationInput(String s) {
        this.player.acceptConversationInput(s);
        return this;
    }

    public boolean beginConversation(Conversation conversation) {
        return this.player.beginConversation(conversation);
    }

    public IPlayer abandonConversation(Conversation conversation) {
        this.player.abandonConversation(conversation);
        return this;
    }

    public IPlayer abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
        this.player.abandonConversation(conversation, conversationAbandonedEvent);
        return this;
    }

    public IPlayer sendRawMessage(String s) {
        this.player.sendRawMessage(s);
        return this;
    }

    public IPlayer kickPlayer(String s) {
        this.player.kickPlayer(s);
        return this;
    }

    public IPlayer chat(String s) {
        this.player.chat(s);
        return this;
    }

    public boolean performCommand(String s) {
        return this.player.performCommand(s);
    }

    public boolean isSneaking() {
        return this.player.isSneaking();
    }

    public IPlayer setSneaking(boolean b) {
        this.player.setSneaking(b);
        return this;
    }

    public boolean isSprinting() {
        return this.player.isSprinting();
    }

    public IPlayer setSprinting(boolean b) {
        this.player.setSprinting(b);
        return this;
    }

    public IPlayer saveData() {
        this.player.saveData();
        return this;
    }

    public IPlayer loadData() {
        this.player.loadData();
        return this;
    }

    public IPlayer setSleepingIgnored(boolean b) {
        this.player.setSleepingIgnored(b);
        return this;
    }

    public boolean isSleepingIgnored() {
        return this.player.isSleepingIgnored();
    }

    /**
     * @deprecated
     */
    public IPlayer playNote(Location location, byte b, byte b1) {
        this.player.playNote(location, b, b1);
        return this;
    }

    public IPlayer playNote(Location location, Instrument instrument, Note note) {
        this.player.playNote(location, instrument, note);
        return this;
    }

    public IPlayer playSound(Location location, Sound sound, float v, float v1) {
        this.player.playSound(location, sound, v, v1);
        return this;
    }

    public IPlayer playSound(Location location, String s, float v, float v1) {
        this.player.playSound(location, s, v, v1);
        return this;
    }

    /**
     * @deprecated
     */
    public IPlayer playEffect(Location location, Effect effect, int i) {
        this.player.playEffect(location, effect, i);
        return this;
    }

    public <T> IPlayer playEffect(Location location, Effect effect, T t) {
        this.player.playEffect(location, effect, t);
        return this;
    }

    /**
     * @deprecated
     */
    public IPlayer sendBlockChange(Location location, Material material, byte b) {
        this.player.sendBlockChange(location, material, b);
        return this;
    }

    /**
     * @deprecated
     */
    public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
        return this.player.sendChunkChange(location, i, i1, i2, bytes);
    }

    /**
     * @deprecated
     */
    public IPlayer sendBlockChange(Location location, int i, byte b) {
        this.player.sendBlockChange(location, i, b);
        return this;
    }

    public IPlayer sendSignChange(Location location, String[] strings) throws IllegalArgumentException {
        this.player.sendSignChange(location, strings);
        return this;
    }

    public IPlayer sendMap(MapView mapView) {
        this.player.sendMap(mapView);
        return this;
    }

    public IPlayer updateInventory() {
        this.player.updateInventory();
        return this;
    }

    public IPlayer awardAchievement(Achievement achievement) {
        this.player.awardAchievement(achievement);
        return this;
    }

    public IPlayer removeAchievement(Achievement achievement) {
        this.player.removeAchievement(achievement);
        return this;
    }

    public boolean hasAchievement(Achievement achievement) {
        return this.player.hasAchievement(achievement);
    }

    public IPlayer incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic);
        return this;
    }

    public IPlayer incrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, i);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, i);
        return this;
    }

    public IPlayer setStatistic(Statistic statistic, int i) throws IllegalArgumentException {
        this.player.setStatistic(statistic, i);
        return this;
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return this.player.getStatistic(statistic);
    }

    public IPlayer incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, material);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, material);
        return this;
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return this.player.getStatistic(statistic, material);
    }

    public IPlayer incrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, material, i);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, material, i);
        return this;
    }

    public IPlayer setStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
        this.player.setStatistic(statistic, material, i);
        return this;
    }

    public IPlayer incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, entityType);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, entityType);
        return this;
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return this.player.getStatistic(statistic, entityType);
    }

    public IPlayer incrementStatistic(Statistic statistic, EntityType entityType, int i) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, entityType, i);
        return this;
    }

    public IPlayer decrementStatistic(Statistic statistic, EntityType entityType, int i) {
        this.player.decrementStatistic(statistic, entityType, i);
        return this;
    }

    public IPlayer setStatistic(Statistic statistic, EntityType entityType, int i) {
        this.player.setStatistic(statistic, entityType, i);
        return this;
    }

    public IPlayer setPlayerTime(long l, boolean b) {
        this.player.setPlayerTime(l, b);
        return this;
    }

    public long getPlayerTime() {
        return this.player.getPlayerTime();
    }

    public long getPlayerTimeOffset() {
        return this.player.getPlayerTimeOffset();
    }

    public boolean isPlayerTimeRelative() {
        return this.player.isPlayerTimeRelative();
    }

    public IPlayer resetPlayerTime() {
        this.player.resetPlayerTime();
        return this;
    }

    public IPlayer setPlayerWeather(WeatherType weatherType) {
        this.player.setPlayerWeather(weatherType);
        return this;
    }

    public WeatherType getPlayerWeather() {
        return this.player.getPlayerWeather();
    }

    public IPlayer resetPlayerWeather() {
        this.player.resetPlayerWeather();
        return this;
    }

    public IPlayer giveExp(int i) {
        this.player.giveExp(i);
        return this;
    }

    public IPlayer giveExpLevels(int i) {
        this.player.giveExpLevels(i);
        return this;
    }

    public float getExp() {
        return this.player.getExp();
    }

    public IPlayer setExp(float v) {
        this.player.setExp(v);
        return this;
    }

    public int getLevel() {
        return this.player.getLevel();
    }

    public IPlayer setLevel(int i) {
        this.player.setLevel(i);
        return this;
    }

    public int getTotalExperience() {
        return this.player.getTotalExperience();
    }

    public IPlayer setTotalExperience(int i) {
        this.player.setTotalExperience(i);
        return this;
    }

    public float getExhaustion() {
        return this.player.getExhaustion();
    }

    public IPlayer setExhaustion(float v) {
        this.player.setExhaustion(v);
        return this;
    }

    public float getSaturation() {
        return this.player.getSaturation();
    }

    public IPlayer setSaturation(float v) {
        this.player.setSaturation(v);
        return this;
    }

    public int getFoodLevel() {
        return this.player.getFoodLevel();
    }

    public IPlayer setFoodLevel(int i) {
        this.player.setFoodLevel(i);
        return this;
    }

    public Location getBedSpawnLocation() {
        return this.player.getBedSpawnLocation();
    }

    public IPlayer setBedSpawnLocation(Location location) {
        this.player.setBedSpawnLocation(location);
        return this;
    }

    public IPlayer setBedSpawnLocation(Location location, boolean b) {
        this.player.setBedSpawnLocation(location, b);
        return this;
    }

    public boolean getAllowFlight() {
        return this.player.getAllowFlight();
    }

    public IPlayer setAllowFlight(boolean b) {
        this.player.setAllowFlight(b);
        return this;
    }

    public IPlayer hidePlayer(Player player) {
        this.player.hidePlayer(player);
        return this;
    }

    public IPlayer showPlayer(Player player) {
        this.player.showPlayer(player);
        return this;
    }

    public boolean canSee(Player player) {
        return this.player.canSee(player);
    }

    public Location getLocation() {
        return this.player.getLocation();
    }

    public Location getLocation(Location location) {
        return this.player.getLocation(location);
    }

    public IPlayer setVelocity(Vector vector) {
        this.player.setVelocity(vector);
        return this;
    }

    public Vector getVelocity() {
        return this.player.getVelocity();
    }

    /**
     * @deprecated
     */
    public boolean isOnGround() {
        return this.player.isOnGround();
    }

    public World getWorld() {
        return this.player.getWorld();
    }

    public boolean teleport(Location location) {
        return this.player.teleport(location);
    }

    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return this.player.teleport(location, teleportCause);
    }

    public boolean teleport(Entity entity) {
        return this.player.teleport(entity);
    }

    public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
        return this.player.teleport(entity, teleportCause);
    }

    public List<Entity> getNearbyEntities(double v, double v1, double v2) {
        return this.player.getNearbyEntities(v, v1, v2);
    }

    public int getEntityId() {
        return this.player.getEntityId();
    }

    public int getFireTicks() {
        return this.player.getFireTicks();
    }

    public int getMaxFireTicks() {
        return this.player.getMaxFireTicks();
    }

    public IPlayer setFireTicks(int i) {
        this.player.setFireTicks(i);
        return this;
    }

    public IPlayer remove() {
        this.player.remove();
        return this;
    }

    public boolean isDead() {
        return this.player.isDead();
    }

    public boolean isValid() {
        return this.player.isValid();
    }

    public IPlayer sendMessage(String s) {
        this.player.sendMessage(s);
        return this;
    }

    public IPlayer sendMessage(String[] strings) {
        this.player.sendMessage(strings);
        return this;
    }

    public Server getServer() {
        return this.player.getServer();
    }

    public Entity getPassenger() {
        return this.player.getPassenger();
    }

    public boolean setPassenger(Entity entity) {
        return this.player.setPassenger(entity);
    }

    public boolean isEmpty() {
        return this.player.isEmpty();
    }

    public boolean eject() {
        return this.player.eject();
    }

    public float getFallDistance() {
        return this.player.getFallDistance();
    }

    public IPlayer setFallDistance(float v) {
        this.player.setFallDistance(v);
        return this;
    }

    public IPlayer setLastDamageCause(EntityDamageEvent entityDamageEvent) {
        this.player.setLastDamageCause(entityDamageEvent);
        return this;
    }

    public EntityDamageEvent getLastDamageCause() {
        return this.player.getLastDamageCause();
    }

    public UUID getUniqueId() {
        return this.player.getUniqueId();
    }

    public int getTicksLived() {
        return this.player.getTicksLived();
    }

    public IPlayer setTicksLived(int i) {
        this.player.setTicksLived(i);
        return this;
    }

    public IPlayer playEffect(EntityEffect entityEffect) {
        this.player.playEffect(entityEffect);
        return this;
    }

    public EntityType getType() {
        return this.player.getType();
    }

    public boolean isInsideVehicle() {
        return this.player.isInsideVehicle();
    }

    public boolean leaveVehicle() {
        return this.player.leaveVehicle();
    }

    public Entity getVehicle() {
        return this.player.getVehicle();
    }

    public IPlayer setCustomName(String s) {
        this.player.setCustomName(s);
        return this;
    }

    public String getCustomName() {
        return this.player.getCustomName();
    }

    public IPlayer setCustomNameVisible(boolean b) {
        this.player.setCustomNameVisible(b);
        return this;
    }

    public boolean isCustomNameVisible() {
        return this.player.isCustomNameVisible();
    }

    public boolean isFlying() {
        return this.player.isFlying();
    }

    public IPlayer setFlying(boolean b) {
        this.player.setFlying(b);
        return this;
    }

    public IPlayer setFlySpeed(float v) throws IllegalArgumentException {
        this.player.setFlySpeed(v);
        return this;
    }

    public IPlayer setWalkSpeed(float v) throws IllegalArgumentException {
        this.player.setWalkSpeed(v);
        return this;
    }

    public float getFlySpeed() {
        return this.player.getFlySpeed();
    }

    public float getWalkSpeed() {
        return this.player.getWalkSpeed();
    }

    /**
     * @deprecated
     */
    public IPlayer setTexturePack(String s) {
        this.player.setTexturePack(s);
        return this;
    }

    public IPlayer setResourcePack(String s) {
        this.player.setResourcePack(s);
        return this;
    }

    public Scoreboard getScoreboard() {
        return this.player.getScoreboard();
    }

    public IPlayer setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        this.player.setScoreboard(scoreboard);
        return this;
    }

    public boolean isHealthScaled() {
        return this.player.isHealthScaled();
    }

    public IPlayer setHealthScaled(boolean b) {
        this.player.setHealthScaled(b);
        return this;
    }

    public IPlayer setHealthScale(double v) throws IllegalArgumentException {
        this.player.setHealthScale(v);
        return this;
    }

    public double getHealthScale() {
        return this.player.getHealthScale();
    }

    public Entity getSpectatorTarget() {
        return this.player.getSpectatorTarget();
    }

    public IPlayer setSpectatorTarget(Entity entity) {
        this.player.setSpectatorTarget(entity);
        return this;
    }

    /**
     * @deprecated
     */
    public IPlayer sendTitle(String s, String s1) {
        this.player.sendTitle(s, s1);
        return this;
    }

    /**
     * @deprecated
     */
    public IPlayer resetTitle() {
        this.player.resetTitle();
        return this;
    }

    public Player.Spigot spigot() {
        return this.player.spigot();
    }

    public Map<String, Object> serialize() {
        return this.player.serialize();
    }

    public String getName() {
        return this.player.getName();
    }

    public PlayerInventory getInventory() {
        return this.player.getInventory();
    }

    public Inventory getEnderChest() {
        return this.player.getEnderChest();
    }

    public boolean setWindowProperty(InventoryView.Property property, int i) {
        return this.player.setWindowProperty(property, i);
    }

    public InventoryView getOpenInventory() {
        return this.player.getOpenInventory();
    }

    public InventoryView openInventory(Inventory inventory) {
        return this.player.openInventory(inventory);
    }

    public InventoryView openWorkbench(Location location, boolean b) {
        return this.player.openWorkbench(location, b);
    }

    public InventoryView openEnchanting(Location location, boolean b) {
        return this.player.openEnchanting(location, b);
    }

    public IPlayer openInventory(InventoryView inventoryView) {
        this.player.openInventory(inventoryView);
        return this;
    }

    public IPlayer closeInventory() {
        this.player.closeInventory();
        return this;
    }

    public ItemStack getItemInHand() {
        return this.player.getItemInHand();
    }

    public IPlayer setItemInHand(ItemStack itemStack) {
        this.player.setItemInHand(itemStack);
        return this;
    }

    public ItemStack getItemOnCursor() {
        return this.player.getItemOnCursor();
    }

    public IPlayer setItemOnCursor(ItemStack itemStack) {
        this.player.setItemOnCursor(itemStack);
        return this;
    }

    public boolean isSleeping() {
        return this.player.isSleeping();
    }

    public int getSleepTicks() {
        return this.player.getSleepTicks();
    }

    public GameMode getGameMode() {
        return this.player.getGameMode();
    }

    public IPlayer setGameMode(GameMode gameMode) {
        this.player.setGameMode(gameMode);
        return this;
    }

    public boolean isBlocking() {
        return this.player.isBlocking();
    }

    public int getExpToLevel() {
        return this.player.getExpToLevel();
    }

    public double getEyeHeight() {
        return this.player.getEyeHeight();
    }

    public double getEyeHeight(boolean b) {
        return this.player.getEyeHeight(b);
    }

    public Location getEyeLocation() {
        return this.player.getEyeLocation();
    }

    /**
     * @deprecated
     */
    public List<Block> getLineOfSight(HashSet<Byte> hashSet, int i) {
        return this.player.getLineOfSight(hashSet, i);
    }

    public List<Block> getLineOfSight(Set<Material> set, int i) {
        return this.player.getLineOfSight(set, i);
    }

    /**
     * @deprecated
     */
    public Block getTargetBlock(HashSet<Byte> hashSet, int i) {
        return this.player.getTargetBlock(hashSet, i);
    }

    public Block getTargetBlock(Set<Material> set, int i) {
        return this.player.getTargetBlock(set, i);
    }

    /**
     * @deprecated
     */
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> hashSet, int i) {
        return this.player.getLastTwoTargetBlocks(hashSet, i);
    }

    public List<Block> getLastTwoTargetBlocks(Set<Material> set, int i) {
        return this.player.getLastTwoTargetBlocks(set, i);
    }

    /**
     * @deprecated
     */
    public Egg throwEgg() {
        return this.player.throwEgg();
    }

    /**
     * @deprecated
     */
    public Snowball throwSnowball() {
        return this.player.throwSnowball();
    }

    /**
     * @deprecated
     */
    public Arrow shootArrow() {
        return this.player.shootArrow();
    }

    public int getRemainingAir() {
        return this.player.getRemainingAir();
    }

    public IPlayer setRemainingAir(int i) {
        this.player.setRemainingAir(i);
        return this;
    }

    public int getMaximumAir() {
        return this.player.getMaximumAir();
    }

    public IPlayer setMaximumAir(int i) {
        this.player.setMaximumAir(i);
        return this;
    }

    public int getMaximumNoDamageTicks() {
        return this.player.getMaximumNoDamageTicks();
    }

    public IPlayer setMaximumNoDamageTicks(int i) {
        this.player.setMaximumNoDamageTicks(i);
        return this;
    }

    public double getLastDamage() {
        return this.player.getLastDamage();
    }

    public IPlayer setLastDamage(double v) {
        this.player.setLastDamage(v);
        return this;
    }

    public int getNoDamageTicks() {
        return this.player.getNoDamageTicks();
    }

    public IPlayer setNoDamageTicks(int i) {
        this.player.setNoDamageTicks(i);
        return this;
    }

    public Player getKiller() {
        return this.player.getKiller();
    }

    public boolean addPotionEffect(PotionEffect potionEffect) {
        return this.player.addPotionEffect(potionEffect);
    }

    public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
        return this.player.addPotionEffect(potionEffect, b);
    }

    public boolean addPotionEffects(Collection<PotionEffect> collection) {
        return this.player.addPotionEffects(collection);
    }

    public boolean hasPotionEffect(PotionEffectType potionEffectType) {
        return this.player.hasPotionEffect(potionEffectType);
    }

    public IPlayer removePotionEffect(PotionEffectType potionEffectType) {
        this.player.removePotionEffect(potionEffectType);
        return this;
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        return this.player.getActivePotionEffects();
    }

    public boolean hasLineOfSight(Entity entity) {
        return this.player.hasLineOfSight(entity);
    }

    public boolean getRemoveWhenFarAway() {
        return this.player.getRemoveWhenFarAway();
    }

    public IPlayer setRemoveWhenFarAway(boolean b) {
        this.player.setRemoveWhenFarAway(b);
        return this;
    }

    public EntityEquipment getEquipment() {
        return this.player.getEquipment();
    }

    public IPlayer setCanPickupItems(boolean b) {
        this.player.setCanPickupItems(b);
        return this;
    }

    public boolean getCanPickupItems() {
        return this.player.getCanPickupItems();
    }

    public boolean isLeashed() {
        return this.player.isLeashed();
    }

    public Entity getLeashHolder() throws IllegalStateException {
        return this.player.getLeashHolder();
    }

    public boolean setLeashHolder(Entity entity) {
        return this.player.setLeashHolder(entity);
    }

    public IPlayer damage(double v) {
        this.player.damage(v);
        return this;
    }

    public IPlayer damage(double v, Entity entity) {
        this.player.damage(v, entity);
        return this;
    }

    public double getHealth() {
        return this.player.getHealth();
    }

    public IPlayer setHealth(double v) {
        this.player.setHealth(v);
        return this;
    }

    public double getMaxHealth() {
        return this.player.getMaxHealth();
    }

    public IPlayer setMaxHealth(double v) {
        this.player.setMaxHealth(v);
        return this;
    }

    public IPlayer resetMaxHealth() {
        this.player.resetMaxHealth();
        return this;
    }

    public IPlayer setMetadata(String s, MetadataValue metadataValue) {
        this.player.setMetadata(s, metadataValue);
        return this;
    }

    public List<MetadataValue> getMetadata(String s) {
        return this.player.getMetadata(s);
    }

    public boolean hasMetadata(String s) {
        return this.player.hasMetadata(s);
    }

    public IPlayer removeMetadata(String s, Plugin plugin) {
        this.player.removeMetadata(s, plugin);
        return this;
    }

    public boolean isPermissionSet(String s) {
        return this.player.isPermissionSet(s);
    }

    public boolean isPermissionSet(Permission permission) {
        return this.player.isPermissionSet(permission);
    }

    public boolean hasPermission(String s) {
        return this.player.hasPermission(s);
    }

    public boolean hasPermission(Permission permission) {
        return this.player.hasPermission(permission);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return this.player.addAttachment(plugin, s, b);
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return this.player.addAttachment(plugin);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return this.player.addAttachment(plugin, s, b, i);
    }

    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return this.player.addAttachment(plugin, i);
    }

    public IPlayer removeAttachment(PermissionAttachment permissionAttachment) {
        this.player.removeAttachment(permissionAttachment);
        return this;
    }

    public IPlayer recalculatePermissions() {
        this.player.recalculatePermissions();
        return this;
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.player.getEffectivePermissions();
    }

    public boolean isOp() {
        return this.player.isOp();
    }

    public IPlayer setOp(boolean b) {
        this.player.setOp(b);
        return this;
    }

    public IPlayer sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
        this.player.sendPluginMessage(plugin, s, bytes);
        return this;
    }

    public Set<String> getListeningPluginChannels() {
        return this.player.getListeningPluginChannels();
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
        return this.player.launchProjectile(aClass);
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> aClass, Vector vector) {
        return this.player.launchProjectile(aClass, vector);
    }
}

