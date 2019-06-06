package com.netlify.hparcells.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CompassRightClick implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getItem() != null && event.getItem().getType() == Material.COMPASS) {
                Location playerLocation = player.getLocation();
                String location = String.format("(%1$s, %2$s, %3$s)",
                        Math.round(playerLocation.getX()),
                        Math.round(playerLocation.getY()),
                        Math.round(playerLocation.getZ())
                );
                player.sendMessage(ChatColor.GREEN + String.format("You are at %1$s in %2$s.",
                    location,
                    player.getWorld().getName()
                ));
                player.getWorld().playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_HARP, 10, 1);
            }
        }
    }
}
