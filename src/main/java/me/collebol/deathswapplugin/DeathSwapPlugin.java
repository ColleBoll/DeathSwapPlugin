package me.collebol.deathswapplugin;

import me.collebol.deathswapplugin.gamedingen.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class DeathSwapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Death Swap plugin is on! Made by: ColleBol | play.ludocraft.net");

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
