package com.base.logging.entities;

import com.base.logging.enums.LogLevel;
import java.time.LocalDateTime;

public final class LogMessage {
    private final String message;
    private final LocalDateTime timestamp;
    private final LogLevel logLevel;
    private final String loggerName;
    private final String threadName;

    public LogMessage(String message, LogLevel logLevel, String loggerName) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.logLevel = logLevel;
        this.loggerName = loggerName;
        this.threadName = Thread.currentThread().getName();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getThreadName() {
        return threadName;
    }
}
