package com.goucraft.Listener;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class gouListener implements Listener {
    private final JavaPlugin plugin;
    private Economy economy = null;

    public gouListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void setEconomy(Economy e) {
        this.economy = e;
    }
}
