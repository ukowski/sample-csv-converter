package com.codecool;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.codecool.utilities.ArgsValidator;
import com.codecool.controllers.SimpleCsvConverter;

import java.io.File;

public class ConverterApplication {

    public static void main(String[] args){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleCsvConverter simpleCsvConverter = (SimpleCsvConverter) ctx.getBean("simpleCsvConverter");
        ArgsValidator argsValidator = (ArgsValidator) ctx.getBean("argsValidator");

        if(args.length == 0) {

            System.out.println("No input file defined");

        } else if(args.length == 1 && argsValidator.checkFilePath(args[0])){

            String filePath = args[0];

            File file = new File(filePath);
            simpleCsvConverter.convert(file);

        } else if(args.length == 2 && argsValidator.checkFilePath(args[1]) && argsValidator.checkType(args[0])) {

            String filePath = args[1];
            String outputFormat = args[0];

            File file = new File(filePath);
            simpleCsvConverter.convert(file, outputFormat);

        } else {

            System.out.println("Wrong input");
        }
    }
}
