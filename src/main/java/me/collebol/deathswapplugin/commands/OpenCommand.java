package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.manage.Manager;
import me.collebol.deathswapplugin.manage.State;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenCommand implements CommandExecutor {
    private State gameState;
    private Manager gameManager;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("deathswap.open")){
            gameManager.setGameState(State.QUE);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                    "&fDeath Swap is open now!"));

        }else{

        }
        return false;
    }
}
