package org.slough4j.util;

import org.slf4j.helpers.MessageFormatter;

/**
 * TODO: Javadoc
 *
 * @author pmorie
 */
public class MessageFormatting {
    public static String format(String message, Object ... args) {
        return MessageFormatter.format(message, args).getMessage(); 
    }
}
