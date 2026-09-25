package Collin_Le.StatRoyale;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Items {
    Card card;
    public List<Card> items;

    public Items(){}
    public Items(List<Card> items) {
        this.items = items;
    }

    public void getCards(){
        for (Card item : items) {
            card = item;
            card.displayCardStats();
            System.out.println();
        }
    }
}
