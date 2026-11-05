package Collin_Le.StatRoyale.model;

import java.util.List;

public class Opponent {
    String name;
    String tag;
    int crowns;
    Clan clan;
    List<Card> cards;

    // constructors
    public Opponent() {}

    public Opponent(String name, String tag, int crowns, Clan clan, List<Card> cards) {
        this.name = name;
        this.tag = tag;
        this.crowns = crowns;
        this.clan = clan;
        this.cards = cards;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public int getCrowns() {
        return crowns;
    }

    public Clan getClan() {
        return clan;
    }

    public List<Card> getCards() {
        return cards;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCrowns(int crowns) {
        this.crowns = crowns;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setClan(Clan clan) {
        this.clan  = clan;
    }
}
