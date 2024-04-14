package service;

import dao.TaskDao;
import entities.Task;
import entities.User;

import java.util.List;

public class TaskService {
    private final TaskDao taskDao;

    public TaskService() {
        taskDao = new TaskDao();
    }

    public void createTask(Task task) {
        taskDao.createTask(task);
    }

    public Task getTaskById(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    public List<Task> getAllTasks(User user) {
        return taskDao.getAllTasks(user);
    }

    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }

    public void deleteTask(Long taskId) {
        taskDao.deleteTask(taskId);
    }
}
