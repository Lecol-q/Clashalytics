package Collin_Le.StatRoyale.service;

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

@Service
public class SavedPlayerService {
    SavedPlayersRepository savedPlayersRepository;
    UserRepository userRepository;
    AuthenticationManager authenticationManager;

    SavedPlayerService(SavedPlayersRepository savedPlayersRepository, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.savedPlayersRepository = savedPlayersRepository;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public SavedPlayer savePlayer(String tag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        SavedPlayer savedPlayer = new SavedPlayer(tag, user);
        return savedPlayersRepository.save(savedPlayer);
    }

    public void deleteSavedPlayer(String tag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        SavedPlayer savedPlayer = savedPlayersRepository.findBySavedTagAndUsers(tag, user).orElseThrow();
        savedPlayersRepository.deleteById(savedPlayer.getId());
    }


}
