package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.GameManager;
import me.collebol.deathswapplugin.manage.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    private GameState gameState;
    private GameManager gameManager;

    public JoinCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(PlayerList.playerList.size() > 0){
            if(!PlayerList.playerList.contains(player.getUniqueId())){
                PlayerList.playerList.add(player.getUniqueId());

                for(Player p : Bukkit.getOnlinePlayers()){
                    if(PlayerList.playerList.contains(p.getUniqueId())){
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                                "&b" + player.getName() + " &fjoined the game! &7[&b" + PlayerList.playerList.size() + "&7]"));
                    }
                }
            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fyou are already in the game!"));
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                    "&fthe game is already in progress! You should wait for the next one!"));
        }
        return false;
    }
}
