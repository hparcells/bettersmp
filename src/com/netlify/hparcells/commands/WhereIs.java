package com.netlify.hparcells.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WhereIs implements Listener, CommandExecutor {
    public String commandName = "whereIs";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(sender instanceof Player) {
            Player commandSender = (Player)sender;

            if(command.getName().equalsIgnoreCase(commandName)) {
                String playerName = String.join(" ", args);
                Player player = Bukkit.getServer().getPlayer(String.join(" ", args));

                if(player != null) {
                    Location playerLocation = Bukkit.getServer().getPlayer(playerName).getLocation();
                    String location = String.format("(%1$s, %2$s, %3$s)",
                            Math.round(playerLocation.getX()),
                            Math.round(playerLocation.getY()),
                            Math.round(playerLocation.getZ())
                    );

                    commandSender.sendMessage(ChatColor.GREEN + String.format("%1$s is at %2$s in %3$s.",
                            playerName,
                            location,
                            player.getWorld().getName())
                    );

                    return true;
                }else {
                    commandSender.sendMessage(ChatColor.RED + String.format("Player %1$s not found!", playerName));
                    return true;
                }
            }
        }else {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        return false;
    }
}
