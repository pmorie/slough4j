package org.slough4j.logger;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slough4j.dispatch.Dispatcher;
import org.slough4j.model.Level;
import org.slough4j.model.Levels;
import org.slough4j.model.LogMessage;
import org.slough4j.util.MessageFormatting;

/**
 * Provides an implementation of {@link Logger}.
 *
 * @author pmorie
 */
public class LoggerImpl implements Logger {
    /**
     * Acts as a thread-local cache for the name of the current thread.  This is necessary because java.lang.Thread
     * stores the name of a thread as a char[].  Each call to Thread.getName() results in the construction of a new
     * java.lang.String, which is time-consuming.
     */
    private static final ThreadLocal<String> threadName = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    private final String name;
    private final Level effectiveLevel;
    private final Dispatcher dispatcher;

    public LoggerImpl(String name, Level effectiveLevel, Dispatcher dispatcher) {
        this.name = name;
        this.effectiveLevel = effectiveLevel;
        this.dispatcher = dispatcher;
    }

    public String getName() {
        return name;
    }

    protected void dispatch(Level level, String message) {
        if (!Levels.isLevelEnabled(effectiveLevel, level)) {
            return;
        }

        LogMessage logMessage = new LogMessage(name, threadName.get(), level, message, null);

        dispatcher.dispatch(logMessage);
    }

    protected void dispatch(Level level, String message, Object ... args) {
        if (!Levels.isLevelEnabled(effectiveLevel, level)) {
            return;
        }

        String formattedMessage = MessageFormatting.format(message, args);
        LogMessage logMessage = new LogMessage(name, threadName.get(), level, formattedMessage, null);

        dispatcher.dispatch(logMessage);
    }

    protected void dispatch(Level level, String message, Throwable t) {
        if (!Levels.isLevelEnabled(effectiveLevel, level)) {
            return;
        }

        LogMessage logMessage = new LogMessage(name, threadName.get(), level, message, t);
        dispatcher.dispatch(logMessage);
    }

    public boolean isTraceEnabled() {
        return Levels.isTraceEnabled(effectiveLevel);
    }

    public void trace(String s) {
        dispatch(Level.TRACE, s);
    }

    public void trace(String s, Object o) {
        dispatch(Level.TRACE, s, o);
    }

    public void trace(String s, Object o, Object o1) {
        dispatch(Level.TRACE, s, o, o1);
    }

    public void trace(String s, Object[] objects) {
        dispatch(Level.TRACE, s, objects);
    }

    public void trace(String s, Throwable t) {
        dispatch(Level.TRACE, s, t);
    }

    public boolean isTraceEnabled(Marker marker) {
        return Levels.isTraceEnabled(effectiveLevel);
    }

    public void trace(Marker marker, String s) {
        trace(s);
    }

    public void trace(Marker marker, String s, Object o) {
        trace(s, o);
    }

    public void trace(Marker marker, String s, Object o, Object o1) {
        trace(s, o, o1);
    }

    public void trace(Marker marker, String s, Object[] objects) {
        trace(s, objects);
    }

    public void trace(Marker marker, String s, Throwable t) {
        trace(s, t);
    }

    public boolean isDebugEnabled() {
        return Levels.isDebugEnabled(effectiveLevel);
    }

    public void debug(String s) {
        dispatch(Level.DEBUG, s);
    }

    public void debug(String s, Object o) {
        dispatch(Level.DEBUG, s, o);
    }

    public void debug(String s, Object o, Object o1) {
        dispatch(Level.DEBUG, s, o, o1);
    }

    public void debug(String s, Object[] objects) {
        dispatch(Level.DEBUG, s, objects);
    }

    public void debug(String s, Throwable t) {
        dispatch(Level.DEBUG, s, t);
    }

    public boolean isDebugEnabled(Marker marker) {
        return Levels.isDebugEnabled(effectiveLevel);
    }

    public void debug(Marker marker, String s) {
        debug(s);
    }

    public void debug(Marker marker, String s, Object o) {
        debug(s, o);
    }

    public void debug(Marker marker, String s, Object o, Object o1) {
        debug(s, o, o1);
    }

    public void debug(Marker marker, String s, Object[] objects) {
        debug(s, objects);
    }

    public void debug(Marker marker, String s, Throwable throwable) {
        debug(s, throwable);
    }

    public boolean isInfoEnabled() {
        return Levels.isInfoEnabled(effectiveLevel);
    }

    public void info(String s) {
        dispatch(Level.INFO, s);
    }

    public void info(String s, Object o) {
        dispatch(Level.INFO, s, o);
    }

    public void info(String s, Object o, Object o1) {
        dispatch(Level.INFO, s, o, o1);
    }

    public void info(String s, Object[] objects) {
        dispatch(Level.INFO, s, objects);
    }

    public void info(String s, Throwable t) {
        dispatch(Level.INFO, s, t);
    }

    public boolean isInfoEnabled(Marker marker) {
        return Levels.isInfoEnabled(effectiveLevel);
    }

    public void info(Marker marker, String s) {
        info(s);
    }

    public void info(Marker marker, String s, Object o) {
        info(s, o);
    }

    public void info(Marker marker, String s, Object o, Object o1) {
        info(s, o, o1);
    }

    public void info(Marker marker, String s, Object[] objects) {
        info(s, objects);
    }

    public void info(Marker marker, String s, Throwable throwable) {
        info(s, throwable);
    }

    public boolean isWarnEnabled() {
        return Levels.isWarnEnabled(effectiveLevel);
    }

    public void warn(String s) {
        dispatch(Level.WARN, s);
    }

    public void warn(String s, Object o) {
        dispatch(Level.WARN, s, o);
    }

    public void warn(String s, Object[] objects) {
        dispatch(Level.WARN, s, objects);
    }

    public void warn(String s, Object o, Object o1) {
        dispatch(Level.WARN, s, o, o1);
    }

    public void warn(String s, Throwable t) {
        dispatch(Level.WARN, s, t);
    }

    public boolean isWarnEnabled(Marker marker) {
        return Levels.isWarnEnabled(effectiveLevel);
    }

    public void warn(Marker marker, String s) {
        warn(s);
    }

    public void warn(Marker marker, String s, Object o) {
        warn(s, o);
    }

    public void warn(Marker marker, String s, Object o, Object o1) {
        warn(s, o, o1);
    }

    public void warn(Marker marker, String s, Object[] objects) {
        warn(s, objects);
    }

    public void warn(Marker marker, String s, Throwable throwable) {
        warn(s, throwable);
    }

    public boolean isErrorEnabled() {
        return Levels.isErrorEnabled(effectiveLevel);
    }

    public void error(String s) {
        dispatch(Level.ERROR, s);
    }

    public void error(String s, Object o) {
        dispatch(Level.ERROR, s, o);
    }

    public void error(String s, Object o, Object o1) {
        dispatch(Level.ERROR, s, o, o1);
    }

    public void error(String s, Object[] objects) {
        dispatch(Level.ERROR, s, objects);
    }

    public void error(String s, Throwable t) {
        dispatch(Level.ERROR, s, t);
    }

    public boolean isErrorEnabled(Marker marker) {
        return Levels.isErrorEnabled(effectiveLevel);            
    }

    public void error(Marker marker, String s) {
        error(s);
    }

    public void error(Marker marker, String s, Object o) {
        error(s, o);
    }

    public void error(Marker marker, String s, Object o, Object o1) {
        error(s, o, o1);
    }

    public void error(Marker marker, String s, Object[] objects) {
        error(s, objects);
    }

    public void error(Marker marker, String s, Throwable t) {
        error(s, t);
    }
}