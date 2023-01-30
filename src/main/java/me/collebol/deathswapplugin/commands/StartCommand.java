package me.collebol.deathswapplugin.commands;

import me.collebol.deathswapplugin.DeathSwapPlugin;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.GameManager;
import me.collebol.deathswapplugin.manage.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class StartCommand implements CommandExecutor {

    private GameState gameState;
    private GameManager gameManager;

    public StartCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    int CD = 10;
    int save;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("deathswap.start")){
            if(PlayerList.playerList.size() > 1){
                save = Bukkit.getScheduler().scheduleSyncRepeatingTask(DeathSwapPlugin.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        if(CD > 1){
                            for(Player p : Bukkit.getOnlinePlayers()){
                                if(PlayerList.playerList.contains(p.getUniqueId())){
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                                            "&fThe game will start in &b" + CD + " &fseconds!"));
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                                }
                            }
                            CD--;
                        } else if (CD == 1) {
                            for(Player p : Bukkit.getOnlinePlayers()){
                                if(PlayerList.playerList.contains(p.getUniqueId())){
                                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                                            "&fThe game will start in &b" + CD + " &fsecond!"));
                                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                                }
                            }
                            CD--;

                        } else if (CD == 0) {
                            Bukkit.getScheduler().cancelTask(save);
                            gameManager.setGameState(GameState.BEZIG);

                            for(Player p : Bukkit.getOnlinePlayers()){
                                if(PlayerList.playerList.contains(p.getUniqueId())){
                                    p.sendTitle("§cGAME START!", "§aGood Luck!");
                                    Bukkit.getScheduler().cancelTask(save);
                                    Random random = new Random();
                                    int x = random.nextInt(5000);
                                    int y = 150;
                                    int z = random.nextInt(5000);
                                    Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                                    p.teleport(loc);
                                    p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
                                }
                            }
                            CD = 10;
                        }
                    }

                }, 20, 20);
            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', DeathSwapPlugin.prefix +
                        "&fAt least 2 people must participate in the game!"));
            }
        }
        return false;
    }
}
