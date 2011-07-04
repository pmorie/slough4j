package org.slough4j.model;

import org.testng.annotations.Test;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class LevelsTest {
    @Test
    public void testTestLevels_shouldReturnTrue() {
        assert Levels.isLevelEnabled(Level.TRACE, Level.DEBUG);
    }

    @Test
    public void testTestLevels_shouldReturnFalse() {
        assert !Levels.isLevelEnabled(Level.DEBUG, Level.TRACE);
    }
}
