package entities;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a task in the Task Manager.
 * Each task has an identifier, title, description, due date, status, and creation date.
 */
@Entity
@Table(name = "tasks")
public class Task {

    /**
     * The unique identifier of the task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Date dueDate;

    /**
     * The status of the task (e.g., "Pending", "In Progress", "Completed").
     */
    private String status;
    /**
     * The timestamp when the task was created.
     */

    @Column(name = "created_at")
    private Date createdAt;

    /**
     * The user associated with the task.
     */
    @ManyToOne(fetch = FetchType.LAZY) // Lazy fetch to optimize performance
    @JoinColumn(name = "user_id")
    private User user;


    public Task() {
        // Default constructor required by JPA
    }

    /**
     * Constructs a new task with the specified title, description, due date, status, and creation date.
     *
     * @param title       the title or name of the task
     * @param description additional details or description about the task
     * @param dueDate     the due date or deadline for completing the task
     * @param status      the status of the task
     * @param createdAt   the timestamp when the task was created
     */
    public Task(String title, String description, Date dueDate, String status, Date createdAt) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.createdAt = createdAt;
    }


    /**
     * Returns the unique identifier of the task.
     *
     * @return the task identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the task.
     *
     * @param id the task identifier
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the title or name of the task.
     *
     * @return the task title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title or name of the task.
     *
     * @param title the task title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the additional details or description about the task.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the additional details or description about the task.
     *
     * @param description the task description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the due date or deadline for completing the task.
     *
     * @return the task due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date or deadline for completing the task.
     *
     * @param dueDate the task due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns the status of the task.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     *
     * @param status the task status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the timestamp when the task was created.
     *
     * @return the task creation timestamp
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when the task was created.
     *
     * @param createdAt the task creation timestamp
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
