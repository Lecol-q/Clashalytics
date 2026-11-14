package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.BattleLog;
import Collin_Le.StatRoyale.model.Leaderboard;
import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.service.API;
import Collin_Le.StatRoyale.service.DeckPerformanceService;
import Collin_Le.StatRoyale.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private final PlayerService playerService;
    private final API api;

    public PlayerController(PlayerService playerService, API api) {
        this.playerService = playerService;
        this.api = api;
    }

    @CrossOrigin(origins = {"https://clashalytics.onrender.com", "http://localhost:5173/"})
    @GetMapping("/stats")
    public Player getPlayer(@RequestParam String tag) {
        return playerService.retrievePlayer(tag);
    }

    @CrossOrigin(origins = {"https://clashalytics.onrender.com", "http://localhost:5173/"})
    @GetMapping("/topthree")
    public Leaderboard getTopThree() {
        return api.requestTopThreeGlobalPlayers();
    }
}
