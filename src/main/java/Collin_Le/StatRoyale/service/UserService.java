package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.config.SecurityConfig;
import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    Users users;
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(String username, String password) {
        Users users = new Users(username, password);
        passwordEncoder.encode(password);
        userRepository.save(users);
    }

    public Users loginUser(String username, String password) {
        Optional<Users> foundUser = userRepository.findByUsername(username);

        if(foundUser.isPresent() && Objects.equals(foundUser.get().getPassword(), password)) {
            return foundUser.get();
        }
        return null;
    }
}
