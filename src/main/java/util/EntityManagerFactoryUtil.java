package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.AvailableSettings;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> properties = new HashMap<>();
        properties.put(AvailableSettings.JAKARTA_JDBC_DRIVER, "org.sqlite.JDBC");
        properties.put(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:sqlite:taskmanager.db");
        properties.put(AvailableSettings.JAKARTA_JDBC_USER, "");
        properties.put(AvailableSettings.JAKARTA_JDBC_PASSWORD, "");
        properties.put(AvailableSettings.DIALECT, "org.hibernate.community.dialect.SQLiteDialect");
        // Update database schema if changes are detected, without dropping existing tables
        properties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        entityManagerFactory = Persistence.createEntityManagerFactory("task-manager-persistence-unit", properties);
    }

    private EntityManagerFactoryUtil() {
        // Private constructor to prevent instantiation
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}