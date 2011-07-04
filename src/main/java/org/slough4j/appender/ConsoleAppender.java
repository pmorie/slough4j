package org.slough4j.appender;

import org.slough4j.model.LogMessage;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

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

    @Override
    public void append(LogMessage message) {
        try {
            out.write(format(message).getBytes());
        } catch (IOException e) {
            // TODO: handle in meaningful way
        }
    }

    protected String format(LogMessage message) {
        return new Date(message.getTimestamp()) + ": "
                      + message.getLevel()
                      + " [" + message.getThreadName() + "]"
                      + message.getLoggerName()
                      + message.getMessage()
                      + "\n";
    }

    @Override
    public void flush() {
        out.flush();
    }
}
