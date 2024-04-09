package service;

import dao.UserDao;
import entities.User;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    public boolean authenticateUser(String email, String password) {
        User user = userDao.getUserByEmailAndPassword(email, password);
        return user != null;
    }
}
