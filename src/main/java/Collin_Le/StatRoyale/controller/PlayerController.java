package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.BattleLog;
import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.service.API;
import Collin_Le.StatRoyale.service.DeckPerformanceService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private final API api;
    private final DeckPerformanceService dpService;

    public PlayerController(API api, DeckPerformanceService dpService) {
        this.api = api;
        this.dpService = dpService;
    }

    @CrossOrigin(origins = {"https://clashalytics.onrender.com", "http://localhost:5173/"})
    @GetMapping("/stats")
    public Player getPlayer(@RequestParam String tag) {
        Player player = api.requestPlayerStats(tag);
        return player;
    }

    @CrossOrigin(origins = {"https://clashalytics.onrender.com", "http://localhost:5173/"})
    @GetMapping("/battlelog")
    public BattleLog getBattleLog(@RequestParam String tag) {
        BattleLog battleLog = api.requestBattleLog(tag);
        battleLog.displayBattleLog();
        return battleLog;
    }
}
