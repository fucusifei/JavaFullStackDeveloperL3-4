package com.yevdokymov.task1.reader;

import com.yevdokymov.task1.Violation;
import com.yevdokymov.task1.files.FileFounder;
import com.yevdokymov.task1.files.FileWriter;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Parser {
    public List<Violation> firstParse() throws Exception{
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        Handler handler = new Handler();
        FileFounder fileFounder = new FileFounder();
        for (File file: fileFounder.files){
            parser.parse(file.getPath(), handler);
        }
        handler.violations.sort(Comparator.comparing(Violation::getFineAmount));
        Collections.reverse(handler.violations);

        return handler.violations;
    }


}
