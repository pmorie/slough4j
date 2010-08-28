package org.slough4j;

import org.slf4j.ILoggerFactory;
import org.slough4j.configuration.ConfigKeys;
import org.slough4j.configuration.Configuration;
import org.slough4j.factory.LoggerFactoryImpl;
import org.slough4j.dispatch.Dispatcher;
import org.slough4j.level.LevelStore;
import org.slough4j.level.MapBackedLevelStore;
import org.slough4j.model.Level;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Bootstraps Slough4J and creates an instance of ILoggerFactory to bind to the API.
 *
 * @author pmorie
 */
public final class Slough4JBootstrapper {
    private static final String DEFAULT_PROPERTIES = "/slough4j.properties";
    private static final String CONFIGURATION_PROPERTY_KEY = "slough4j.configuration";

    public ILoggerFactory configureSlough4J() {
        Properties properties = loadProperties();
        Configuration conf = createConfiguration(properties);

        return configureSlough4J(conf);
    }

    protected Properties loadProperties() {
        String conf = System.getProperty(CONFIGURATION_PROPERTY_KEY);

        if ((conf == null) || ("".equals(conf))) {
            conf = DEFAULT_PROPERTIES;
        }

        return loadProperties(conf);
    }

    protected Properties loadProperties(String conf) {
        InputStream stream = this.getClass().getResourceAsStream(conf);
        Properties properties = new Properties();
        boolean loadError = false;

        try {
            properties.load(stream);
        } catch (IOException e) {
            loadError = true;
            System.out.println("Couldn't load configuration file from classpath: " + conf);
        }

        return (loadError) ? new Properties() : properties;
    }

    protected Configuration createConfiguration(Properties properties) {
        String appenderType = properties.getProperty(ConfigKeys.APPENDER_TYPE);
        String sDefaultLevel = properties.getProperty(ConfigKeys.DEFAULT_LEVEL);
        Level defaultLevel = Level.valueOf(sDefaultLevel);

        Map<String, Level> levelMap = new HashMap<String, Level>();
        Level temp;

        for (String p : properties.stringPropertyNames()) {
            if (p.startsWith(ConfigKeys.LEVEL_MARKER)) {
                try {
                    temp = Level.valueOf(properties.getProperty(p));
                    levelMap.put(p, temp);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ignoring level configuration for " + p + " - Invalid Level");
                }
            }
        }

        return new Configuration(appenderType, defaultLevel, levelMap);
    }

    protected ILoggerFactory configureSlough4J(Configuration config) {
        LevelStore levelStore = createLevelStore(config);
        Dispatcher dispatcher = createDispatcher();

        return new LoggerFactoryImpl(levelStore, dispatcher);
    }

    protected LevelStore createLevelStore(Configuration config) {
        return new MapBackedLevelStore(config.getLevelMap(), config.getDefaultLevel());
    }

    protected Dispatcher createDispatcher() {
        return null;
    }
}