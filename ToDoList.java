import java.util.ArrayList;
import java.util.Scanner;


public class ToD {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nTo-Do List App");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
    }

    static void viewTasks() {
        System.out.println("Your Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void editTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to edit: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // consume newline
            if (index >= 0 && index < tasks.size()) {
                System.out.print("Enter new task: ");
                String newTask = scanner.nextLine();
                tasks.set(index, newTask);
                System.out.println("Task updated!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // consume newline
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task deleted!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}