package me.collebol.deathswapplugin.gamedingen;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    public static List playerList;

    public static void init(){
        createArry();
    }
    public static void createArry(){
        List<String> list = new ArrayList<>();
        playerList = list;
    }

}
