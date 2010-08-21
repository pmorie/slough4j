package org.slough4j;

import org.slf4j.ILoggerFactory;
import org.slough4j.factory.LoggerFactoryImpl;

/**
 * Bootstraps Slough4J and creates an instance of ILoggerFactory to bind to the API.
 *
 * @author pmorie
 */
public final class Slough4JBootstrapper {
    public static ILoggerFactory configureSlough4J() {
        return new LoggerFactoryImpl();
    }
}
