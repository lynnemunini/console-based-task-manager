package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Provides data access methods for managing user entities
 */
public class UserDao {

    /**
     * The EntityManagerFactory instance used to create EntityManager instances.
     */
    private final EntityManagerFactory entityManagerFactory;

    /**
     * Constructs a new UserDao instance.
     * Initializes the EntityManagerFactory using the persistence unit named "task-manager-persistence-unit".
     */
    public UserDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit");
    }

    /**
     * Creates a new user entity in the database.
     *
     * @param user the user entity to be created
     */
    public void createUser(User user) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a user entity from the database based on the specified user ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the user entity corresponding to the specified ID, or null if not found
     */
    public User getUserById(Long userId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes a user entity from the database based on the specified user ID.
     *
     * @param userId the ID of the user to delete
     */
    public void deleteUser(Long userId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            User user = entityManager.find(User.class, userId);
            if (user != null) {
                EntityTransaction transaction = entityManager.getTransaction();
                try {
                    transaction.begin();
                    entityManager.remove(user);
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