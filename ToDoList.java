import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void editTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void printTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Task\n2. Edit Task\n3. Delete Task\n4. View Tasks\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter index of task to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new task: ");
                    String newTask = scanner.nextLine();
                    editTask(editIndex - 1, newTask);
                    break;
                case 3:
                    System.out.print("Enter index of task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    deleteTask(deleteIndex - 1);
                    break;
                case 4:
                    printTasks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        System.out.println("Exiting...");
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.run();
    }
}