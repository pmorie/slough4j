package org.slough4j.model;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class LevelsTest {
    @Test
    public void debugEnabledForTrace() {
        assertThat(Levels.isLevelEnabledFor(Level.TRACE, Level.DEBUG), is(true));
    }

    @Test
    public void traceDisabledForDebug() {
        assertThat(Levels.isLevelEnabledFor(Level.DEBUG, Level.TRACE), is(false));
    }

    @Test
    public void allDisabledRelativeToOff() {
        assertThat(Levels.isLevelEnabledFor(Level.OFF, Level.ERROR), is(false));
        assertThat(Levels.isLevelEnabledFor(Level.OFF, Level.WARN), is(false));
        assertThat(Levels.isLevelEnabledFor(Level.OFF, Level.INFO), is(false));
        assertThat(Levels.isLevelEnabledFor(Level.OFF, Level.DEBUG), is(false));
        assertThat(Levels.isLevelEnabledFor(Level.OFF, Level.TRACE), is(false));
    }
}
