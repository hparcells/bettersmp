package com.netlify.hparcells.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedSleep implements Listener {
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        if(!isDay()) {
            Bukkit.broadcastMessage(String.format(ChatColor.GREEN + "%1$s is now sleeping.", player.getName()));
        }
    }
    @EventHandler
    public void onBedExit(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();

        if(!isDay()) {
            Bukkit.broadcastMessage(String.format(ChatColor.GREEN + "%1$s is no longer sleeping.", player.getName()));
        }
    }

    private boolean isDay() {
        Long time = Bukkit.getServer().getWorld("world").getTime();

        return time < 12300 || time > 23850;
    }
}
