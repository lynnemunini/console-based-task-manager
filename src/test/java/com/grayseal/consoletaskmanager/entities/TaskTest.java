package com.grayseal.consoletaskmanager.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Test Task", "Test Description", new Date(), "Pending", new Date());
    }

    @Test
    public void testGetId() {
        assertEquals(0, task.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        String title = "New Title";
        task.setTitle(title);
        assertEquals(title, task.getTitle());
    }

    @Test
    public void testSetAndGetDescription() {
        String description = "New Description";
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    public void testSetAndGetDueDate() {
        Date dueDate = new Date();
        task.setDueDate(dueDate);
        assertEquals(dueDate, task.getDueDate());
    }

    @Test
    public void testSetAndGetStatus() {
        String status = "Completed";
        task.setStatus(status);
        assertEquals(status, task.getStatus());
    }

    @Test
    public void testSetAndGetCreatedAt() {
        Date createdAt = new Date();
        task.setCreatedAt(createdAt);
        assertEquals(createdAt, task.getCreatedAt());
    }

    @Test
    public void testSetAndGetUser() {
        User user = new User();
        task.setUser(user);
        assertEquals(user, task.getUser());
    }
}