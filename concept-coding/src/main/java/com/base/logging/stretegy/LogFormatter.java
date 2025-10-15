package com.base.logging.stretegy;

import com.base.logging.entities.LogMessage;
import java.time.format.DateTimeFormatter;

public interface LogFormatter {
    String format(LogMessage logMessage);
}

class SimpleTextFormatter implements LogFormatter{

    private static final DateTimeFormatter DATE_TIME_FORMATTER=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s [%s] %s - %s: %s\n",
                logMessage.getTimestamp().format(DATE_TIME_FORMATTER),
                logMessage.getThreadName(),
                logMessage.getLogLevel(),
                logMessage.getLoggerName(),
                logMessage.getMessage());
    }
}
