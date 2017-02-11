package com.goucraft.Gou;

import com.goucraft.Listener.gouListeners;
import com.goucraft.Sql.gouSql;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Administrator on 2017/2/6 0006.
 */
public class gouMain extends JavaPlugin {
    public static final ItemStack gold = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
    public static String prefix = "[苟性别]";
    private Vault vault;
    private Economy economy = null;
    private static gouMain Instance;

    public static gouMain getInstance() {
        return Instance;
    }

    public Economy getEconomy() {
        return this.economy;
    }

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
        Instance = this;
        System.out.println(prefix + "启动中。。。");
        getServer().getPluginManager().registerEvents(new gouListeners(), this);
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        hookVault();
        gouSql.startDatabaseConnection();
    }

    @Override
    public void onDisable() {
        System.out.println(prefix + "卸载中。。。");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("error");
            return true;
        }
        Player player = (Player) sender;
        if ((args.length == 1) && (args[0].equalsIgnoreCase("a"))) {
            Inventory inventory = Bukkit.createInventory(player, 54, "§6§l苟菜单");
            ItemStack black = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta blackmeta = black.getItemMeta();
            blackmeta.setDisplayName("§5§l性别");
            black.setItemMeta(blackmeta);
            inventory.setItem(1, gold);
            player.openInventory(inventory);
        }
        return false;
    }
}
