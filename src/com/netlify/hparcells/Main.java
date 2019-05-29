package com.netlify.hparcells;

import com.netlify.hparcells.commands.WhereIs;
import com.netlify.hparcells.events.BedSleep;
import com.netlify.hparcells.events.CompassRightClick;
import com.netlify.hparcells.events.PlayerDeath;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private WhereIs whereIs = new WhereIs();

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nBetterSMP has been enabled.\n");

        // Register Events
        getServer().getPluginManager().registerEvents(new CompassRightClick(), this);
        getServer().getPluginManager().registerEvents(new BedSleep(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);

        // Register Commands
        getCommand(whereIs.commandName).setExecutor(whereIs);
    }
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nBetterSMP has been disabled.\n");
    }
}
