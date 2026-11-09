package Collin_Le.StatRoyale.model;

import java.util.HashMap;
import java.util.List;

public class DeckPerformance {
    List<Card> deck;
    int numOfBattle;
    int wins;
    int draws;
    int loses;
    int teamCrowns;
    int opponentCrowns;

    public DeckPerformance() {}

    public DeckPerformance(List<Card> deck, int numOfBattle, int wins, int draws, int loses) {
        this.deck = deck;
        this.numOfBattle = numOfBattle;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
    }

    // getters
    public List<Card> getDeck() {
        return deck;
    }

    public int getNumOfBattle() {
        return numOfBattle;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    public int getTeamCrowns() {
        return teamCrowns;
    }

    public int getOpponentCrowns() {
        return opponentCrowns;
    }

    // setters
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void setNumOfBattle(int numOfBattle) {
        this.numOfBattle = numOfBattle;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setTeamCrowns(int teamCrowns) {
        this.teamCrowns = teamCrowns;
    }

    public void setOpponentCrowns(int opponentCrowns) {
        this.opponentCrowns = opponentCrowns;
    }

    // custom methods
    public void updatePerformance(int win, int draw, int lost) {
        this.numOfBattle++;
        this.wins += win;
        this.draws += draw;
        this.loses += lost;
    }
}
