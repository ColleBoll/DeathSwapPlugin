package me.collebol.deathswapplugin;

import me.collebol.deathswapplugin.commands.JoinCommand;
import me.collebol.deathswapplugin.commands.OpenCommand;
import me.collebol.deathswapplugin.commands.StartCommand;
import me.collebol.deathswapplugin.events.EventPlayerLeave;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.manage.Manager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class DeathSwapPlugin extends JavaPlugin {

    private Manager gameManager;

    @Override
    public void onEnable() {
        super.onEnable();
        this.gameManager = new Manager(this);
        System.out.println("Death Swap plugin is on! Made by: ColleBol | play.ludocraft.net");

        this.getServer().getPluginManager().registerEvents(new EventPlayerLeave(), this);

        getCommand("join").setExecutor(new JoinCommand(gameManager));
        getCommand("open").setExecutor(new OpenCommand(gameManager));
        getCommand("start").setExecutor(new StartCommand(gameManager));

        PlayerList.init();

        init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static List playerList;


    public void init(){
        importConfigData();
    }

    public static String prefix;

    public void importConfigData(){
        String p = this.getConfig().getString("prefix");
        prefix = p;
    }
}
