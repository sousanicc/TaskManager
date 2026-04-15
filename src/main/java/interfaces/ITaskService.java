package interfaces;

import entities.Task;

import java.util.ArrayList;

public interface ITaskService {

    void addTask(String description);

    void addUrgentTask(String description);

    ArrayList<Task> listTasks();

    void completed(int index, boolean aux);

    void removeTask(int index);

}