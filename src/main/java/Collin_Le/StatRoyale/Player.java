package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpRequest;

@Component
public class Player {
    Player player;

    String BASE_URL = Config.getURL("BASE_URL");

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



    // Player section
    public void displayStats() throws IOException {
        System.out.println("Name: " + name + "\n" + "Tag: " + tag + "\n" + "Trophies: " + trophies);
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
