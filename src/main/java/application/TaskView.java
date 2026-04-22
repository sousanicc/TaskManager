package application;

import entities.Task;

import java.util.ArrayList;
import java.util.Objects;
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

    protected String catchDecision(){
        System.out.print("Select an option: ");
        return scanner.nextLine();
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
        String input;
        int index;
        boolean valid;
        do {
            System.out.println("Which task do you want to mark as complete? ");
            input = scanner.nextLine();
            valid = true;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
                valid = false;
                index = 0;
            }
        } while (!valid);
        return index - 1;
    }

    protected int uncompleteTask(){
        String input;
        int index;
        boolean valid;
        do {
            System.out.println("Which task do you want to mark as uncompleted? ");
            input = scanner.nextLine();
            valid = true;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
                valid = false;
                index = 0;
            }
        } while (!valid);
        return index - 1;
    }

    protected int removeTask(){
        String input;
        int index;
        boolean valid;
        do {
            System.out.println("Which task do you want to remove? ");
            input = scanner.nextLine();
            valid = true;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number.");
                valid = false;
                index = 0;
            }
        } while (!valid);
        return index - 1;
    }

    protected boolean isUrgent(){
        System.out.println("Is this task urgent? (y/n): ");
        String answer;
        do {
            answer = scanner.nextLine().toLowerCase();
            if (isOptionValid(answer, "y", "n")){
                System.out.println("Invalid option.");
            }
        }while (isOptionValid(String.valueOf(answer), "y", "n"));
        return answer.equals("y");
    }

    protected boolean isOptionValid(String answer, String expected1, String expected2){
        return !Objects.equals(answer, expected2) && !Objects.equals(answer, expected1);
    }

}