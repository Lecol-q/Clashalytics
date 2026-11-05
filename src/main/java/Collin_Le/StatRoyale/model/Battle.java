package Collin_Le.StatRoyale.model;

public class Battle {
    String type;
    String battleTime;
    GameMode gameMode;
    Team team;
    Opponent opponent;

    // constructor
    public Battle(String type, String battleTime, GameMode gameMode, Team team, Opponent opponent) {
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
    public Team getTeam() { return team; }
    public Opponent getOpponent() {return opponent; }

    // setters
    public void setType(String type) { this.type = type; }
    public void setBattleTime(String battleTime) { this.battleTime = battleTime; }
    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }
    public void setTeam(Team team) { this.team = team; }
    public void setOpponent(Opponent opponent) { this.opponent = opponent; }
}
