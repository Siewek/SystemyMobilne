package com.example.zad6again;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private  static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    private TaskStorage()
    {
        tasks = new ArrayList<>();
        for(int i = 0; i <= 100; i++) {
            Task task = new Task();
            task.setName("Zadanie #"+i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public Task getTask(UUID taskId)
    {
        for(int i = 0; i < tasks.size(); i++)
        {
            Task task = tasks.get(i);
            if(task.getId().equals(taskId))
                return task;
        }

        return tasks.get(4);
    }

    public static TaskStorage getInstance() {
        return taskStorage;
    }
    public void addTask(Task task)
    {
        tasks.add(task);
    }
    public int getSize()
    {
        return tasks.size();
    }
}
