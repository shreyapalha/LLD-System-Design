package com.base.taskManagement.models;

import com.base.taskManagement.enums.TaskPriority;
import com.base.taskManagement.enums.TaskStatus;
import com.base.taskManagement.observers.TaskObserver;
import com.base.taskManagement.states.TaskState;
import com.base.taskManagement.states.ToDoState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Task {
    private final String id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private TaskState taskState;
    private TaskPriority taskPriority;

    private LocalDate dueDate;
    private User assignee;
    private User createdBy;
    private final List<Comment> comments;
    private final Set<Tag> tags;
    private final List<Task> subtasks;

    private final List<TaskObserver> observers;

    public Task(TaskBuilder builder) {
        this.id = UUID.randomUUID().toString();
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.taskPriority = builder.taskPriority;
        this.createdBy = builder.createdBy;
        this.assignee = builder.assignee;
        this.tags = builder.tags;
        this.taskState = new ToDoState(); // Initial state
        this.comments = new ArrayList<>();
        this.subtasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    //observers
    public void addObserver(TaskObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer){
        observers.remove(observer);
    }

    public void notifyObserver(String changeType){
        for(TaskObserver taskObserver:observers){
            taskObserver.update(changeType,this);
        }
    }

    //state pattern
    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
        notifyObserver("State changed");
    }

    public void updateProgress(){
        taskState.startProgress(this);
    }
    public void completeTask(){
        taskState.completeTask(this);
    }
    public void reopenTask(){
        taskState.reopenTask(this);
    }

    public void updateTaskStatus(TaskStatus taskStatus){
        this.taskStatus=taskStatus;
        notifyObserver("Status Updated");
    }

    public void updateTaskPriority(TaskPriority taskPriority){
        this.taskPriority=taskPriority;
        notifyObserver("Priority updated");
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        notifyObserver("Comment Added");
    }

    public void addSubTask(Task subtask){
        subtasks.add(subtask);
        notifyObserver("Subtask added");
    }
    public void display(){
        System.out.println("name: "+this.title);
        if(!subtasks.isEmpty()){
            for(Task task:subtasks){
                task.display();
            }
        }
    }

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Comment> getComments() {
        return comments;
    }


    public TaskState getTaskState() {
        return taskState;
    }


    public static class TaskBuilder{
        private String title;
        private TaskPriority taskPriority;
        private LocalDate dueDate;
        private String description;
        private User assignee;
        private User createdBy;
        private Set<Tag> tags;

        public TaskBuilder setTitle(String title){
            this.title=title;
            return this;
        }
        public TaskBuilder setTaskPriority(TaskPriority taskPriority){
            this.taskPriority=taskPriority;
            return this;
        }
        public TaskBuilder description(String description) { this.description = description; return this; }
        public TaskBuilder dueDate(LocalDate dueDate) { this.dueDate = dueDate; return this; }
        public TaskBuilder assignee(User assignee) { this.assignee = assignee; return this; }
        public TaskBuilder createdBy(User createdBy) { this.createdBy = createdBy; return this; }
        public TaskBuilder tags(Set<Tag> tags) { this.tags = tags; return this; }


        public Task build(){
            return new Task(this);
        }

    }




}
