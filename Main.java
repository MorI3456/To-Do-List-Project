import java.util.ArrayList;
import java.util.Scanner;

// Task class: Represents an individual task with a name and completion status.
class Task {
    private String name;
    private boolean isCompleted;

    // Constructor to create a task with a given name. By default, tasks are incomplete.
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    // Getter method to retrieve the task's name.
    public String getName() {
        return name;
    }

    // Getter method to check if the task is completed.
    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as completed by setting 'isCompleted' to true.
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Override the toString method to display the task's name and completion status.
    @Override
    public String toString() {
        return name + (isCompleted ? " (Completed)" : " (Pending)");
    }
}

// ToDoList class: Manages a list of tasks, providing methods to add, remove, mark tasks as complete, and display them.
class ToDoList {
    private ArrayList<Task> tasks;  // List to store Task objects.

    // Constructor initializes the 'tasks' list as an empty ArrayList.
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Method to add a task to the list by creating a new Task object.
    public void addTask(String taskName) {
        Task task = new Task(taskName);
        tasks.add(task);
    }

    // Method to remove a task from the list using its index.
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to mark a task as completed using its index.
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to display all tasks with their index, name, and completion status.
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i).toString());
        }
    }
}

// Main class: Provides the user interface for the to-do list.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to get user input.
        ToDoList todoList = new ToDoList();  // Create an instance of the ToDoList class.

        // Infinite loop to display the menu and allow user interaction.
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");

            // Prompt the user to enter their choice from the menu.
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();  // Get the user's choice as an integer.
            scanner.nextLine();  // Consume the newline character from pressing Enter.

            // Handle the user's choice using a switch statement.
            switch (choice) {
                case 1:
                    // If the user selects option 1, prompt them to enter a task name and add it to the list.
                    System.out.print("Enter the task name: ");
                    String taskName = scanner.nextLine();  // Get the task name as a string.
                    todoList.addTask(taskName);  // Add the task to the ToDoList.
                    break;
                case 2:
                    // If the user selects option 2, prompt them to enter the index of the task to remove.
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt();  // Get the index as an integer.
                    todoList.removeTask(removeIndex);  // Remove the task from the ToDoList.
                    break;
                case 3:
                    // If the user selects option 3, prompt them to enter the index of the task to mark as completed.
                    System.out.print("Enter the task number to complete: ");
                    int completeIndex = scanner.nextInt();  // Get the index as an integer.
                    todoList.completeTask(completeIndex);  // Mark the task as completed in the ToDoList.
                    break;
                case 4:
                    // If the user selects option 4, display the current list of tasks.
                    System.out.println("\nYour tasks:");
                    todoList.displayTasks();  // Display all tasks from the ToDoList.
                    break;
                case 5:
                    // If the user selects option 5, exit the program.
                    System.out.println("Exiting...");
                    return;  // Exit the program by returning from the main method.
                default:
                    // If the user enters an invalid option, display an error message.
                    System.out.println("Invalid choice.");
            }
        }
    }
}
