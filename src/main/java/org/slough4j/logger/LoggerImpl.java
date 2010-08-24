package org.slough4j.logger;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slough4j.internals.dispatch.Dispatcher;
import org.slough4j.model.Level;
import org.slough4j.model.Levels;

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

    public boolean isTraceEnabled() {
        return Levels.isTraceEnabled(effectiveLevel);
    }

    public void trace(String s) {
        
    }

    public void trace(String s, Object o) {
        
    }

    public void trace(String s, Object o, Object o1) {
        
    }

    public void trace(String s, Object[] objects) {
        
    }

    public void trace(String s, Throwable throwable) {
        
    }

    public boolean isTraceEnabled(Marker marker) {
        return Levels.isTraceEnabled(effectiveLevel);
    }

    public void trace(Marker marker, String s) {
        
    }

    public void trace(Marker marker, String s, Object o) {
        
    }

    public void trace(Marker marker, String s, Object o, Object o1) {
        
    }

    public void trace(Marker marker, String s, Object[] objects) {
        
    }

    public void trace(Marker marker, String s, Throwable throwable) {
        
    }

    public boolean isDebugEnabled() {
        return Levels.isDebugEnabled(effectiveLevel);
    }

    public void debug(String s) {
        
    }

    public void debug(String s, Object o) {
        
    }

    public void debug(String s, Object o, Object o1) {
        
    }

    public void debug(String s, Object[] objects) {
        
    }

    public void debug(String s, Throwable throwable) {
        
    }

    public boolean isDebugEnabled(Marker marker) {
        return Levels.isDebugEnabled(effectiveLevel);
    }

    public void debug(Marker marker, String s) {
        
    }

    public void debug(Marker marker, String s, Object o) {
        
    }

    public void debug(Marker marker, String s, Object o, Object o1) {
        
    }

    public void debug(Marker marker, String s, Object[] objects) {
        
    }

    public void debug(Marker marker, String s, Throwable throwable) {
        
    }

    public boolean isInfoEnabled() {
        return Levels.isInfoEnabled(effectiveLevel);
    }

    public void info(String s) {
        
    }

    public void info(String s, Object o) {
        
    }

    public void info(String s, Object o, Object o1) {
        
    }

    public void info(String s, Object[] objects) {
        
    }

    public void info(String s, Throwable throwable) {
        
    }

    public boolean isInfoEnabled(Marker marker) {
        return Levels.isInfoEnabled(effectiveLevel);
    }

    public void info(Marker marker, String s) {
        
    }

    public void info(Marker marker, String s, Object o) {
        
    }

    public void info(Marker marker, String s, Object o, Object o1) {
        
    }

    public void info(Marker marker, String s, Object[] objects) {
        
    }

    public void info(Marker marker, String s, Throwable throwable) {
        
    }

    public boolean isWarnEnabled() {
        return Levels.isWarnEnabled(effectiveLevel);
    }

    public void warn(String s) {
        
    }

    public void warn(String s, Object o) {
        
    }

    public void warn(String s, Object[] objects) {
        
    }

    public void warn(String s, Object o, Object o1) {
        
    }

    public void warn(String s, Throwable throwable) {
        
    }

    public boolean isWarnEnabled(Marker marker) {
        return Levels.isWarnEnabled(effectiveLevel);
    }

    public void warn(Marker marker, String s) {
        
    }

    public void warn(Marker marker, String s, Object o) {
        
    }

    public void warn(Marker marker, String s, Object o, Object o1) {
        
    }

    public void warn(Marker marker, String s, Object[] objects) {
        
    }

    public void warn(Marker marker, String s, Throwable throwable) {
        
    }

    public boolean isErrorEnabled() {
        return Levels.isErrorEnabled(effectiveLevel);
    }

    public void error(String s) {
        
    }

    public void error(String s, Object o) {
        
    }

    public void error(String s, Object o, Object o1) {
        
    }

    public void error(String s, Object[] objects) {
        
    }

    public void error(String s, Throwable throwable) {
        
    }

    public boolean isErrorEnabled(Marker marker) {
        return Levels.isErrorEnabled(effectiveLevel);            
    }

    public void error(Marker marker, String s) {
        
    }

    public void error(Marker marker, String s, Object o) {
        
    }

    public void error(Marker marker, String s, Object o, Object o1) {
        
    }

    public void error(Marker marker, String s, Object[] objects) {
        
    }

    public void error(Marker marker, String s, Throwable throwable) {
        
    }
}

