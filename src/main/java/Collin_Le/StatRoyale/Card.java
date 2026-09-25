package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

import java.util.List;

public class Card {
    private String name;
    private String elixirCost;
    private String rarity;

    // Empty constructor
    public Card(){}

    public Card(String name, String elixirCost, String rarity){
        this.name = name;
        this.elixirCost = elixirCost;
        this.rarity = rarity;
    }

    public void displayCardStats() {
        System.out.println("Card Name: " + name + "\nElixir Cost: " + elixirCost + "\nRarity: " + rarity);
    }

    // getters
    public String getName(){
        return name;
    }

    public String getElixirCost(){
        return elixirCost;
    }

    public String getRarity(){
        return rarity;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setElixirCost(String elixirCost){
        this.elixirCost = elixirCost;
    }

    public void setRarity(String rarity){
        this.rarity = rarity;
    }

    public String toString(){
        return name + " : " + elixirCost + " : " + rarity;
    }
}
