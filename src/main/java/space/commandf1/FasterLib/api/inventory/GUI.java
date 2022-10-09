package space.commandf1.FasterLib.api.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import space.commandf1.FasterLib.api.inventory.action.GUIAction;
import space.commandf1.FasterLib.api.item.IItemStack;
import space.commandf1.FasterLib.listeners.GUIListener;

import java.io.Serializable;

@SuppressWarnings("unused")
public class GUI implements Serializable {
    private final Inventory inventory;

    public GUI(int size, String title) {
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    /**
     * 将页面填满指定物品
     * @author commandf1
     * @param itemStack is
     *
     * */
    public void fullItem(ItemStack itemStack) {
        for (int i = 0; i < this.inventory.getSize(); i++) {
            this.inventory.setItem(i, itemStack);
        }
    }

    /**
     * 将页面填满指定物品
     * @author commandf1
     * @param iitemStack iis
     *
     * */
    public void fullItem(IItemStack iitemStack) {
        for (int i = 0; i < this.inventory.getSize(); i++) {
            this.inventory.setItem(i, iitemStack.getItemStack());
        }
    }

    /**
     * 设置物品
     * @author commandf1
     * @param itemStack is
     *
     * */
    public void setItem(int i, ItemStack itemStack) {
        this.inventory.setItem(i, itemStack);
    }

    /**
     * 设置物品
     * @author commandf1
     * @param iitemStack iis
     *
     * */
    public void setItem(int i, IItemStack iitemStack) {
        this.inventory.setItem(i, iitemStack.getItemStack());
    }

    /**
     * 添加Listener
     *
     * */
    public strictfp void addListener(GUIAction guiAction) {
        GUIListener.actions.put(guiAction, this.getInventory());
    }

    /**
     * 获取Inventory实例
     *
     * */
    public Inventory getInventory() {
        return this.inventory;
    }
}
