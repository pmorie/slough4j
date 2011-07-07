package org.slough4j.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B {
    private static Logger log = LoggerFactory.getLogger(B.class);

    public void execute() {
        log.debug("A");
    }
}
