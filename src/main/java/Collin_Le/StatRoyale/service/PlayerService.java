package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.model.BattleLog;
import Collin_Le.StatRoyale.model.DeckPerformance;
import Collin_Le.StatRoyale.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final API api;
    private final DeckPerformanceService dpService;

    public PlayerService(API api, DeckPerformanceService dpService) {
        this.api = api;
        this.dpService = dpService;
    }

    public Player retrievePlayer(String tag) {
        Player player = api.requestPlayerStats(tag);
        BattleLog battleLog = api.requestBattleLog(tag);
        player.setBattleLog(battleLog);
        player.setDeckPerformances(dpService.getDeckPerformance(battleLog));
        System.out.println(player.getDeckPerformances());

        return player;
    }
}
