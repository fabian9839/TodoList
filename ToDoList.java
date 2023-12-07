import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    String description;
    boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name + ": " + description;
    }
}

public class ToDoList {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        while (true) {
            toDoList.menu();
        }
    }

    void menu() {
        System.out.println("-----------------------");
        System.out.println("  X   TO DO LIST   X  ");
        System.out.println("-----------------------");
        System.out.println("1. Add a new task");
        System.out.println("2. Mark a task as completed");
        System.out.println("3. Delete a task");
        System.out.println("4. Display the task list");
        System.out.println("5. Exit");
        System.out.println("-----------------------");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addTask();
                break;
            case 2:
                markAsCompleted();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                displayTaskList();
                break;
            case 5:
                exitProgram();
                break;
        }
    }

    void addTask() {
        System.out.println("-----------------------");
        System.out.println("Enter the task name:");
        String name = scanner.nextLine();
        System.out.println("Enter the task description:");
        String description = scanner.nextLine();

        Task newTask = new Task(name, description);
        tasks.add(newTask);
        System.out.println("Task \"" + name + "\" has been added to the list.");
        System.out.println("-----------------------");
    }

    void markAsCompleted() {
        System.out.println("Enter the task number to mark as completed:");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        if (isValidTaskIndex(taskIndex)) {
            Task task = tasks.get(taskIndex - 1);
            task.completed = true;
            System.out.println("Task \"" + task.name + "\" has been marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
        System.out.println("-----------------------");
    }

    void deleteTask() {
        System.out.println("Enter the task number to delete:");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        if (isValidTaskIndex(taskIndex)) {
            Task deletedTask = tasks.remove(taskIndex - 1);
            System.out.println("Task \"" + deletedTask.name + "\" has been successfully deleted from the list.");
        } else {
            System.out.println("Invalid task number.");
        }
        System.out.println("-----------------------");
    }

    void displayTaskList() {
        System.out.println("Task List:");

        if (tasks.isEmpty()) {
            System.out.println("No tasks to do!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println("-----------------------");
    }

    void exitProgram() {
        System.out.println("End of the program.");
        System.out.println("-----------------------");
        System.exit(0);
    }

    boolean isValidTaskIndex(int index) {
        return index >= 1 && index <= tasks.size();
    }
}