package Collin_Le.StatRoyale.model;

import java.util.List;

public class BattleLog {
    List<Battle> battleLog;

    public BattleLog() {}

    public BattleLog(List<Battle> battleLog) {
        this.battleLog = battleLog;
    }

    public String displayBattleLog() {
        return "Battle Log: " + battleLog;
    }

    public List<Battle> getBattleLog() { return battleLog; }

    public void setBattleLog(List<Battle> battleLog) { this.battleLog = battleLog; }
}
