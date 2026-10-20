package Collin_Le.StatRoyale.model;

public class UserResponse {
    Long id;
    String username;

    public UserResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}
