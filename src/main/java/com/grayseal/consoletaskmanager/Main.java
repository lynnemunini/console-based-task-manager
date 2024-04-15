package com.grayseal.consoletaskmanager;

public class Main {
    public static void main(String[] args) {
        System.setProperty("org.jboss.logging.provider", "slf4j");
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI();
        taskManagerCLI.start();
    }
}
