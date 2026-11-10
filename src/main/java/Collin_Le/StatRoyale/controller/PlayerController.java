package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.BattleLog;
import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.service.API;
import Collin_Le.StatRoyale.service.DeckPerformanceService;
import Collin_Le.StatRoyale.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @CrossOrigin(origins = {"https://clashalytics.onrender.com", "http://localhost:5173/"})
    @GetMapping("/stats")
    public Player getPlayer(@RequestParam String tag) {
        return playerService.retrievePlayer(tag);
    }
}
