package Collin_Le.StatRoyale;

import java.util.List;

public class ChestList {
    Chest chest;
    public List<Chest> items;

    public ChestList(){}

    public ChestList(List<Chest> items){
        this.items = items;
    }

    public void getUpcomingChests() {
        for(int i = 0; i < 5; i++){
            chest = items.get(i);
            chest.displayUpcomingChest();
        }
    }
}
