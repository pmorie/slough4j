package org.slough4j.display;

import org.slough4j.model.LogMessage;

import java.util.Date;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public final class LogMessages {
    private LogMessages() {}

    public static byte[] format(LogMessage message) {
        StringBuilder b = new StringBuilder();

        b.append(new Date(message.getTimestamp())).append(": ")
         .append(message.getLevel())
         .append(" [").append(message.getThreadName()).append("] ")
         .append(message.getLoggerName())
         .append(" ")
         .append(message.getMessage()).append("\n");

        return b.toString().getBytes();
    }
}
