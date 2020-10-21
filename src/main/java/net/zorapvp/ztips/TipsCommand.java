package net.zorapvp.ztips;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TipsCommand implements CommandExecutor {

    private TipsPlugin plugin;

    public TipsCommand(TipsPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player p;

        p = (Player) commandSender;

        if (p.hasPermission("zora.command.tips")) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                commandSender.sendMessage("§aSuccessfully reloaded config file!");
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
