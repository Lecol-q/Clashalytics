package Collin_Le.StatRoyale.model;

import jakarta.persistence.*;

@Entity
@Table(name = "saved_players")
public class SavedPlayer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String savedTag;
    private String savedName;

    @ManyToOne (optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    // no args constructor
    public SavedPlayer() {}

    public SavedPlayer(String savedTag, Users users, String savedName) {
        this.savedTag = savedTag;
        this.users = users;
        this.savedName = savedName;
    }

    public void setId(Long id) { this.id = id; }

    public void setSavedTag(String savedTag) {
        this.savedTag = savedTag;
    }
    public void setSavedName(String savedName) { this.savedName = savedName; }

    public String getSavedTag() {
        return savedTag;
    }
    public String getSavedName() { return savedName; }

    public Long getId() { return id; }
}
