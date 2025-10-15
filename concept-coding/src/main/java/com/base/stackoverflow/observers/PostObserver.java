package com.base.stackoverflow.observers;

import com.base.stackoverflow.models.Event;

public interface PostObserver {
    public void onPostEvent(Event event);
}
