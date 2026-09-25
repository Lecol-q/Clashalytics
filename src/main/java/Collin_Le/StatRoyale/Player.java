package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

public class Player {
    // general information
    private String tag;
    private String name;
    private int trophies;
    private int battleCount;
    private int wins;
    private int losses;


    // no argument constructor
    public Player(){}

    // parameterized constructor
    public Player(String name, String tag, int trophies, int battleCount, int wins, int losses) {
        this.name = name;
        this.tag = tag;
        this.trophies = trophies;
        this.battleCount = battleCount;
        this.wins = wins;
        this.losses = losses;
    }

    // Player section
    public void displayPlayerStats() {
        double winrate = (double) wins / battleCount * 100;
        System.out.println("Name: " + name + "\nTag: " + tag + "\nTrophies: " + trophies);
        System.out.println("*Battle stats*");
        System.out.println("Wins: " + wins + "\nLosses: " + losses);
        System.out.printf("Winrate: %.0f%" + "%\n", winrate);
    }

    // getters
    public String getName(){
        return name;
    }

    public String getTag(){
        return tag;
    }

    public int getTrophies(){
        return trophies;
    }

    // setter
    public void setName(){
        this.name = name;
    }

    public void setTag(){
        this.tag = tag;
    }

    public void setTrophies(int Trophies){
        this.trophies = trophies;
    }


}
