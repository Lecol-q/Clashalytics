package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.model.Player;
import Collin_Le.StatRoyale.model.SavedPlayer;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.repository.SavedPlayersRepository;
import Collin_Le.StatRoyale.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedPlayerService {
    SavedPlayersRepository savedPlayersRepository;
    UserRepository userRepository;
    AuthenticationManager authenticationManager;
    API api;

    SavedPlayerService(SavedPlayersRepository savedPlayersRepository, UserRepository userRepository, AuthenticationManager authenticationManager, API api) {
        this.savedPlayersRepository = savedPlayersRepository;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.api = api;
    }

    public boolean savePlayer(String tag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(authentication.getName()).orElseThrow();

        if(savedPlayersRepository.findByUsers(user).size() >= 10 || savedPlayersRepository.findBySavedTagAndUsers(tag, user).isPresent()) {
            System.out.println("Player save limit reached or duplicate user");
            return false;
        }

        Player player = api.requestPlayerStats(tag);
        SavedPlayer savedPlayer = new SavedPlayer(tag, user, player.getName());
        savedPlayersRepository.save(savedPlayer);
        System.out.println("Saved");
        return true;
    }

    public void deleteSavedPlayer(String tag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        SavedPlayer savedPlayer = savedPlayersRepository.findBySavedTagAndUsers(tag, user).orElseThrow();
        savedPlayersRepository.deleteById(savedPlayer.getId());
    }

    public List<SavedPlayer> getSavedPlayers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        return savedPlayersRepository.findByUsers(user);
    }
}
