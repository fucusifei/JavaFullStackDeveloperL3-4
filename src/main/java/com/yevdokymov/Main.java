package com.yevdokymov;

import com.yevdokymov.task1.files.FileWriter;
import com.yevdokymov.task1.reader.Parser;
import com.yevdokymov.task2.CreateInitials;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        CreateInitials createInitials = new CreateInitials();
        createInitials.deleteSurname("persons.xml");

        Parser parser = new Parser();
        FileWriter j = new FileWriter();
        j.writeObjectListToJson(parser.firstParse());
    }
}
