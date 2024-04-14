import entities.User;
import service.UserService;

import java.util.Scanner;

import static util.TaskManagerUtils.isValidEmail;

public class TaskManagerCLI {
    private final UserService userService;
    private User currentUser;

    public TaskManagerCLI() {
        this.userService = new UserService();
    }

    public void start() {
        displayWelcomeMessage();
        if (signInOrSignUp(userService)) {
            displayMainMenu();
        } else {
            System.out.println("Exiting Task Manager. Goodbye!");
        }
    }

    private void setCurrentUser(User user) {
        this.currentUser = user;
    }

    private User getCurrentUser() {
        return this.currentUser;
    }

    private static void displayWelcomeMessage() {
        System.out.println(" ,---------.    ____       .-'''-. .--.   .--.          .---.  .---.   ___    _  _______    ");
        System.out.println("\\          \\ .'  __ `.   / _     \\|  | _/  /           |   |  |_ _| .'   |  | |\\  ____  \\  ");
        System.out.println(" `--.  ,---'/   '  \\  \\ (`' )/`--'| (`' ) /            |   |  ( ' ) |   .'  | || |    \\ |  ");
        System.out.println("    |   \\   |___|  /  |(_ o _).   |(_ ()_)             |   '-(_{;}}_).'  '_  | || |____/ /  ");
        System.out.println("    :_ _:      _.-`   | (_,_). '. | (_,_)   __         |      (_,_) '   ( \\.-.||   _ _ '.  ");
        System.out.println("    (_I_)   .'   _    |.---.  \\  :|  |\\ \\  |  |        | _ _--.   | ' (`. _` /||  ( ' )  \\ ");
        System.out.println("   (_(=)_)  |  _( )_  |\\    `-'  ||  | \\ `'   /        |( ' ) |   | | (_ (_) _)| (_{;}_) | ");
        System.out.println("    (_I_)   \\ (_ o _) / \\       / |  |  \\    /         (_{;}_)|   |  \\ /  . \\ /|  (_,_)  / ");
        System.out.println("    '---'    '.(_,_).'   `-...-'  `--'   `'-'          '(_,_) '---'   ``-'`-'' /_______.'  ");
        System.out.println("                                                                                          ");
        System.out.println();
        System.out.println("Welcome to Task Manager!");

    }

    private boolean signInOrSignUp(UserService userService) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            System.out.println();
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Please enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    if (signIn(userService)) return true;
                    break;
                case 2:
                    if (signUp(userService)) return true;
                    break;
                case 3:
                    return false;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private boolean signIn(UserService userService) {
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
            setCurrentUser(userService.getUserByEmail(email));
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed. Incorrect email or password.");
        }
        return isAuthenticated;
    }

    private boolean signUp(UserService userService) {
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
        setCurrentUser(newUser);

        userService.createUser(newUser);
        System.out.println("User created successfully!");
        return true;
    }


    private void displayMainMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            getMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    // Create task
                    System.out.println("Create a task");
                    break;
                case 2:
                    // View Tasks
                    System.out.println("View tasks");
                    break;
                case 3:
                    // Update Task
                    System.out.println("Update a task");
                    break;
                case 4:
                    // Delete Task
                    System.out.println("Delete a task");
                    break;
                case 5:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        }
    }

    public static void getMenu() {
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Create Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Please enter your choice: ");
    }
}
