package space.commandf1.FasterLib.api.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class IItemStack implements Serializable {
    protected final ItemStack itemStack;
    private final ItemMeta itemMeta;

    /**
     * 直接初始化
     *
     * */
    public IItemStack(Material type, int amount, short damage) {
        this.itemStack = new ItemStack(type, amount, damage);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    /**
     * 获取物品
     * @author commandf1
     *
     * */
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    /**
     * 设置物品数量
     *
     * */
    public IItemStack setAmountNumber(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    /**
     * 获取物品本实例
     * @author commandf1
     *
     * */
    public IItemStack getIItemStack() {
        return this;
    }

    /**
     * 设置物品名字
     * @author commandf1
     *
     * */
    public IItemStack setItemName(String name) {
        this.itemMeta.setDisplayName(name);
        this.saveItemMeta();
        return this;
    }

    /**
     * 设置物品描述信息(换行符表示一行)
     * @author commandf1
     *
     * */
    public IItemStack setItemLore(String lore) {
        this.setItemLore(lore.split("\n"));
        this.saveItemMeta();
        return this;
    }

    /**
     * 设置物品描述信息
     *
     * @author commandf1
     */
    @SuppressWarnings("all")
    public IItemStack setItemLore(String[] lore) {
        this.itemMeta.setLore(Arrays.asList(lore));
        this.saveItemMeta();
        return this;
    }

    /**
     * 设置物品描述信息
     *
     * @author commandf1
     */
    @SuppressWarnings("all")
    public IItemStack setItemLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        this.saveItemMeta();
        return this;
    }

    /**
     * 设置物品是否闪光
     *
     * @author commandf1
     * */
    public IItemStack setGlow(boolean b) {
        this.itemMeta.addEnchant(new Enchantment(70) {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getMaxLevel() {
                return 0;
            }

            @Override
            public int getStartLevel() {
                return 0;
            }

            @Override
            public EnchantmentTarget getItemTarget() {
                return null;
            }

            @Override
            public boolean conflictsWith(Enchantment enchantment) {
                return false;
            }

            @Override
            public boolean canEnchantItem(ItemStack itemStack) {
                return false;
            }
        }, 1, b);
        return this;
    }

    /**
     * 设置无法破坏
     * @author commandf1
     *
     **/
    public IItemStack setUnbreakable(boolean b) {
        this.itemMeta.spigot().setUnbreakable(b);
        return this;
    }

    /**
     * 设置头颅主人(前提是物品是SKULL_ITEM)
     * @author commandf1
     *
     * */
    public IItemStack setOwner(String name) {
        if (!this.itemStack.getType().equals(Material.SKULL_ITEM)) {
            return this;
        }
        SkullMeta skullMeta = (SkullMeta) this.itemMeta;
        skullMeta.setOwner(name);
        this.itemStack.setItemMeta(skullMeta);
        return this;
    }

    /*
    * 保存设置
    * */
    protected void saveItemMeta() {
        this.itemStack.setItemMeta(this.itemMeta);
    }
}
