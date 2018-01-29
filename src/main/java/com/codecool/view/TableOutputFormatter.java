package com.codecool.view;

import java.util.*;

public class TableOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String, String>> data) {

        Set<String> headers = data.get(0).keySet();

        System.out.println(headers);
        for(Map<String, String> record: data) {
            System.out.println(record.values());
        }
    }
}
