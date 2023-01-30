package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpAllToSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("deathswap.tpall")){
            for(Player p : Bukkit.getOnlinePlayers()){
                Location loc = new Location(Bukkit.getWorld("eventlobby"), -15.5, 81, -6.5, 90, 1);
                p.teleport(loc);
                p.getInventory().clear();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fYou have been teleported to the event lobby!"));
                p.setGameMode(GameMode.ADVENTURE);
            }
        }
        return false;
    }
}
