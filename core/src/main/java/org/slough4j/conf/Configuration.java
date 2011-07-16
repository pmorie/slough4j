package org.slough4j.conf;

import org.slough4j.model.Level;

import java.util.Map;

/**
 * Slough4J configuration.
 */
public class Configuration {
    private final boolean verbose;
    private final Level defaultLevel;
    private final Map<String, Level> levelMap;
    private final Map<String, String> properties;

    public Configuration(boolean verbose, Level defaultLevel, Map<String, Level> levelMap, Map<String, String> properties) {
        this.verbose = verbose;
        this.defaultLevel = defaultLevel;
        this.levelMap = levelMap;
        this.properties = properties;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public Level getDefaultLevel() {
        return defaultLevel;
    }

    public Map<String, Level> getLevelMap() {
        return levelMap;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
