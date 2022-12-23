package com.yevdokymov.task1.reader;

import com.yevdokymov.task1.Violation;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class Handler extends DefaultHandler {
    public List<Violation> violations = new ArrayList<>();
    Violation violation = null;
    String content;

    public void endElement(String uri, String localName, String qName){
        switch (qName) {
            case "type" -> {
                if (violations.stream().filter(x -> x.violationName.equals(content)).toList().isEmpty()) {
                    violation = new Violation();
                    violations.add(violation);
                } else {
                    violation = violations.stream().filter(x -> x.violationName.equals(content)).toList().get(0);
                }
                violation.violationName = content;
            }
            case "Fine_amount" -> violation.fineAmount = violation.fineAmount + Double.parseDouble(content);
        }
    }
    public void characters(char[] ch, int start, int length){
        content = String.copyValueOf(ch,start,length).trim();
    }
}
