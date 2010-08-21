package org.slough4j.factory;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * Provides the implementation of ILoggerFactory bound to the SLF4J API.
 *
 * @author pmorie
 */
public class LoggerFactoryImpl implements ILoggerFactory {
    @Override
    public Logger getLogger(String name) {
        return null;
    }
}
