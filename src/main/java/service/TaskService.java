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

    public boolean createTask(Task task) {
        return taskDao.createTask(task);
    }

    public Task getTaskById(Long taskId) {
        return taskDao.getTaskById(taskId);
    }

    public List<Task> getAllTasks(User user) {
        return taskDao.getAllTasks(user);
    }

    public boolean updateTask(Task task) {
        return taskDao.updateTask(task);
    }

    public boolean deleteTask(Long taskId) {
        return taskDao.deleteTask(taskId);
    }
}
