package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) { this.userService = userService; }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/user")
    public void createNewUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestParam String username, @RequestParam String password) {
        Users user = userService.loginUser(username, password);
        if(user == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(user);
    }
}
