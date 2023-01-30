package me.collebol.deathswapplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();

        Location loc = new Location(Bukkit.getWorld("eventlobby"), -15.5, 81, -6.5, 90, 1);
        player.teleport(loc);
        player.sendTitle("§4Death Swap EVENT", "§cStarts at: 19:00");
        player.getInventory().clear();

    }

}
