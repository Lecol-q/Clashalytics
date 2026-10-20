package Collin_Le.StatRoyale.repository;

import Collin_Le.StatRoyale.model.Users;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
