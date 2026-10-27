package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(String username, String password) {

        if(userRepository.findByUsername(username).isPresent()) {
            System.out.println("Username same");
            return false;
        }

        Users users = new Users(username, passwordEncoder.encode(password));
        userRepository.save(users);
        System.out.println("Creation good");
        return true;
    }

    // handled by spring security probably sohuld refactor this
    public Users loginUser(String username, String password) {
        Optional<Users> foundUser = userRepository.findByUsername(username);

        if(foundUser.isPresent() && passwordEncoder.matches(password, foundUser.get().getPassword())) {
            System.out.println("Login good");
            return foundUser.get();
        }

        return null;
    }

    public String savePlayerTags(String tag) {


        return tag;
    }

    public Users lookUpUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Name no found"));
    }
}
