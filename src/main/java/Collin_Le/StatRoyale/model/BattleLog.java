package Collin_Le.StatRoyale.model;

import java.util.List;

public class BattleLog {
    Battle battle;
    List<Battle> battleLog;

    public BattleLog() {}

    public BattleLog(List<Battle> battleLog) {
        this.battleLog = battleLog;
    }

    public String displayBattleLog() {

        System.out.println(battleLog);

        return "Battle Log: " + battleLog.toString();
    }

    public List<Battle> getBattleLog() { return battleLog; }

    public void setBattleLog(List<Battle> battleLog) { this.battleLog = battleLog; }
}
