package org.slough4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class Runner {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String ... args) {
        for (int ii = 0; ii < 10; ii++) {
            log.info("Foo");
            
        }
    }
}
