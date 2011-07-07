package org.slough4j.logger;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * A NOP logger.
 *
 * @author pmorie
 */
public class NopLogger implements Logger {
    private String name;

    public NopLogger(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String msg) {
        // NOP
    }

    @Override
    public void trace(String format, Object arg) {
        // NOP
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void trace(String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void trace(String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;  // NOP
    }

    @Override
    public void trace(Marker marker, String msg) {
        // NOP
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        // NOP
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void trace(Marker marker, String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isDebugEnabled() {
        return false;  // NOP
    }

    @Override
    public void debug(String msg) {
        // NOP
    }

    @Override
    public void debug(String format, Object arg) {
        // NOP
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void debug(String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void debug(String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;  // NOP
    }

    @Override
    public void debug(Marker marker, String msg) {
        // NOP
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        // NOP
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void debug(Marker marker, String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isInfoEnabled() {
        return false;  // NOP
    }

    @Override
    public void info(String msg) {
        // NOP
    }

    @Override
    public void info(String format, Object arg) {
        // NOP
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void info(String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void info(String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;  // NOP
    }

    @Override
    public void info(Marker marker, String msg) {
        // NOP
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        // NOP
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void info(Marker marker, String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isWarnEnabled() {
        return false;  // NOP
    }

    @Override
    public void warn(String msg) {
        // NOP
    }

    @Override
    public void warn(String format, Object arg) {
        // NOP
    }

    @Override
    public void warn(String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void warn(String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;  // NOP
    }

    @Override
    public void warn(Marker marker, String msg) {
        // NOP
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        // NOP
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void warn(Marker marker, String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isErrorEnabled() {
        return false;  // NOP
    }

    @Override
    public void error(String msg) {
        // NOP
    }

    @Override
    public void error(String format, Object arg) {
        // NOP
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void error(String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void error(String msg, Throwable t) {
        // NOP
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;  // NOP
    }

    @Override
    public void error(Marker marker, String msg) {
        // NOP
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        // NOP
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public void error(Marker marker, String format, Object[] argArray) {
        // NOP
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        // NOP
    }
}
