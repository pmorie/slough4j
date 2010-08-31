package org.slough4j.configuration;

import org.slough4j.model.Level;

import java.util.Map;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class Configuration {
    private final String appenderType;
    private final Level defaultLevel;
    private final Map<String, Level> levelMap;

    public Configuration(String appenderType, Level defaultLevel, Map<String, Level> levelMap) {
        this.appenderType = appenderType;
        this.defaultLevel = defaultLevel;
        this.levelMap = levelMap;
    }

    public String getAppenderType() {
        return appenderType;
    }

    public Level getDefaultLevel() {
        return defaultLevel;
    }

    public Map<String, Level> getLevelMap() {
        return levelMap;
    }
}
