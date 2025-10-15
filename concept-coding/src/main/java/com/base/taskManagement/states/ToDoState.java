package com.base.taskManagement.states;

import com.base.taskManagement.enums.TaskStatus;
import com.base.taskManagement.models.Task;

public class ToDoState implements TaskState{

    @Override
    public void startProgress(Task task) {
        task.setTaskState(new InProgressState());
    }

    @Override
    public void completeTask(Task task) {
        //cannot be completed if not started
    }

    @Override
    public void reopenTask(Task task) {
        //already open
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.TO_DO;
    }
}
