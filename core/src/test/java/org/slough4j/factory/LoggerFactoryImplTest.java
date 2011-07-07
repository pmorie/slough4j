package org.slough4j.factory;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slough4j.dispatch.Dispatcher;
import org.slough4j.level.LevelStore;
import org.slough4j.logger.LoggerImpl;
import org.slough4j.logger.NopLogger;
import org.slough4j.model.Level;

public class LoggerFactoryImplTest {
    @Test
    public void createNopLoggerForOffLevel() {
        LevelStore store = mock(LevelStore.class);
        when(store.findLevel("com.globochem.spokesthing.PitPat")).thenReturn(Level.OFF);
        when(store.findLevel("com.globochem.spokesthing.SplitSplat")).thenReturn(Level.TRACE);
        
        Dispatcher dispatcher = mock(Dispatcher.class);

        LoggerFactoryImpl factory = new LoggerFactoryImpl(store, dispatcher);

        assertThat(factory.getLogger("com.globochem.spokesthing.PitPat"), instanceOf(NopLogger.class));
        assertThat(factory.getLogger("com.globochem.spokesthing.SplitSplat"), instanceOf(LoggerImpl.class));
    }
}
