package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

@Component
public class Player {
    //private final API api;
    private String tag;
    private String name;
    private int trophies;

    // no argument constructor
    public Player(){

    }

    // parameterized constructor
    public Player(String name, String tag, int trophies) {
        this.name = name;
        this.tag = tag;
        this.trophies = trophies;
    }

    public void displayStats() {

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

    public void setTrophies(){
        this.trophies = trophies;
    }


}
