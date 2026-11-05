package Collin_Le.StatRoyale.model;

public class GameMode {
    int id;
    String name;

    public GameMode() {}

    public GameMode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
