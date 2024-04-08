package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDao {
    private final EntityManagerFactory entityManagerFactory;

    public UserDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit");
    }

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

    public User getUserById(Long userId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
