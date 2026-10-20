package Collin_Le.StatRoyale.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // no args constructor
    public Users() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
