package dao;

import entities.Task;
import jakarta.persistence.*;

import java.util.List;

/**
 * Provides data access methods for managing task entities
 */
public class TaskDao {

    /**
     * The EntityManagerFactory instance used to create EntityManager instances.
     */
    private final EntityManagerFactory entityManagerFactory;

    /**
     * Constructs a new TaskDao instance.
     * Initializes the EntityManagerFactory using the persistence unit named "task-manager-persistence-unit".
     */
    public TaskDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit");
    }

    /**
     * Creates a new task entity in the database.
     *
     * @param task the task entity to be created
     */
    public void createTask(Task task) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a task entity from the database based on the specified task ID.
     *
     * @param taskId the ID of the task to retrieve
     * @return the task entity corresponding to the specified ID, or null if not found
     */
    public Task getTaskById(Long taskId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Task.class, taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves all task entities from the database.
     *
     * @return a list of all task entities in the database, or null if an error occurs
     */
    public List<Task> getAllTasks() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            String jpql = "SELECT t FROM Task t";
            Query query = entityManager.createQuery(jpql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates an existing task entity in the database.
     *
     * @param task the task entity to be updated
     */
    public void updateTask(Task task) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.merge(task);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a task entity from the database based on the specified task ID.
     *
     * @param taskId the ID of the task to delete
     */
    public void deleteTask(Long taskId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Task task = entityManager.find(Task.class, taskId);
            if (task != null) {
                EntityTransaction transaction = entityManager.getTransaction();
                try {
                    transaction.begin();
                    entityManager.remove(task);
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction.isActive()) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}