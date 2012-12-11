package org.slough4j.performance;

import org.slf4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class Harness {
    public static void puts(String msg) {
        System.out.println(msg);
    }

    public void main(String ... args) {
        if (args.length != 3) {
            puts("usage: Harness <number of loggers> <number of threads> <number of UOW>");
            System.exit(1);
        }

        int numberOfLoggers = Integer.parseInt(args[0]);
        int numberOfThreads = Integer.parseInt(args[1]);
        int numberOfUow = Integer.parseInt(args[2]);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        Logger[] loggers = makeLoggers(numberOfLoggers);
        UnitOfWork[] uows = makeUnitsOfWork(loggers, numberOfUow);

        long start = System.nanoTime();

        for (UnitOfWork uow : uows) {
            executor.submit(uow);
        }

        long stop = System.nanoTime();

        puts(String.format("Test Lasted: %dns", stop - start));
    }

    public static Logger[] makeLoggers(int numberOfLoggers) {
        return null;
    }

    public static UnitOfWork[] makeUnitsOfWork(Logger[] loggers, int numberOfUow) {
        UnitOfWork[] ret = new UnitOfWork[numberOfUow];

        for (int ii = 0; ii < numberOfUow; ii++) {
            ret[ii] = new UnitOfWork(loggers);
        }

        return ret;
    }

    public static class UnitOfWork implements Runnable {
        private Logger[] loggers;

        public UnitOfWork(Logger[] loggers) {
            if (loggers == null || loggers.length == 0) {
                throw new IllegalArgumentException("");
            }

            this.loggers = loggers;
        }

        public void run() {
            for (Logger logger : loggers) {
                logger.debug("Test Message");
            }
        }
    }
}
