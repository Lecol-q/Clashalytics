package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.service.API;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    private final API api;
    public Player player;

    public PlayerController(API api) {
        this.api = api;
    }

    @GetMapping("/stats")
    public String getPlayer(@RequestParam String tag) {
        player = api.requestPlayerStats(tag);

        return player.displayPlayerStats();
    }
}
