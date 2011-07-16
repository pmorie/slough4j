package org.slough4j.appender;

import org.slough4j.display.LogMessages;
import org.slough4j.model.LogMessage;

import java.io.*;
import java.util.Map;

public class FileAppender implements Appender {
    private String fileName;
    private File workingFile;
    private OutputStream out;

    @Override
    public boolean initialize(Map<String, String> properties) {
        fileName = properties.get("app.file.name");

        if (fileName == null) {
            return false;
        }

        File file = new File(fileName);

        boolean success = true;

        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                success = false;
            }
        } else if (!file.canWrite()) {
            success = false;
        }
                                                                                                                                                      
        if (success) {
            try {
                out = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e) {
                success = false;
            }
        }

        return success;
    }

    @Override
    public void append(LogMessage message) {
        try {
            out.write(LogMessages.format(message));
            out.flush();
        } catch (IOException e) {
            // TODO: handle meaningfully
        }
    }

    @Override
    public void flush() {
        try {
            out.flush();
        } catch (IOException e) {
            // TODO: handle meaningfully
        }
    }
}
