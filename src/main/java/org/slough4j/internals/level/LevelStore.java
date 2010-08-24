package org.slough4j.internals.level;

import org.slough4j.model.Level;

/**
 * Describes a data store that associates a Level with a logger name.
 *
 * @author pmorie
 */
public interface LevelStore {
    Level findLevel(String loggerName);
}
