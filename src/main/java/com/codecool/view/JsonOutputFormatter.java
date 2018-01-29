package com.codecool.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String,String>> data) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(System.out, data);
            String json = mapper.writeValueAsString(data);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
