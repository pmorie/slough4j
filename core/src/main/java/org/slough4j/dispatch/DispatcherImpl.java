package org.slough4j.dispatch;

import org.slough4j.appender.Appender;
import org.slough4j.display.Console;
import org.slough4j.model.LogMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DispatcherImpl implements Dispatcher {
    private final BlockingQueue<LogMessage> queue;
    private final ExecutorService executor;
    private final Appender appender;

    private volatile LogMessage active;

    public DispatcherImpl(BlockingQueue<LogMessage> queue, Appender appender) {
        this(queue, appender, Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "Slough4J Dispatcher Thread");
                thread.setDaemon(true);

                return thread;
            }
        }));
    }

    public DispatcherImpl(BlockingQueue<LogMessage> queue, Appender appender, ExecutorService executor) {
        this.queue = queue;
        this.appender = appender;
        this.executor = executor;
    }

    @Override
    public void dispatch(LogMessage message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            // TODO: handle in meaningful way
        }

        scheduleNext();
    }

    public void scheduleNext() {
        active = queue.poll();

        if (active != null) {
            if (queue.size() > 0) {
                schedule(retrieveMessages(active));
            } else {
                schedule(active);
            }
        }
    }

    protected void schedule(final LogMessage message) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    appender.append(message);
                } finally {
                    scheduleNext();
                }
            }
        });
    }

    protected List<LogMessage> retrieveMessages(LogMessage message) {
        int size = queue.size();

        List<LogMessage> messages = new ArrayList<LogMessage>(size +1);

        messages.add(message);

        queue.drainTo(messages);

        return messages;
    }

    protected void schedule(final List<LogMessage> messages) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    appender.append(messages);
                } finally {
                    scheduleNext();
                }
            }
        });
    }
}
