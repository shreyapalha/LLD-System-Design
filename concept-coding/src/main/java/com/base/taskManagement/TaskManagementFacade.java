package com.base.taskManagement;

import com.base.pubsub.subscriber.Subscriber;
import com.base.taskManagement.enums.TaskPriority;
import com.base.taskManagement.models.Tag;
import com.base.taskManagement.models.Task;
import com.base.taskManagement.models.TaskList;
import com.base.taskManagement.models.User;
import com.base.taskManagement.observers.ActivityObserver;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManagementFacade {
    private static TaskManagementFacade INSTANCE;
    private final Map<String, User> users;
    private final Map<String, Task> tasks;
    private final Map<String, TaskList> taskLists;

    private TaskManagementFacade(){
        users=new ConcurrentHashMap<>();
        tasks=new ConcurrentHashMap<>();
        taskLists=new HashMap<>();
    }

    public TaskManagementFacade getInstance(){
        if(INSTANCE==null){
            return new TaskManagementFacade();
        }
        return INSTANCE;
    }

    public User createUser(String name,String email){
        User user=new User(name,email);
        users.put(name,user);
        return user;
    }

    public TaskList createTaskList(String listName) {
        TaskList taskList = new TaskList(listName);
        taskLists.put(taskList.getId(), taskList);
        return taskList;
    }

    public Task createTask(String title, String description, LocalDate dueDate,
                           TaskPriority priority, String createdByUserId) {
        User createdBy = users.get(createdByUserId);
        if (createdBy == null)
            throw new IllegalArgumentException("User not found.");

        Task task = new Task.TaskBuilder()
                .setTitle(title)
                .description(description)
                .dueDate(dueDate)
                .setTaskPriority(priority)
                .createdBy(createdBy)
                .build();

        task.addObserver(new ActivityObserver());

        tasks.put(task.getId(), task);
        return task;
    }



}
