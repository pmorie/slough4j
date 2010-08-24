package org.slough4j.bootstrap;

import org.slf4j.ILoggerFactory;
import org.slough4j.factory.LoggerFactoryImpl;
import org.slough4j.internals.dispatch.Dispatcher;
import org.slough4j.internals.level.LevelStore;

/**
 * Bootstraps Slough4J and creates an instance of ILoggerFactory to bind to the API.
 *
 * @author pmorie
 */
public final class Slough4JBootstrapper {
    public ILoggerFactory configureSlough4J() {
        LevelStore levelStore = createLevelStore();
        Dispatcher dispatcher = createDispatcher();

        return new LoggerFactoryImpl(levelStore, dispatcher);
    }

    protected LevelStore createLevelStore() {
        return null;
    }

    protected Dispatcher createDispatcher() {
        return null;
    }
}
