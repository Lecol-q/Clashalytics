package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.UserResponse;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) { this.userService = userService; }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/register")
    public ResponseEntity<Void> createNewUser(@RequestParam String username, @RequestParam String password) {
        if(!userService.createUser(username, password)) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestParam String username, @RequestParam String password) {
        Users user = userService.loginUser(username, password);
        if(user == null) {
            return ResponseEntity.status(401).build();
        }
        UserResponse userResponse = new UserResponse(user.getId(), user.getUsername());
        return ResponseEntity.ok(userResponse);
    }
}
