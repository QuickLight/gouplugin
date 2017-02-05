package com.goucraft.Main;

import com.goucraft.Listener.gouListener;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class gou extends JavaPlugin {
    private Vault vault;
    private Economy economy = null;

    public boolean hookVault() {
        this.vault = (Vault) this.getServer().getPluginManager().getPlugin("Vault");
        if (this.vault != null) {
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp != null) {
                this.economy = rsp.getProvider();
                this.getLogger().info("succeed");
            } else if (rsp == null) {
                this.getLogger().info("Failed to get economy");
            }
            this.getLogger().info("found vault");
        }
        return true;
    }
    @Override
    public void onEnable() {
        gouListener gouListener = new gouListener(this);
        System.out.println("PluginEnable2333");
        getServer().getPluginManager().registerEvents(gouListener, this);
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        hookVault();
        gouListener.setEconomy(economy);

    }

    @Override
    public void onDisable() {
        System.out.println("PluginDisable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }

}
