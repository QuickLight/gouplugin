package com.goucraft.Listener;

import com.goucraft.Gou.gouMain;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class gouListeners implements Listener {
    private final gouMain plugin = gouMain.getInstance();
    private Economy economy = plugin.getEconomy();

    public void setEconomy(Economy e) {
        this.economy = e;
    }

    @EventHandler
    public void playergui(InventoryClickEvent event) {
        if (event.getClickedInventory().getName().equals("§6§l苟菜单")) {
            event.setCancelled(true);//禁止拖动
            if (event.getCurrentItem() != null) {//点到空气报错
                if (event.getCurrentItem().getItemMeta().hasDisplayName()) {//判断是不是有名字
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l强化功能")) {
                        event.getWhoClicked().sendMessage("你点了强化");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l进化功能")) {
                        event.getWhoClicked().sendMessage("你点了进化");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l属性功能")) {
                        event.getWhoClicked().sendMessage("你点了属性");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l洗练功能")) {
                        event.getWhoClicked().sendMessage("你点了洗练");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l精炼功能")) {
                        event.getWhoClicked().sendMessage("你点了精炼");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l境界功能")) {
                        event.getWhoClicked().sendMessage("你点了境界");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l称号功能")) {
                        event.getWhoClicked().sendMessage("你点了称号");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l打孔功能")) {
                        event.getWhoClicked().sendMessage("你点了打孔");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l镶嵌功能")) {
                        event.getWhoClicked().sendMessage("你点了镶嵌");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l封印功能")) {
                        event.getWhoClicked().sendMessage("你点了封印");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l合成功能")) {
                        event.getWhoClicked().sendMessage("你点了合成");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l锻造功能")) {
                        event.getWhoClicked().sendMessage("你点了锻造");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l疲劳功能")) {
                        event.getWhoClicked().sendMessage("你点了疲劳");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l熟练功能")) {
                        event.getWhoClicked().sendMessage("你点了熟练");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l分解功能")) {
                        event.getWhoClicked().sendMessage("你点了分解");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l翅膀功能")) {
                        event.getWhoClicked().sendMessage("你点了翅膀");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l性别功能")) {
                        event.getWhoClicked().sendMessage("你点了性别");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l渡劫功能")) {
                        event.getWhoClicked().sendMessage("你点了渡劫");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l飞升功能")) {
                        event.getWhoClicked().sendMessage("你点了飞升");
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§l商城功能")) {
                        event.getWhoClicked().sendMessage("你点了商城");
                    }
                }
            } else {
                return;
            }
        }
    }
}
