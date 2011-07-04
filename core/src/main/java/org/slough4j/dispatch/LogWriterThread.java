package org.slough4j.dispatch;

import org.slough4j.appender.Appender;
import org.slough4j.model.LogMessage;

import java.util.concurrent.BlockingQueue;

public class LogWriterThread extends Thread {
    private final BlockingQueue<LogMessage> queue;
    private final Appender appender;

    public LogWriterThread(BlockingQueue<LogMessage> queue, Appender appender) {
        super("Slough4J Log Writer");
        this.queue = queue;
        this.appender = appender;
    }

    public void run() {
        try {
            while (true) {
                LogMessage message = queue.take();

                appender.append(message);
            }
        } catch (InterruptedException e) {
            System.out.println("Dispatcher thread was interrupted.");
        }
    }
}