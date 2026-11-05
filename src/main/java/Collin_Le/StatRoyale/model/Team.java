package Collin_Le.StatRoyale.model;

import java.util.List;

public class Team {
    String name;
    String tag;
    Integer trophyChange;
    int crowns;
    Clan clan;
    List<Card> cards;

    // constructors
    public Team() {}

    public Team(String name, String tag, Integer trophyChange, int crowns, Clan clan, List<Card> cards) {
        this.name = name;
        this.tag = tag;
        this.trophyChange = trophyChange;
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

    public Integer getTrophyChange() {
        return trophyChange;
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

    public void setTrophyChange(Integer trophyChange) {
        this.trophyChange = trophyChange;
    }

    public void setCrowns(int crowns) {
        this.crowns = crowns;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
