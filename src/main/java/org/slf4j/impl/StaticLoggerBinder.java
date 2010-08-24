package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slough4j.bootstrap.Slough4JBootstrapper;
import org.slough4j.factory.LoggerFactoryImpl;

/**
 * Provides binding to the SLF4J API at run-time.
 *
 * @author pmorie
 */
public class StaticLoggerBinder {
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    /**
     * Provides a method used by the SLF4J API.
     */
    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    /**
     * Declare the version of the SLF4J API this implementation is compiled against.
     * The value of this field is usually modified with each release.
     */
    // to avoid constant folding by the compiler, this field must *not* be final
    public static String REQUESTED_API_VERSION = "1.6.1";  // !final

    private final ILoggerFactory factory;
    private final String factoryClassName = LoggerFactoryImpl.class.getName();

    private StaticLoggerBinder() {
        factory = new Slough4JBootstrapper().configureSlough4J();
    }

    public ILoggerFactory getLoggerFactory() {
        return factory;
    }

    public String getLoggerFactoryClassStr() {
        return factoryClassName;
    }
}
