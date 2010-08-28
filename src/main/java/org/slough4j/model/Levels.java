package org.slough4j.model;

/**
 * Utility methods for working with Levels.
 *
 * @author pmorie
 */
public final class Levels {
    private Levels() {}

    public static boolean isTraceEnabled(Level test) {
        return isLevelEnabled(test, Level.TRACE);
    }

    public static boolean isDebugEnabled(Level test) {
        return isLevelEnabled(test, Level.DEBUG);
    }

    public static boolean isInfoEnabled(Level test) {
        return isLevelEnabled(test, Level.INFO);
    }

    public static boolean isWarnEnabled(Level test) {
        return isLevelEnabled(test, Level.WARN);
    }

    public static boolean isErrorEnabled(Level test) {
        return isLevelEnabled(test, Level.ERROR);
    }

    public static boolean isLevelEnabled(Level effectiveLevel, Level test) {
        if ((effectiveLevel == null) || (test == null)) {
            return false;
        }

        return (effectiveLevel.ordinal() >= test.ordinal());
    }
}
