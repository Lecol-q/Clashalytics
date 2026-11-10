package Collin_Le.StatRoyale.model;

import java.util.List;

public class Player {
    // general information
    private String tag;
    private String name;
    private int trophies;
    private int battleCount;
    private int wins;
    private int losses;
    private Clan clan;
    private List<Card> currentDeck;
    private int expLevel;
    private int kingTowerLevel;
    private List<DeckPerformance> deckPerformances;
    private BattleLog battleLog;

    // no argument constructor
    public Player(){}

    // parameterized constructor
    public Player(String name, String tag, int trophies, int battleCount,
                  int wins, int losses, List<Card> currentDeck, int expLevel,
                  int kingTowerLevel, List<DeckPerformance> deckPerformances, BattleLog battleLog) {
        this.name = name;
        this.tag = tag;
        this.trophies = trophies;
        this.battleCount = battleCount;
        this.wins = wins;
        this.losses = losses;
        this.currentDeck = currentDeck;
        this.expLevel = expLevel;
        this.kingTowerLevel = kingTowerLevel;
        this.deckPerformances = deckPerformances;
        this.battleLog = battleLog;

    }

    // Player section
    public String displayPlayerStats() {
        System.out.println("Name: " + name + "\nTag: " + tag + "\nTrophies: " + trophies);
        System.out.println("*Battle stats*");
        System.out.println("Wins: " + wins + "\nLosses: " + losses);
        System.out.println("Current deck" + currentDeck);
        System.out.println("Clan: " + clan.getName());
        System.out.println("Level: " + expLevel);
        System.out.println("King Level: " + kingTowerLevel);

        return "Name: " + name + "\nTrophies: " + trophies + "Clan: " + clan + "\nWins: " + wins + "\nLosses: " + losses;
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
    public int getExpLevel() { return expLevel; }
    public int getKingTowerLevel() { return kingTowerLevel; }

    public String getWinrate() {
        double winrate = (double) wins / battleCount * 100;
        // formatting  for winrate ("Winrate: %.0f%" + "%\n", winrate);
        return String.format("%.0f%%", winrate);
    }

    public Clan getClan() {
        return clan;
    }

    public List<DeckPerformance> getDeckPerformances() { return deckPerformances; }
    public BattleLog getBattleLog() { return battleLog; }

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

    public void setCurrentDeck(List<Card> currentDeck) { this.currentDeck = currentDeck; }

    public List<Card> getCurrentDeck() { return currentDeck; }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public void setExpLevel(int expLevel) { this.expLevel = expLevel; }
    public void setKingTowerLevel(int kingTowerLevel) { this.kingTowerLevel = kingTowerLevel; }

    public void setDeckPerformances(List<DeckPerformance> deckPerformances) {
        this.deckPerformances = deckPerformances;
    }

    public void setBattleLog(BattleLog battleLog) {
        this.battleLog = battleLog;
    }
}
