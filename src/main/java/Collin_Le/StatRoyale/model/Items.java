
package Collin_Le.StatRoyale.model;

public class Items {
    private String tag;
    private String name;
    private int eloRating;
    private int rank;
    private Clan clan;

    public Items() {}

    public Items(String tag, String name, int eloRating, int rank, Clan clan) {
        this.tag = tag;
        this.name = name;
        this.eloRating = eloRating;
        this.rank = rank;
        this.clan = clan;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEloRating() {
        return eloRating;
    }

    public void setEloRating(int eloRating) {
        this.eloRating = eloRating;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
