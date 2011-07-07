package org.slough4j.runner;

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
        log.debug("Hi");
        log.info("There");
        log.warn("Big");
        log.error("World");
        
        A a = new A();
        a.execute();

        B b = new B();
        b.execute();
    }
}
