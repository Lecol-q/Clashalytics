package Collin_Le.StatRoyale.model;

public class Card {
    private String name;
    private int elixirCost;
    private String rarity;
    private String medium;

    // Empty constructor
    public Card(){}

    public Card(String name, int elixirCost, String rarity, String medium){
        this.name = name;
        this.elixirCost = elixirCost;
        this.rarity = rarity;
        this.medium = medium;
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

    public String toString(){
        return name + " : " + elixirCost + " : " + rarity;
    }

    public void setMedium(String medium) { this.medium = medium; }

    public String getMedium() { return medium; }
}
