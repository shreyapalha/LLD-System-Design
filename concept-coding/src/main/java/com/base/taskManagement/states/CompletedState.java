package com.base.taskManagement.states;

import com.base.taskManagement.enums.TaskStatus;
import com.base.taskManagement.models.Task;

public class CompletedState implements TaskState{

    @Override
    public void startProgress(Task task) {
       //already completed
    }

    @Override
    public void completeTask(Task task) {
        //already completed
    }

    @Override
    public void reopenTask(Task task) {
        task.setTaskState(new ToDoState());
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.COMPLETED;
    }
}
