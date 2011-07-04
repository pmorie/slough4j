package org.slough4j.appender;

import org.slough4j.model.LogMessage;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public interface Appender {
    void append(LogMessage message);

    void flush();
}
