import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private static ArrayList tasks = new ArrayList(); // ❌ Non-generic ArrayList (Type Safety Issue)
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt(); // ❌ No input validation (May cause exceptions)

            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                viewTasks();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                System.exit(0); // ❌ System.exit() is bad practice in applications
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.next(); // ❌ Using `next()` instead of `nextLine()` may cause input issues
        tasks.add(task);
        System.out.println("Task added.");
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ": " + tasks.get(i));
            }
        }
    }
}