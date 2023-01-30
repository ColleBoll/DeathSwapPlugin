package me.collebol.deathswapplugin.events;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.GameManager;
import me.collebol.deathswapplugin.manage.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventPlayerLeave implements Listener {

    private GameManager gameManager;

    public EventPlayerLeave(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = (Player) event.getPlayer();

        if(PlayerList.playerList.contains(player.getUniqueId())){
            PlayerList.playerList.remove(player.getUniqueId());
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    if(PlayerList.playerList.size() < 2){
                        gameManager.setGameState(GameState.INACTIVE);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                                "&cTHE GAME IS CANCELED! TOO FEW PLAYERS!"));
                        Location loc = new Location(Bukkit.getWorld("world"), 0, 100, 0);
                        p.teleport(loc);
                        p.sendTitle("§4GAME CANCELED!", "§ctoo few players!");
                    }
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&b" + player.getName() + " &fquit the game! &7[&b" + PlayerList.playerList.size() + "&7]"));
                }
            }
        }

    }

}
