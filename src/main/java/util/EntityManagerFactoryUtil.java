package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit");

    private EntityManagerFactoryUtil() {
        // Private constructor to prevent instantiation
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
