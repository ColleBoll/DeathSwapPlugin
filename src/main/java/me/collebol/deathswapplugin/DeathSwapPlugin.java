package me.collebol.deathswapplugin;

import me.collebol.deathswapplugin.commands.JoinCommand;
import me.collebol.deathswapplugin.commands.OpenCommand;
import me.collebol.deathswapplugin.commands.StartCommand;
import me.collebol.deathswapplugin.commands.TpAllToSpawn;
import me.collebol.deathswapplugin.events.EventPlayerJoin;
import me.collebol.deathswapplugin.events.EventPlayerLeave;
import me.collebol.deathswapplugin.files.FileLocations;
import me.collebol.deathswapplugin.gamedingen.PlayerList;
import me.collebol.deathswapplugin.gamedingen.PlayerLocationList;
import me.collebol.deathswapplugin.manage.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class DeathSwapPlugin extends JavaPlugin {

    private GameManager gameManager;

    public static DeathSwapPlugin pl;

    @Override
    public void onEnable() {
        pl = this;
        super.onEnable();
        this.gameManager = new GameManager(this);
        System.out.println("Death Swap plugin is on! Made by: ColleBol | play.ludocraft.net");

        this.getServer().getPluginManager().registerEvents(new EventPlayerLeave(gameManager), this);
        this.getServer().getPluginManager().registerEvents(new EventPlayerJoin(), this);

        getCommand("join").setExecutor(new JoinCommand(gameManager));
        getCommand("open").setExecutor(new OpenCommand(gameManager));
        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("tpalltospawn").setExecutor(new TpAllToSpawn());

        PlayerList.init();
        PlayerLocationList.init();

        FileLocations.setup();
        FileLocations.get().options().copyDefaults(true);
        FileLocations.save();

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

    public static DeathSwapPlugin getInstance(){
        return pl;
    }
}
