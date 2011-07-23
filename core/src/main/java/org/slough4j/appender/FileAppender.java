package org.slough4j.appender;

import org.slough4j.display.LogMessages;
import org.slough4j.model.LogMessage;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAppender implements Appender {
    protected static String DEFAULT_FILE_NAME = "slough4j.log";

    private String fileName;
    private File workingFile;
    private OutputStream out;

    @Override
    public boolean initialize(Map<String, String> properties) {
        fileName = properties.get("app.file.name");

        if (fileName == null) {
            return false;
        }

        File file = new File(parseFileName(fileName));

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

    protected String parseFileName(String fileNameInput) {
        Pattern p = Pattern.compile("^\\$\\{([^\\}]+)\\}.*");
        Matcher m = p.matcher(fileNameInput);

        if (m.matches()) {
            return System.getProperty(m.group(1));
        }

        return fileNameInput;
    }

    public void append(List<LogMessage> messages) {
        for (LogMessage message : messages) {
            append(message);
        }
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
