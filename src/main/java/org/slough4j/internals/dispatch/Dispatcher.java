package org.slough4j.internals.dispatch;

import org.slough4j.model.LogMessage;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public interface Dispatcher {
    void dispatch(LogMessage message);
}
