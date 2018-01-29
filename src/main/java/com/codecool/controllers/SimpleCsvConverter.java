package com.codecool.controllers;

import com.codecool.dao.FileReader;
import com.codecool.factories.OutputFormatterFactory;
import com.codecool.utilities.OutputFormats;
import org.springframework.stereotype.Component;
import com.codecool.view.OutputFormatter;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class SimpleCsvConverter {

    private FileReader fileReader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {

        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(File file) {

        String formatType = OutputFormats.TABLEFORMAT.toString();

        List<Map<String, String>> data = fileReader.readData(file);
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(formatType);
        outputFormatter.printToConsole(data);
    }

    public void convert(File file, String formatType){

        List<Map<String, String>> data = fileReader.readData(file);
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(formatType);
        outputFormatter.printToConsole(data);
    }
}
