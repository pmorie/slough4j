package org.slough4j.model;

/**
 * Describes a log message.
 *
 * @author pmorie
 */
public class LogMessage {
    private final long timestamp;
    private final String loggerName;
    private final String threadName;
    private final Level level;
    private final String message;
    private final Throwable throwable;

    public LogMessage(long timestamp, String loggerName, String threadName, Level level, String message, Throwable throwable) {
        this.timestamp = timestamp;
        this.loggerName = loggerName;
        this.threadName = threadName;
        this.level = level;
        this.message = message;
        this.throwable = throwable;
    }

    public LogMessage(String loggerName, String threadName, Level level, String message, Throwable throwable) {
        this(System.currentTimeMillis(), loggerName, threadName, level, message, throwable);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
