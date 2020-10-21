package net.zorapvp.ztips;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TipsPlugin extends JavaPlugin {

    TipsRunnable tipsRunnable = new TipsRunnable(this);
    private CommandSender sender = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        tipsRunnable.autoBroadcast();
        sender.sendMessage("§a[zTips] Successfully started Auto Broadcasting!");
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        getCommand("zoratips").setExecutor(new TipsCommand(this));
        sender.sendMessage("§a[zTips] Successfully registered the command!");

        sender.sendMessage("§a[zTips] Successfully loaded up the plugin!");
    }

    @Override
    public void onDisable() {
        sender.sendMessage("§c[zTips] Shutting down the plugin!");
    }
}
