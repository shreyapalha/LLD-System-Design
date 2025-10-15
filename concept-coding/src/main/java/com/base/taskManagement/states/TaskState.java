package com.base.taskManagement.states;

import com.base.taskManagement.enums.TaskStatus;
import com.base.taskManagement.models.Task;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}
