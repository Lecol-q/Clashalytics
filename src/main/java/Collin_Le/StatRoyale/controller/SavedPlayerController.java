package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.service.SavedPlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavedPlayerController {
    SavedPlayerService savedPlayerService;

    public SavedPlayerController(SavedPlayerService savedPlayerService) {
        this.savedPlayerService = savedPlayerService;
    }

    @CrossOrigin(
            origins = "http://localhost:5173",
            allowCredentials = "true"
    )
    @PostMapping("/save-player")
    public ResponseEntity<Void> savedPlayer(@RequestParam String tag, @RequestParam Users user) {
        if(!savedPlayerService.savePlayer(tag)) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(
            origins = "http://localhost:5173",
            allowCredentials = "true"
    )
    @PostMapping("/delete-player")
    public void deletePlayer(@RequestParam String tag, @RequestParam Users user) {
        savedPlayerService.deleteSavedPlayer(tag);
    }
}
