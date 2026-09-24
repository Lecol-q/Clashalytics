package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

public class Card {
    private String name;
    private int elixirCost;
    private String rarity;

    // Empty constructor
    public Card(){}

    public Card(String name, int elixirCost, String rarity){
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

    public int getElixirCost(){
        return elixirCost;
    }

    public String getRarity(){
        return rarity;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setElixirCost(int elixirCost){
        this.elixirCost = elixirCost;
    }

    public void setRarity(String rarity){
        this.rarity = rarity;
    }
}
