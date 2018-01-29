package com.codecool.factories;

import org.springframework.stereotype.Component;
import com.codecool.utilities.OutputFormats;
import com.codecool.view.JsonOutputFormatter;
import com.codecool.view.OutputFormatter;
import com.codecool.view.TableOutputFormatter;
import com.codecool.view.XmlOutputFormatter;
@Component
public class OutputFormatterFactory {

    public OutputFormatter createByFormat(String outputFormat){

        if(outputFormat.equals(OutputFormats.TABLEFORMAT.toString())) {
            return new TableOutputFormatter();

        } else if (outputFormat.equals(OutputFormats.JSONFORMAT.toString())) {
            return new JsonOutputFormatter();

        } else if (outputFormat.equals(OutputFormats.XMLFORMAT.toString())) {
            return new XmlOutputFormatter();
        }
        return null;
    }
}
