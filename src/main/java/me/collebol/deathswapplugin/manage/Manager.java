package me.collebol.deathswapplugin.manage;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.gamedingen.StartCountdown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

public class Manager {
    private final DeathSwapPlugin plugin;
    public Manager(DeathSwapPlugin plugin){
        this.plugin = plugin;
    }

    private State state = State.INACTIVE;

    private StartCountdown startCountdown;

    public void setGameState(State gameState) {
        if(this.state == State.INACTIVE) return;
        if(this.state == gameState) return;
        this.state = gameState;
        switch (gameState){
            case QUE:
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fTHE DEATH SWAP EVENT IS OPEN NOW! JOIN USING /JOIN!!!!"));
                break;
            case STARTING:
                this.startCountdown = new StartCountdown(this);
                this.startCountdown.run();
                break;
            case ACTIVE:
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(PlayerList.playerList.contains(p.getUniqueId())){
                        p.sendTitle("§cGAME START!", "§aGood Luck!");

                        Random random = new Random();
                        int x = random.nextInt(5000);
                        int y = 150;
                        int z = random.nextInt(5000);
                        Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                        p.teleport(loc);
                    }
                }
                break;

        }
    }
}
