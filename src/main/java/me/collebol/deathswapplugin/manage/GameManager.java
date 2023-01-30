package me.collebol.deathswapplugin.manage;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.GameCountDown;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.gamedingen.PlayerLocationList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.*;

public class GameManager {

    private final DeathSwapPlugin plugin;
    private GameState gameState = GameState.INACTIVE;

    public GameManager(DeathSwapPlugin plugin){
        this.plugin = plugin;

    }

    private GameCountDown gameCountDown;

    int CD = 20;
    int save2;

    public void setGameState(GameState gameState) {
        if(this.gameState == GameState.BEZIG && gameState == GameState.QUE) return;
        if(this.gameState == GameState.SWAP) return;
        if(this.gameState == gameState) return;

        this.gameState = gameState;
        switch (gameState) {
            case QUE:
                Bukkit.broadcastMessage("Que is open!");

                break;
            case BEZIG:

                this.gameCountDown = new GameCountDown(this);
                this.gameCountDown.runTaskTimer(plugin, 0, 20);

                break;
            case SWAP:



        }
    }

    public void cleanup() {

    }
}
