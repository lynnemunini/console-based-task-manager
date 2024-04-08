package dao;

import entities.Task;
import jakarta.persistence.*;

import java.util.List;

public class TaskDao {
    private final EntityManagerFactory entityManagerFactory;

    public TaskDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit");
    }

    public void createTask(Task task) {
        try (
                EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(Long taskId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.find(Task.class, taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> getAllTasks() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            String jpql = "SELECT t FROM TASK t";
            Query query = entityManager.createQuery(jpql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
