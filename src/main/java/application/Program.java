package application;

import entities.Task;
import exceptions.EmptyListException;
import exceptions.InvalidDescription;
import exceptions.InvalidIndexException;
import interfaces.ITaskService;
import services.TaskService;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    static void main(){

        Scanner scanner = new Scanner(System.in);

        ITaskService service = new TaskService();
        TaskView taskView = new TaskView();

        int decision;

        do {

            taskView.showMenu();
            decision = taskView.catchDecision();

            switch (decision) {
                case 1:
                    try {
                        String description = taskView.addTask();
                        boolean answer = taskView.isUrgent();
                        if(answer){
                            service.addUrgentTask(description);
                        } else {
                            service.addTask(description);
                        }
                    }
                    catch (InvalidDescription i){
                        System.out.println(i.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<Task> list = service.listTasks();
                        taskView.listTasks(list);
                    }
                    catch (EmptyListException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int index = taskView.completeTask();
                        service.completed(index, true);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        int index = taskView.uncompleteTask();
                        service.completed(index, false);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        int index = taskView.removeTask();
                        service.removeTask(index);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("This option is not available. Try again.");
                    break;
            }
        }while(decision!=0);
        scanner.close();
    }
}