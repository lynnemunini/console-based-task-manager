import entities.User;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        createUserAndGrantAccess(userService);
    }

    public static void createUserAndGrantAccess(UserService userService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Create the user
        User newUser = new User();
        newUser.setEmail(username);
        newUser.setPassword(password);
        userService.createUser(newUser);

        // Authenticate the user
        if (userService.authenticateUser(username, password)) {
            System.out.println("User created successfully. Access granted to the task manager.");
            // Proceed to access the console-based task manager
            // Implement your task manager logic here
        } else {
            System.out.println("User creation failed. Authentication error.");
            // Handle authentication failure (e.g., inform the user and exit)
        }
    }
}
