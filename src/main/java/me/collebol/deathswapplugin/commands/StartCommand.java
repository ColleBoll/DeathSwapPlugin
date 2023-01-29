package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.Manager;
import me.collebol.deathswapplugin.manage.State;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StartCommand implements CommandExecutor {

    private State gameState;
    private Manager gameManager;

    public StartCommand(Manager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("deathswap.start")){
            if(PlayerList.playerList.size() > 1){
                gameManager.setGameState(State.STARTING);
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(PlayerList.playerList.contains(p.getUniqueId())){
                        player.sendTitle("§cGame is starting!", "§c20 sec!");
                    }
                }

            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fAt least 2 people must participate in the game!"));
            }
        }
        return false;
    }
}
