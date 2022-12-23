package com.yevdokymov.task1.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yevdokymov.task1.Violation;

import java.io.File;
import java.util.List;

public class FileWriter {
    public  String path = "violation.json";
    public void writeObjectListToJson(List<Violation> violationsList) throws Exception{
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(path),violationsList);
    }
}
