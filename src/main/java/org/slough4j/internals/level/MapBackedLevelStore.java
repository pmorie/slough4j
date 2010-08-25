package org.slough4j.internals.level;

import org.slough4j.model.Level;

import java.util.Map;

/**
 * A level store backed by a Map.
 *
 * @author pmorie
 */
public class MapBackedLevelStore implements LevelStore {
    private final Map<String, Level> levelMap;
    private final Level defaultLevel;

    public MapBackedLevelStore(Map<String, Level> levelMap, Level defaultLevel) {
        if (levelMap == null) {
            throw new IllegalArgumentException("levelMap cannot be null");
        }

        if (defaultLevel == null) {
            throw new IllegalArgumentException("defaultLevel cannot be null");
        }

        this.levelMap = levelMap;
        this.defaultLevel = defaultLevel;
    }

    @Override
    public Level findLevel(String loggerName) {
        Level level = levelMap.get(loggerName);

        if (level == null) {
            return defaultLevel;
        }

        return level;
    }
}
