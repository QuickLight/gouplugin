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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

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

        if ((args.length == 1) && (args[0].equalsIgnoreCase("a"))) {
            playergui(sender);
        }
        return false;
    }

    public void playergui(CommandSender sender) {
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(player, 54, "§6§l苟菜单");
        ItemStack qianghua = new ItemStack(Material.ANVIL);
        ItemMeta meta = qianghua.getItemMeta();
        meta.setDisplayName("§5§l强化功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入强化功能");
            }
        });
        qianghua.setItemMeta(meta);
        inventory.setItem(0, qianghua);

        ItemStack jinhua = new ItemStack(Material.DIAMOND);
        meta = jinhua.getItemMeta();
        meta.setDisplayName("§5§l进化功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入进化功能");
            }
        });
        jinhua.setItemMeta(meta);
        inventory.setItem(2, jinhua);

        ItemStack shuxing = new ItemStack(Material.DIAMOND_SWORD);
        meta = shuxing.getItemMeta();
        meta.setDisplayName("§5§l属性功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入属性功能");
            }
        });
        shuxing.setItemMeta(meta);
        inventory.setItem(4, shuxing);

        ItemStack xilian = new ItemStack(Material.APPLE);
        meta = xilian.getItemMeta();
        meta.setDisplayName("§5§l洗练功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入洗练功能");
            }
        });
        xilian.setItemMeta(meta);
        inventory.setItem(6, xilian);

        ItemStack jinglian = new ItemStack(Material.GOLDEN_APPLE);
        meta = jinglian.getItemMeta();
        meta.setDisplayName("§5§l精炼功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入精炼功能");
            }
        });
        jinglian.setItemMeta(meta);
        inventory.setItem(8, jinglian);

        ItemStack jingjie = new ItemStack(Material.BEACON);
        meta = jingjie.getItemMeta();
        meta.setDisplayName("§5§l境界功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入境界功能");
            }
        });
        jingjie.setItemMeta(meta);
        inventory.setItem(9, jingjie);

        ItemStack chenghao = new ItemStack(Material.DAYLIGHT_DETECTOR);
        meta = chenghao.getItemMeta();
        meta.setDisplayName("§5§l称号功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入称号功能");
            }
        });
        chenghao.setItemMeta(meta);
        inventory.setItem(11, chenghao);

        ItemStack dakong = new ItemStack(Material.GOLD_PICKAXE);
        meta = dakong.getItemMeta();
        meta.setDisplayName("§5§l打孔功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入打孔功能");
            }
        });
        dakong.setItemMeta(meta);
        inventory.setItem(13, dakong);

        ItemStack xiangqian = new ItemStack(Material.FLINT_AND_STEEL);
        meta = xiangqian.getItemMeta();
        meta.setDisplayName("§5§l镶嵌功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入镶嵌功能");
            }
        });
        xiangqian.setItemMeta(meta);
        inventory.setItem(15, xiangqian);

        ItemStack fengying = new ItemStack(Material.NAME_TAG);
        meta = fengying.getItemMeta();
        meta.setDisplayName("§5§l封印功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入封印功能");
            }
        });
        fengying.setItemMeta(meta);
        inventory.setItem(17, fengying);

        ItemStack hecheng = new ItemStack(Material.WORKBENCH);
        meta = hecheng.getItemMeta();
        meta.setDisplayName("§5§l合成功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入合成功能");
            }
        });
        hecheng.setItemMeta(meta);
        inventory.setItem(18, hecheng);

        ItemStack duanzao = new ItemStack(Material.PISTON_STICKY_BASE);
        meta = duanzao.getItemMeta();
        meta.setDisplayName("§5§l锻造功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入锻造功能");
            }
        });
        duanzao.setItemMeta(meta);
        inventory.setItem(20, duanzao);

        ItemStack pilao = new ItemStack(Material.CHORUS_PLANT);
        meta = pilao.getItemMeta();
        meta.setDisplayName("§5§l疲劳功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入疲劳功能");
            }
        });
        pilao.setItemMeta(meta);
        inventory.setItem(22, pilao);

        ItemStack shulian = new ItemStack(Material.REDSTONE);
        meta = shulian.getItemMeta();
        meta.setDisplayName("§5§l熟练功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入熟练功能");
            }
        });
        shulian.setItemMeta(meta);
        inventory.setItem(24, shulian);

        ItemStack fenjie = new ItemStack(Material.SHEARS);
        meta = fenjie.getItemMeta();
        meta.setDisplayName("§5§l分解功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入分解功能");
            }
        });
        fenjie.setItemMeta(meta);
        inventory.setItem(26, fenjie);

        ItemStack chibang = new ItemStack(Material.FEATHER);
        meta = chibang.getItemMeta();
        meta.setDisplayName("§5§l翅膀功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入翅膀功能");
            }
        });
        chibang.setItemMeta(meta);
        inventory.setItem(27, chibang);

        ItemStack xingbie = new ItemStack(Material.IRON_INGOT);
        meta = xingbie.getItemMeta();
        meta.setDisplayName("§5§l性别功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入性别功能");
            }
        });
        xingbie.setItemMeta(meta);
        inventory.setItem(29, xingbie);

        ItemStack dujie = new ItemStack(Material.BLAZE_ROD);
        meta = dujie.getItemMeta();
        meta.setDisplayName("§5§l渡劫功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入渡劫功能");
            }
        });
        dujie.setItemMeta(meta);
        inventory.setItem(31, dujie);

        ItemStack feisheng = new ItemStack(Material.NETHER_STAR);
        meta = feisheng.getItemMeta();
        meta.setDisplayName("§5§l飞升功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入飞升功能");
            }
        });
        feisheng.setItemMeta(meta);
        inventory.setItem(33, feisheng);

        ItemStack shop = new ItemStack(Material.GOLD_NUGGET);
        meta = shop.getItemMeta();
        meta.setDisplayName("§5§l商城功能");
        meta.setLore(new ArrayList<String>() {
            {
                add("§c§l点击进入商城功能");
            }
        });
        shop.setItemMeta(meta);
        inventory.setItem(35, shop);
        player.openInventory(inventory);
    }
}
