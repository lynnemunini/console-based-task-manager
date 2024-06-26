# Console Based Task Manager

## Overview

Console TaskManager is a simple command-line application designed to help users manage their tasks efficiently. The
project is built using Java and utilizes Hibernate for database interaction.

## Features

- **User Authentication:** Users can sign in with their email and password or sign up for a new account.
- **Task Management:** Users can create tasks and view their existing tasks.
- **Persistence:** User and task data are stored in a SQLite database using Hibernate.

## Tools Used

- **Java:** The core programming language used for development.
- **Hibernate:** Object-relational mapping framework used for database interaction.
- **SQLite:** Lightweight relational database management system used to store user and task data.
- **Logback:** Logging framework used to log application events.
- **SLF4J:** Simple Logging Facade for Java used for logging abstraction.

## Installation

1. Clone the repository to your local machine.
2. Ensure you have Java Development Kit (JDK) installed.
3. Set up your IDE (e.g., IntelliJ IDEA, Eclipse) to work with Java projects.
4. Build the project using your IDE's build tools or by running `mvn clean install` from the command line.

## Usage

Run the application using the following command:

```bash
java -jar out/artifacts/console_based_task_manager_jar/console-based-task-manager.jar
```

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please feel free to open an
issue or submit a pull request.

## License

This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for details.
