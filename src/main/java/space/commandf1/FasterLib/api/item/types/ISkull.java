package space.commandf1.FasterLib.api.item.types;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import space.commandf1.FasterLib.api.item.IItemStack;

@SuppressWarnings("unused")
public class ISkull extends IItemStack {
    private final SkullMeta skullMeta;

    public ISkull(int amount, short damage) {
        super(Material.SKULL, amount, damage);
        this.skullMeta = (SkullMeta) this.getItemStack().getItemMeta();
    }

    /**
     * 设置头颅主人
     *
     * */
    public ISkull setOwner(String owner) {
        this.skullMeta.setOwner(owner);
        this.saveItemMeta();
        return this;
    }

    @Override
    protected void saveItemMeta() {
        super.itemStack.setItemMeta(this.skullMeta);
    }

    /**
     * 获取物品
     *
     * */
    @Override
    public ItemStack getItemStack() {
        return super.itemStack;
    }
}
