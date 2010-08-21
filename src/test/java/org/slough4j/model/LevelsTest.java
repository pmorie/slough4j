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
        assert Levels.testLevels(Level.TRACE, Level.DEBUG);
    }

    @Test
    public void testTestLevels_shouldReturnFalse() {
        assert !Levels.testLevels(Level.DEBUG, Level.TRACE);
    }
}
