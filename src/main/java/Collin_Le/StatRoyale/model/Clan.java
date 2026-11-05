package Collin_Le.StatRoyale.model;

public class Clan {
    String tag;
    String name;
    int badgeId;

    // constructors
    public Clan() {}
    public Clan(String tag, String name, int badgeId) {
        this.tag = tag;
        this.name = name;
        this.badgeId = badgeId;
    }

    // getters
    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public int getBadgeId() {
        return badgeId;
    }

    // setters
    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

}
