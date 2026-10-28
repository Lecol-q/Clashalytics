package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.SavedPlayer;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.repository.SavedPlayersRepository;
import Collin_Le.StatRoyale.repository.UserRepository;
import Collin_Le.StatRoyale.service.SavedPlayerService;
import Collin_Le.StatRoyale.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SavedPlayerController {
    private final UserRepository userRepository;
    private final SavedPlayersRepository savedPlayersRepository;
    private final UserService userService;
    SavedPlayerService savedPlayerService;

    public SavedPlayerController(SavedPlayerService savedPlayerService, UserRepository userRepository, SavedPlayersRepository savedPlayersRepository, UserService userService) {
        this.savedPlayerService = savedPlayerService;
        this.userRepository = userRepository;
        this.savedPlayersRepository = savedPlayersRepository;
        this.userService = userService;
    }

    @CrossOrigin(
            origins = "http://https://clashalytics.netlify.app/",
            allowCredentials = "true"
    )
    @PostMapping("/save-player")
    public ResponseEntity<Void> savedPlayer(@RequestParam String tag) {
        if(!savedPlayerService.savePlayer(tag)) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(
            origins = "http://https://clashalytics.netlify.app/",
            allowCredentials = "true"
    )
    @PostMapping("/remove-player")
    public ResponseEntity<Void> deletePlayer(@RequestParam String tag) {
        savedPlayerService.deleteSavedPlayer(tag);
        return ResponseEntity.status(204).build();
    }

    @CrossOrigin(
            origins = "http://https://clashalytics.netlify.app/",
            allowCredentials = "true"
    )
    @GetMapping("/retrieve-saved-players")
    public List<SavedPlayer> getSavedPlayers() {
        return savedPlayerService.getSavedPlayers();
    }
}
