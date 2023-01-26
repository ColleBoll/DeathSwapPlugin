package me.collebol.deathswapplugin.events;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventPlayerLeave implements Listener {

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event){
        Player player = (Player) event.getPlayer();

        if(PlayerList.playerList.contains(player.getUniqueId())){
            PlayerList.playerList.remove(player.getUniqueId());
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&b" + player.getName() + " &fquit the game! &7[&b" + PlayerList.playerList.size() + "&7]"));
                }
            }
        }

    }

}
