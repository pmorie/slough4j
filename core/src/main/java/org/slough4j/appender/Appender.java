package org.slough4j.appender;

import org.slough4j.model.LogMessage;

import java.util.List;
import java.util.Map;

/**
 * Describes an appender.  Extensions providing implementations of this interface are expected
 * to supply usable no-args constructors. 
 *
 * @author pmorie
 */
public interface Appender {
    boolean initialize(Map<String, String> properties);

    void append(LogMessage message);

    void append(List<LogMessage> messages);

    void flush();
}
