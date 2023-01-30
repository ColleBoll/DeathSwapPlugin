package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.GameManager;
import me.collebol.deathswapplugin.manage.GameState;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenCommand implements CommandExecutor {
    private GameState gameState;
    private GameManager gameManager;

    public OpenCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("deathswap.open")){
            gameManager.setGameState(GameState.QUE);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                    "&fDeath Swap is open now!"));
            PlayerList.playerList.add(player.getUniqueId());

        }else{

        }
        return false;
    }
}
