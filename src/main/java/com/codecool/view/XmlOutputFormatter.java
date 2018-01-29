package com.codecool.view;


import java.util.List;
import java.util.Map;

public class XmlOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String, String>> data) {

        for(Map<String, String> mapRecord: data){
            for (String record : mapRecord.keySet()){
                System.out.format("<%1$s>%2$s></%1$s>\n", record, mapRecord.get(record));
            }
        }
    }
}
