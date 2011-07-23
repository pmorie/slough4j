package org.slough4j.appender;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class FileAppenderTest {
    @Test
    public void parseSystemPropertyReference() {
        System.setProperty("test.property", "foo");

        FileAppender app = new FileAppender();
        assertThat(app.parseFileName("${test.property}"), is("foo"));
    }

    @Test
    public void parseFileName() {
        FileAppender app = new FileAppender();
        assertThat(app.parseFileName("foo"), is("foo"));
    }
}
