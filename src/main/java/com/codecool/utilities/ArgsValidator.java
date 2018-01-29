package com.codecool.utilities;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ArgsValidator {

    public boolean checkFilePath(String filePath) {

        File file = new File(filePath);

        if(file.exists()){
            return  true;
        }
        return false;
    }

    public boolean checkType(String type) {

        for (OutputFormats format : OutputFormats.values()){
            if(format.toString().equals(type)){
                return true;
            }
        }
        return false;
    }
}
