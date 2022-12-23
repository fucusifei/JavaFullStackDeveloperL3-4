package com.yevdokymov.task1.files;

import java.io.File;

public class FileFounder {
    public String directoryName = "files";
    public File[] files = new File(directoryName).listFiles();
}
