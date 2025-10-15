package com.base.logging;

import com.base.logging.stretegy.LogAppender;

import java.util.HashMap;
import java.util.Map;

public class LogManager {
    private static final LogManager INSTANCE=new LogManager();
    private final Map<String,Logger> loggers=new HashMap<>();
    private final Logger rootLogger;
    private final AsyncLogProcessor processor;

    public LogManager(){
        rootLogger=new Logger("root",null);
        loggers.put("root",rootLogger);
        processor=new AsyncLogProcessor();
    }


    public static LogManager getInstance() {
        return INSTANCE;
    }

    public Map<String, Logger> getLoggers() {
        return loggers;
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, this::createLogger);
    }

    private Logger createLogger(String name) {
        if (name.equals("root")) {
            return rootLogger;
        }
        int lastDot = name.lastIndexOf('.');
        String parentName = (lastDot == -1) ? "root" : name.substring(0, lastDot);
        Logger parent = getLogger(parentName);
        return new Logger(name, parent);
    }

    public void shutdown() {
        // Stop the processor first to ensure all logs are written.
        processor.stop();

        // Then, close all appenders.
        loggers.values().stream()
                .flatMap(logger -> logger.getAppenders().stream())
                .distinct()
                .forEach(LogAppender::close);
        System.out.println("Logging framework shut down gracefully.");
    }

    public Logger getRootLogger() {
        return rootLogger;
    }

    public AsyncLogProcessor getProcessor() {
        return processor;
    }
}
