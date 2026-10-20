package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.model.Users;
import Collin_Le.StatRoyale.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    Users users;
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password) {
        Users users = new Users(username, password);
        userRepository.save(users);
    }

    public boolean loginUser(String username, String password) {
        Optional<Users> foundUser = userRepository.findByUsername(username);

        return foundUser.isPresent() && Objects.equals(foundUser.get().getPassword(), password);
    }
}
