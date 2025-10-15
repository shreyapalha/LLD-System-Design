package com.base.logging;

import com.base.logging.entities.LogMessage;
import com.base.logging.stretegy.LogAppender;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncLogProcessor {
    private final ExecutorService executorService;

    public AsyncLogProcessor(){
        executorService= Executors.newSingleThreadExecutor(runnable->{
            Thread th=new Thread(runnable,"AsyncLogProcessor");
                    th.setDaemon(true);
                    return th;
        });
    }

    public void process(LogMessage logMessage, List<LogAppender> logAppenderList){
        if(executorService.isShutdown()){
            System.err.println("Logger is shut down. Cannot process log message.");
            return;
        }
        executorService.submit(()->{
            for(LogAppender logAppender:logAppenderList){
                logAppender.append(logMessage);
            }
        });
    }

    public void stop() {
        // Disable new tasks from being submitted
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                System.err.println("Logger executorService did not terminate in the specified time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
