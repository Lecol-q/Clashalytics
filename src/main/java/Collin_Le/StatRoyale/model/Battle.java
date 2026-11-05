package Collin_Le.StatRoyale.model;

import java.util.List;

public class Battle {
    String type;
    String battleTime;
    GameMode gameMode;
    List<Team> team;
    List<Opponent> opponent;

    // constructor
    public Battle(String type, String battleTime, GameMode gameMode, List<Team> team, List<Opponent> opponent) {
        this.type = type;
        this.battleTime = battleTime;
        this.gameMode = gameMode;
        this.team = team;
        this.opponent = opponent;
    }

    // getters
    public String getType() { return type; }
    public String getBattleTime() { return battleTime; }
    public GameMode getGameMode() { return gameMode; }
    public List<Team> getTeam() { return team; }
    public List<Opponent> getOpponent() {return opponent; }

    // setters
    public void setType(String type) { this.type = type; }
    public void setBattleTime(String battleTime) { this.battleTime = battleTime; }
    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }
    public void setTeam(List<Team> team) { this.team = team; }
    public void setOpponent(List<Opponent> opponent) { this.opponent = opponent; }
}
