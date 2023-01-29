package me.collebol.deathswapplugin.gamedingen;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.manage.Manager;
import me.collebol.deathswapplugin.manage.State;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartCountdown implements Runnable {

    private Manager gameManager;

    public StartCountdown(Manager gameManager){
        this.gameManager = gameManager;
    }

    int time = 10;

    @Override
    public void run() {
        time--;
        if(this.time < 1){
            gameManager.setGameState(State.ACTIVE);
            Bukkit.getScheduler().cancelTask(time);
            return;
        }
        for(Player p : Bukkit.getOnlinePlayers()){
            if(PlayerList.playerList.contains(p.getUniqueId())){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fThe game will start in &b" + this.time + " &fseconds!"));
            }
        }

    }
}
