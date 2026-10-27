package Collin_Le.StatRoyale.repository;

import Collin_Le.StatRoyale.model.SavedPlayer;
import Collin_Le.StatRoyale.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

public interface SavedPlayersRepository extends CrudRepository<SavedPlayer, Long> {
    List<SavedPlayer> findByUsers(Users users);

    Optional<SavedPlayer> findBySavedTagAndUsers(String savedTag, Users users);
}
