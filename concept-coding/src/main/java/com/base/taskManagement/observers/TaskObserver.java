package com.base.taskManagement.observers;

import com.base.taskManagement.models.Task;

public interface TaskObserver {
    void update(String changeType,Task task);
}


