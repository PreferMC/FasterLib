package space.commandf1.FasterLib.api.inventory.action;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;

@SuppressWarnings("unused")
public class GUIAction implements Serializable {
    private final Action action;
    private ClickType clickType = null;
    private ItemStack itemStack = null;
    private int i = -1;
    private final ActionType actionType;

    /**
     * 创建一个GUIAction
     * 指定点击方式
     * 以物品定义判断
     *
     * */
    public GUIAction(Action action, ClickType clickType, ItemStack itemStack) {
        this.action = action;
        this.clickType = clickType;
        this.itemStack = itemStack;
        this.actionType = ActionType.ITEM;
    }

    /**
     * 创建一个GUIAction
     * 指定点击方式
     * 以点击栏位定义判断
     *
     * */
    public GUIAction(Action action, ClickType clickType, int i) {
        this.action = action;
        this.clickType = clickType;
        this.i = i;
        this.actionType = ActionType.NUM;
    }

    /**
     * 创建一个GUIAction
     * 不指定点击方式
     * 以点击栏位定义判断
     *
     * */
    public GUIAction(Action action, int i) {
        this.action = action;
        this.i = i;
        this.actionType = ActionType.NUM;
    }

    /**
     * 创建一个GUIAction
     * 不指定点击方式
     * 以物品定义判断
     *
     * */
    public GUIAction(Action action, ItemStack itemStack) {
        this.action = action;
        this.itemStack = itemStack;
        this.actionType = ActionType.ITEM;
    }

    /**
     * 获取Action
     *
     * */
    public Action getAction() {
        return this.action;
    }

    /**
     * 获取点击方式
     *
     * */
    public ClickType getClickType() {
        return this.clickType;
    }

    /**
     * 获取物品
     *
     * */
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    /**
     * 获取点击物品栏位
     *
     * */
    public int getI() {
        return this.i;
    }

    /**
     * 获取ActionType
     *
     * */
    public ActionType getActionType() {
        return this.actionType;
    }
}
