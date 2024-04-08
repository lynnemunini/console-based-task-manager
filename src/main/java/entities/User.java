package entities;

import jakarta.persistence.*;

/**
 * Represents a user in the Task Manager application.
 * Each user has a unique identifier, username, and password.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password of the user (hashed for security).
     */
    private String password;

    /**
     * Constructs a new user with the specified identifier, username, and password.
     *
     * @param id       the unique identifier of the user
     * @param username the username of the user
     * @param password the password of the user (hashed for security)
     */
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public User() {
        // Default constructor required by JPA
    }

    /**
     * Returns the unique identifier of the user.
     *
     * @return the user identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the user identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username of the user.
     *
     * @return the user username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the user username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return the user password (hashed for security)
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the user password (hashed for security)
     */
    public void setPassword(String password) {
        this.password = password;
    }
}