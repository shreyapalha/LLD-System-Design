package com.base.taskManagement.states;

import com.base.taskManagement.enums.TaskStatus;
import com.base.taskManagement.models.Task;

public class InProgressState implements TaskState{

    @Override
    public void startProgress(Task task) {
        //alreday in progress
    }

    @Override
    public void completeTask(Task task) {
        task.setTaskState(new CompletedState());
    }

    @Override
    public void reopenTask(Task task) {
        task.setTaskState(new ToDoState());
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.IN_PROGRESS;
    }
}
