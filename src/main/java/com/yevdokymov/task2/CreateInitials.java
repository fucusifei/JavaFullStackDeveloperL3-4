package com.yevdokymov.task2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateInitials {
    String patternForName = "(\\Wname\\s?=\\s?\"[^\"]*\")";
    String patternForSurname = "(\\Wsurname\\s?=\\s?\"[^\"]*\")";
    private final String FILE_NAME = "personsResult.xml";
    public void deleteSurname(String pathToFile) throws IOException {
        String fullLine = "";
        String line;

        createResultFile();

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                fullLine = fullLine + line;
                if (line.contains("/>") ||line.contains("</")) {
                    line = fullLine.replaceAll(patternForName,findAndChangeName(fullLine)).replaceAll(patternForSurname,"");
                    writeToNewFile(line + "\n");
                    fullLine = "";
                }
                else {
                    fullLine = fullLine + "\n";
                }
            }
        }

    }
    private String findAndChangeName(String fullLine) {
        Pattern patternName = Pattern.compile(patternForName);
        Pattern patternSurname = Pattern.compile(patternForSurname);
        Matcher matcherName = patternName.matcher(fullLine);
        Matcher matcherSurname = patternSurname.matcher(fullLine);
        String nameFromLine = "";
        if (matcherName.find() && matcherSurname.find() ) {
            nameFromLine = matcherName.group().trim();
            String surnameFromLine = matcherSurname.group().trim()
                    .replaceAll(" ", "")
                    .replaceAll("\"", "")
                    .replaceAll("surname=","");
            nameFromLine = " " + nameFromLine.substring(0, nameFromLine.length()-1) + " " + surnameFromLine + "\"";
        }
        return nameFromLine;
    }
    private void writeToNewFile(String line) throws IOException{
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME,true)) {
            fileOutputStream.write(line.getBytes());
        }
    }
    private void createResultFile() throws IOException {
        File file = new File(FILE_NAME);
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
    }


}
