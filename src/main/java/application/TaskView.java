package application;

import entities.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskView {

    Scanner scanner = new Scanner(System.in);

    protected void showMenu(){
        System.out.println();
        System.out.println("====================================");
        System.out.println("        TASK MANAGER             ");
        System.out.println("====================================");
        System.out.println(" 1  - Add Task");
        System.out.println(" 2  - List Tasks");
        System.out.println(" 3  - Complete Task");
        System.out.println(" 4  - Uncomplete Task");
        System.out.println(" 5  - Remove Task");
        System.out.println(" 0  - Exit");
        System.out.println("====================================");
    }

    protected int catchDecision(){
        System.out.print("Select an option: ");
        int decision = scanner.nextInt();
        scanner.nextLine();
        return decision;
    }

    protected String addTask(){
        String description;
        System.out.println("Enter the description: ");
        description = scanner.nextLine();
        return description;
    }

    protected void listTasks(ArrayList<Task> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println( i+1 + " - " + list.get(i));
        }
    }

    protected int completeTask(){
        System.out.println("Which task do you want to mark as complete? ");
        int index = scanner.nextInt();
        index--;
        return index;
    }

    protected int uncompleteTask(){
        System.out.println("Which task do you want to mark as unfinished? ");
        int index = scanner.nextInt();
        index--;
        return index;
    }

    protected int removeTask(){
        System.out.println("Which task do you want to remove? ");
        int index = scanner.nextInt();
        index--;
        return index;
    }

    protected boolean isUrgent(){
        System.out.println("Is this task urgent? (y/n): ");
        char answer = scanner.nextLine().charAt(0);
        return answer == 'y';
    }

}