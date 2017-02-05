package com.goucraft.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Administrator on 2017/2/5 0005.
 */
public class gou extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("PluginEnable");
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
