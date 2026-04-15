package services;

import entities.Task;
import entities.UrgentTask;
import exceptions.EmptyListException;
import exceptions.InvalidIndexException;
import interfaces.ITaskService;

import java.util.ArrayList;

public class TaskService implements ITaskService {

    private final ArrayList<Task> tasks = new ArrayList<>();

    //region constructors

    public TaskService() {
    }

    //endregion

    //region methods

    public void addTask(String description){
        Task newTask = new Task(description);
        tasks.add(newTask);
    }

    public void addUrgentTask(String description){
        UrgentTask newUrgentTask = new UrgentTask(description);
        tasks.addFirst(newUrgentTask);
    }

    public ArrayList<Task> listTasks(){
        if(tasks.isEmpty()){
            throw new EmptyListException("The list is empty");
        }
        return(new ArrayList<>(tasks));
    }

    public void completed(int index, boolean aux){
        if(tasks.isEmpty()){
            throw new EmptyListException("The list is empty");
        }
        if(!isIndexValid(index)){
            throw new InvalidIndexException("This index is invalid.");
        }
        tasks.get(index).setCompleted(aux);
    }

    public void removeTask(int index){
        if(tasks.isEmpty()){
            throw new EmptyListException("The list is empty");
        }
        if(!isIndexValid(index)){
            throw new InvalidIndexException("This index is invalid.");
        }
        tasks.remove(index);
    }

    //endregion

    //region auxiliar methods

    public boolean isIndexValid(int index){

        return index >= 0 && index < tasks.size();

    }

    //endregion

}