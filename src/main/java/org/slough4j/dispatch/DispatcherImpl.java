package org.slough4j.dispatch;

import org.slough4j.model.LogMessage;

import java.util.concurrent.BlockingQueue;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class DispatcherImpl implements Dispatcher {
    private final BlockingQueue<LogMessage> queue;

    public DispatcherImpl(BlockingQueue<LogMessage> queue) {
        this.queue = queue;
    }

    @Override
    public void dispatch(LogMessage message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            // TODO: handle in meaningful way
        }
    }
}
