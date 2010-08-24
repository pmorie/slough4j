package org.slough4j.model;

/**
 * Describes a log message.
 *
 * @author pmorie
 */
public class LogMessage {
    private final long timestamp;
    private final String threadName;
    private final String message;
    private final Level level;

    public LogMessage(long timestamp, String threadName, String message, Level level) {
        this.timestamp = timestamp;
        this.threadName = threadName;
        this.message = message;
        this.level = level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getMessage() {
        return message;
    }

    public Level getLevel() {
        return level;
    }
}
