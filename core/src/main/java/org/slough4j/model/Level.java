package org.slough4j.model;

/**
 * Enum for logger level.  Ordinal ordering is important and indicates priority of levels.
 * The level OFF is used to indicate that logging opps should be no-ops.
 *
 * @author pmorie
 */
public enum Level {
    OFF,
    ERROR,
    WARN,
    INFO,
    DEBUG,
    TRACE
}
