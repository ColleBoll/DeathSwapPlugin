package me.collebol.deathswapplugin.gamedingen;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.files.FileLocations;
import me.collebol.deathswapplugin.manage.GameManager;
import me.collebol.deathswapplugin.manage.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameCountDown extends BukkitRunnable {
    private GameManager gameManager;

    public GameCountDown(GameManager gameManager){
        this.gameManager = gameManager;
    }

    private int timeLeft = 180;

    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Override
    public void run() {
        if(timeLeft == 180){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&c3 MINUTES BEFORE THE SWAP!"));
                }
            }
        }
        if(timeLeft == 120){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&c2 MINUTES BEFORE THE SWAP!"));
                }
            }
        }
        if(timeLeft == 60){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&c1 MINUTES BEFORE THE SWAP!"));
                }
            }
        }
        if(timeLeft < 21){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                            "&b" + timeLeft + " &fseconds before the swap!"));
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                }
            }
        }
        if(timeLeft <= 0){
            cancel();
            gameManager.setGameState(GameState.SWAP);
            timeLeft = 20;
            for(Player p : Bukkit.getOnlinePlayers()){
                if(PlayerList.playerList.contains(p.getUniqueId())){
                    PlayerLocationList.playerList.add(p.getLocation());
                }
            }
        }
        console.sendMessage(timeLeft + " seconds before the swap!");
        timeLeft--;
    }
}
