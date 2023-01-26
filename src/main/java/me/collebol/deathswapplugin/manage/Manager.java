package me.collebol.deathswapplugin.manage;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
    private final DeathSwapPlugin plugin;
    public Manager(DeathSwapPlugin plugin){
        this.plugin = plugin;
    }

    private State gameState = State.INACTIVE;

    public void setGameState(State gameState) {
        this.gameState = gameState;
        switch (gameState){
            case QUE:
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fTHE DEATH SWAP EVENT IS OPEN NOW! JOIN USING /JOIN!!!!"));

        }
    }
}
