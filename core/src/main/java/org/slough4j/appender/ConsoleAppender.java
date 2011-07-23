package org.slough4j.appender;

import org.slough4j.model.LogMessage;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class ConsoleAppender implements Appender {
    private final PrintStream out;

    public ConsoleAppender(PrintStream out) {
        this.out = out;
    }

    public boolean initialize(Map<String, String> properties) {
        return true;
    }

    @Override
    public void append(LogMessage message) {
        try {
            out.write(format(message).getBytes());
        } catch (IOException e) {
            // TODO: handle in meaningful way
        }
    }

    @Override
    public void append(List<LogMessage> messages) {
        for (LogMessage message : messages) {
            append(message);
        }
    }

    protected String format(LogMessage message) {
        return new Date(message.getTimestamp()) + ": "
                      + message.getLevel()
                      + " [" + message.getThreadName() + "] "
                      + message.getLoggerName() + " "
                      + message.getMessage()
                      + "\n";
    }

    @Override
    public void flush() {
        out.flush();
    }
}
