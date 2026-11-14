package Collin_Le.StatRoyale.model;

import java.util.List;

public class Leaderboard {
    List<Items> items;

    public Leaderboard() {}

    public Leaderboard(List<Items> items) {
        this.items = items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void displayGlobalPlayers() {
        if(items.isEmpty() || items == null) {
            System.out.println("Error with global leaderboard: " + items);
            return;
        }

        for(Items item : items) {
            System.out.println(item);
            System.out.println(item.getName());
            System.out.println(item.getRank());
        }
    }
}
