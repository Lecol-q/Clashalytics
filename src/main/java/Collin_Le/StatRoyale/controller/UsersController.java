package Collin_Le.StatRoyale.controller;

import Collin_Le.StatRoyale.model.UserResponse;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

@RestController
public class UsersController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    public UsersController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin(
            origins = "https://clashalytics.netlify.app",
            allowCredentials = "true"
    )
    @PostMapping("/register")
    public ResponseEntity<Void> createNewUser(@RequestParam String username, @RequestParam String password) {
        if(!userService.createUser(username, password)) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(
            origins = "https://clashalytics.netlify.app",
            allowCredentials = "true"
    )
    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
            securityContextRepository.saveContext(context, request, response);
            Users user = userService.lookUpUser(authentication.getName());
            UserResponse userResponse = new UserResponse(user.getId(), user.getUsername());
            System.out.println(user.getUsername() + ": logged in");
            return ResponseEntity.ok(userResponse);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @CrossOrigin(
            origins = "https://clashalytics.netlify.app",
            allowCredentials = "true"
    )
    @GetMapping("/me")
    public ResponseEntity<UserResponse> persistLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() || authentication instanceof  AnonymousAuthenticationToken) {
            return ResponseEntity.status(401).build();
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.lookUpUser(username);

        return ResponseEntity.ok(new UserResponse(user.getId(), user.getUsername()));
    }
}
