package org.slough4j.level;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slough4j.model.Level;

import java.util.Map;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class MapBackedLevelStoreTest {
    private MapBackedLevelStore store;

    @Test
    public void walkPackageStructure() {
        Map<String, Level> levelMap = mock(Map.class);
        when(levelMap.get("com")).thenReturn(Level.WARN);
        when(levelMap.get("com.foo")).thenReturn(Level.INFO);
        when(levelMap.get("com.foo.bar")).thenReturn(Level.DEBUG);
        when(levelMap.get("com.foo.bar.Thing")).thenReturn(Level.TRACE);

        store = new MapBackedLevelStore(levelMap, Level.ERROR);

        assertEquals(Level.TRACE, store.findLevel("com.foo.bar.Thing"));
        assertEquals(Level.DEBUG, store.findLevel("com.foo.bar.OtherThing"));
        assertEquals(Level.INFO, store.findLevel("com.foo.baz.YetAnotherThing"));
        assertEquals(Level.WARN, store.findLevel("com.sun.OfficialSoundingClass"));
    }
}
