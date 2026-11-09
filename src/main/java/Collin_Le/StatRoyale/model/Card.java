package Collin_Le.StatRoyale.model;

import javax.swing.*;

public class Card {
    private int id;
    private String name;
    private Integer elixirCost;
    private String rarity;
    private IconUrls iconUrls;

    // Empty constructor
    public Card(){}

    public Card(int id, String name, Integer elixirCost, String rarity, IconUrls iconUrls){
        this.id = id;
        this.name = name;
        this.elixirCost = elixirCost;
        this.rarity = rarity;
        this.iconUrls = iconUrls;
    }

    public void displayCardStats() {
        System.out.println("Card Name: " + name + "\nElixir Cost: " + elixirCost + "\nRarity: " + rarity);
    }

    // getters
    public Integer getId() { return id; }

    public String getName(){
        return name;
    }

    public Integer getElixirCost(){
        return elixirCost;
    }

    public String getRarity(){
        return rarity;
    }

    // setters
    public void setId(int id) { this.id = id; }
    public void setName(String name){
        this.name = name;
    }

    public void setElixirCost(int elixirCost){
        this.elixirCost = elixirCost;
    }

    public void setRarity(String rarity){
        this.rarity = rarity;
    }

    public String toString(){
        return name + " : " + elixirCost + " : " + rarity;
    }

    public void setIconUrls(IconUrls iconUrls) { this.iconUrls = iconUrls; }

    public IconUrls getIconUrls() { return iconUrls; }

    public String cardToString() {
        return iconUrls.getMedium();
    }
}
