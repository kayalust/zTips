package net.zorapvp.ztips;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class TipsRunnable {

    private TipsPlugin plugin;

    public TipsRunnable(TipsPlugin plugin) {
        this.plugin = plugin;
    }
    public void autoBroadcast() {

        List<String> list = plugin.getConfig().getStringList("Tips");
        int interval = plugin.getConfig().getInt("interval");

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                Random random = new Random();
                int randomized = random.nextInt(list.size());

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', (String) list.get(randomized)));

                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("sound")), 10.0F, 1.0F);
                }
            }
        }, 0L,  interval * 20L);
    }
}
