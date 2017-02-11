package com.goucraft.Listener;

import com.goucraft.Gou.gouMain;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class gouListeners implements Listener {
    private final gouMain plugin = gouMain.getInstance();
    private Economy economy = plugin.getEconomy();

    public void setEconomy(Economy e) {
        this.economy = e;
    }

}
