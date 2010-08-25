package org.slough4j.internals.dispatch;

import org.slough4j.model.LogMessage;

/**
 * Specifies a startable component that can dispatch LogMessages for processing.
 *
 * @author pmorie
 */
public interface Dispatcher {
    void start();

    void dispatch(LogMessage message);
}
