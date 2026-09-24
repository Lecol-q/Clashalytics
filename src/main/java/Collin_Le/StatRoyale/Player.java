package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

public class Player {
    private String tag;
    private String name;
    private int trophies;


    // no argument constructor
    public Player(){}

    // parameterized constructor
    public Player(String name, String tag, int trophies) {
        this.name = name;
        this.tag = tag;
        this.trophies = trophies;
    }

    // Player section
    public void displayPlayerStats() {
        System.out.println("Name: " + name + "\nTag: " + tag + "\nTrophies: " + trophies);
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
