package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.service.API;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private final API api;
    public Player player;

    public PlayerController(API api) {
        this.api = api;
    }

    @CrossOrigin(origins = "https://clashalytics.onrender.com")
    @GetMapping("/stats")
    public Player getPlayer(@RequestParam String tag) {
        player = api.requestPlayerStats(tag);

        return player;
    }
}
