package com.base.logging.stretegy;

import com.base.logging.entities.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public interface LogAppender {
    void append(LogMessage logMessage);
    LogFormatter getLogFormatter();
    void setLogFormatter(LogFormatter logFormatter);

    void close();
}

class ConsoleLogAppender implements LogAppender{

    private LogFormatter logFormatter;

    public ConsoleLogAppender(){
        this.logFormatter=new SimpleTextFormatter();
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logFormatter.format(logMessage));
    }

    @Override
    public LogFormatter getLogFormatter() {
        return logFormatter;
    }

    @Override
    public void setLogFormatter(LogFormatter logFormatter) {
        this.logFormatter=logFormatter;
    }

    @Override
    public void close() {

    }
}

class FileLogAppender implements LogAppender{
    private FileWriter writer;

    private LogFormatter logFormatter;

    public FileLogAppender(String filePath){
        this.logFormatter = new SimpleTextFormatter();
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            writer.write(logFormatter.format(logMessage) + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }

    @Override
    public void setLogFormatter(LogFormatter formatter) {
        this.logFormatter = formatter;
    }

    @Override
    public void close() {

    }

    @Override
    public LogFormatter getLogFormatter() {
        return logFormatter;
    }
}