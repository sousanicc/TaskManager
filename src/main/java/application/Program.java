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

        String decision;
        int isInitialized = 0;

        do {

            taskView.showMenu();
            decision = taskView.catchDecision();

            switch (decision) {
                //region case1
                case "1":
                    try {
                        String description = taskView.addTask();
                        boolean answer = taskView.isUrgent();
                        if(answer){
                            service.addUrgentTask(description);
                        } else {
                            service.addTask(description);
                        }
                        if (isInitialized==0){
                            isInitialized++;
                        }
                    }
                    catch (InvalidDescription i){
                        System.out.println(i.getMessage());
                    }
                    break;
                //endregion
                //region case2
                case "2":
                    try {
                        ArrayList<Task> list = service.listTasks();
                        taskView.listTasks(list);
                    }
                    catch (EmptyListException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //endregion
                //region case3
                case "3":
                    try {
                        service.listTasks();
                        ArrayList<Task> list = service.listTasks();
                        taskView.listTasks(list);
                        int index = taskView.completeTask();
                        service.completed(index, true);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //endregion
                //region case4
                case "4":
                    try {
                        service.listTasks();
                        ArrayList<Task> list = service.listTasks();
                        taskView.listTasks(list);
                        int index = taskView.uncompleteTask();
                        service.completed(index, false);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //endregion
                //region case5
                case "5":
                    try {
                        service.listTasks();
                        ArrayList<Task> list = service.listTasks();
                        taskView.listTasks(list);
                        int index = taskView.removeTask();
                        service.removeTask(index);
                    }
                    catch (EmptyListException | InvalidIndexException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //endregion
                //region case0
                case "0":
                    System.out.println("Leaving...");
                    break;
                //endregion
                //region default
                default:
                    System.out.println("This option is not available. Try again.");
                    break;
                //endregion
            }
        }while(!decision.equals("0"));
        scanner.close();
    }
}