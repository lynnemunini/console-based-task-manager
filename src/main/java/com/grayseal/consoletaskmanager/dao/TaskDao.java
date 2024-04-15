package com.grayseal.consoletaskmanager.dao;

import com.grayseal.consoletaskmanager.entities.Task;
import com.grayseal.consoletaskmanager.entities.User;
import jakarta.persistence.*;
import com.grayseal.consoletaskmanager.util.EntityManagerFactoryUtil;

import java.util.List;


public class TaskDao {

    /**
     * The EntityManagerFactory instance used to create EntityManager instances.
     */
    private final EntityManagerFactory entityManagerFactory;


    public TaskDao() {
        entityManagerFactory = EntityManagerFactoryUtil.getEntityManagerFactory();
    }

    /**
     * Creates a new task entity in the database.
     *
     * @param task the task entity to be created
     */
    public boolean createTask(Task task) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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


    public List<Task> getAllTasks(User user) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            String jpql = "SELECT t FROM Task t WHERE t.user = :user";
            Query query = entityManager.createQuery(jpql, Task.class);
            query.setParameter("user", user);
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
    public boolean updateTask(Task task) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.merge(task);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes a task entity from the database based on the specified task ID.
     *
     * @param taskId the ID of the task to delete
     */
    public boolean deleteTask(Long taskId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Task task = entityManager.find(Task.class, taskId);
            if (task != null) {
                EntityTransaction transaction = entityManager.getTransaction();
                try {
                    transaction.begin();
                    entityManager.remove(task);
                    transaction.commit();
                    return true;
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
        return false;
    }
}