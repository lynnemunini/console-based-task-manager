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
    private String email;
    private String password;

    /**
     * Constructs a new user with the specified identifier, username, and password.
     *
     * @param id       the unique identifier of the user
     * @param email    the email of the user
     * @param password the password of the user (hashed for security)
     */
    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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