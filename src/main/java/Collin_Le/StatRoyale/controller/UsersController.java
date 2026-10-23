package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.UserResponse;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UsersController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

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
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Users user = userService.lookUpUser(authentication.getName());
            UserResponse userResponse = new UserResponse(user.getId(), user.getUsername());
            return ResponseEntity.ok(userResponse);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
