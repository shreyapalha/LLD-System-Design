package com.base.taskManagement.observers;

import com.base.taskManagement.models.Task;

public class ActivityObserver implements TaskObserver{

    public ActivityObserver(){

    }
    @Override
    public void update(String changeType, Task task) {
        //do some update
    }
}
