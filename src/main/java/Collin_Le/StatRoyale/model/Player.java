package Collin_Le.StatRoyale.model;

public class Player {
    // general information
    private String tag;
    private String name;
    private int trophies;
    private int battleCount;
    private int wins;
    private int losses;

    // no argument constructor
    public Player(){}

    // parameterized constructor
    public Player(String name, String tag, int trophies, int battleCount, int wins, int losses) {
        this.name = name;
        this.tag = tag;
        this.trophies = trophies;
        this.battleCount = battleCount;
        this.wins = wins;
        this.losses = losses;
    }

    // Player section
    public String displayPlayerStats() {
        System.out.println("Name: " + name + "\nTag: " + tag + "\nTrophies: " + trophies);
        System.out.println("*Battle stats*");
        System.out.println("Wins: " + wins + "\nLosses: " + losses);

        return "Name: " + name + "\nTrophies: " + trophies + "\nWins: " + wins + "\nLosses: " + losses;
    }

    // getters
    public String getName(){
        return name;
    }

    public String getTag(){
        return tag;
    }

    public int getTrophies(){
        return trophies;
    }

    public int getBattleCount() {
        return battleCount;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getWinrate() {
        double winrate = (double) wins / battleCount * 100;
        // formatting  for winrate ("Winrate: %.0f%" + "%\n", winrate);
        return String.format("%.0f%%", winrate);
    }

    // setter
    public void setName(){
        this.name = name;
    }

    public void setTag(){
        this.tag = tag;
    }

    public void setTrophies(int Trophies){
        this.trophies = trophies;
    }


}
