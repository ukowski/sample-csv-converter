package com.codecool.dao;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
@Component
public class FileReader {

    public List<Map<String,String>> readData(File file) {

        List<String> headers;
        List <Map<String,String>> data = new ArrayList< >();

        try {
            Scanner scanner = new Scanner(file);

            headers = getHeaders(scanner.nextLine());

            while(scanner.hasNextLine()){

                Map<String, String> record = new LinkedHashMap<>();
                String[] line = scanner.nextLine().trim().split(",");

                for (int i = 0; i < headers.size() ; i++) {
                    record.put(headers.get(i), line[i]);
                }
                data.add(record);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    private List<String> getHeaders(String headersString) {

        List<String> headers;

        headersString = headersString.trim();
        headers = Arrays.asList(headersString.split(","));
        return headers;
    }
}
