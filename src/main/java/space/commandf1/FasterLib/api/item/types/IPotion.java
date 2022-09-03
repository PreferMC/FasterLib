package space.commandf1.FasterLib.api.item.types;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import space.commandf1.FasterLib.api.item.IItemStack;

@SuppressWarnings("unused")
public class IPotion extends IItemStack {
    private final PotionMeta potionMeta;

    public IPotion(int amount, short damage) {
        super(Material.POTION, amount, damage);
        this.potionMeta = (PotionMeta) this.getItemStack().getItemMeta();
    }

    /**
     * 设置隐藏药水效果
     *
     * */
    public IPotion setHideEffect(boolean b) {
        this.potionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        this.saveItemMeta();
        return this;
    }

    /**
     * 添加药水效果
     *
     * */
    public IPotion addEffect(PotionEffect potionEffect) {
        this.potionMeta.addCustomEffect(potionEffect, true);
        this.saveItemMeta();
        return this;
    }

    /**
     * 添加药水效果
     *
     * */
    public IPotion addEffects(PotionEffect... potionEffects) {
        for (PotionEffect potionEffect : potionEffects) {
            this.potionMeta.addCustomEffect(potionEffect, true);
        }
        this.saveItemMeta();
        return this;
    }

    @Override
    protected void saveItemMeta() {
        super.itemStack.setItemMeta(this.potionMeta);
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
