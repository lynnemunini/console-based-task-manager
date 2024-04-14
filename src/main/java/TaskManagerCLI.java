import entities.User;
import service.UserService;

import java.util.Scanner;

import static util.TextUtils.isValidEmail;

public class TaskManagerCLI {
    private final UserService userService;

    public TaskManagerCLI() {
        this.userService = new UserService();
    }

    public void start() {
        displayWelcomeMessage();
        while (true) {
            var result = signInOrSignUp(userService);
            if (result == 0) {
                displayMainMenu();
                break;
            } else if (result == -1) {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println(" ,--.--------.   _,.---._                           _,.---._     ");
        System.out.println("/==/,  -   , -\\,-.' , -  `.           _,..---._   ,-.' , -  `.   ");
        System.out.println("\\==\\.-.  - ,-./==/_,  ,  - \\        /==/,   -  \\ /==/_,  ,  - \\  ");
        System.out.println(" `--`\\==\\- \\ |==|   .=.     |       |==|   _   _\\==|   .=.     | ");
        System.out.println("      \\==\\_ \\|==|_ : ;=:  - |       |==|  .=.   |==|_ : ;=:  - | ");
        System.out.println("      |==|- ||==| , '='     |       |==|,|   | -|==| , '='     | ");
        System.out.println("      |==|, | \\==\\ -    ,_ /        |==|  '='   /\\==\\ -    ,_ /  ");
        System.out.println("      /==/ -/  '.='. -   .'         |==|-,   _`/  '.='. -   .'   ");
        System.out.println("      `--`--`    `--`--''           `-.`.____.'     `--`--''      ");
        System.out.println();
        System.out.println("Welcome to Task Manager!");
        System.out.println();

    }

    private static int signInOrSignUp(UserService userService) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println();
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                return signIn(userService) ? 0 : 1;
            case 2:
                return signUp(userService) ? 0 : 1;
            case 3:
                return -1;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
        return 1;
    }

    private static boolean signIn(UserService userService) {
        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.println("|            Sign In              |");
        System.out.println("+---------------------------------+");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isValidEmail(email));

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Incorrect email or password.");
        }
        return isAuthenticated;
    }

    private static boolean signUp(UserService userService) {
        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.println("|            Sign Up              |");
        System.out.println("+---------------------------------+");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isValidEmail(email));

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        if (userService.getUserByEmail(email) != null) {
            System.out.println("User with this email already exists. Please sign in instead.");
            return false;
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);

        userService.createUser(newUser);
        System.out.println("User created successfully!");
        return true;
    }


    private void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Create Task");
        System.out.println("2. View Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

}
