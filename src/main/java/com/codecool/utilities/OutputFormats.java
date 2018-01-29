package com.codecool.utilities;

public enum OutputFormats {

    JSONFORMAT("json"),
    XMLFORMAT("xml"),
    TABLEFORMAT("table");

    private final String formatType;

    OutputFormats(String s) {
        formatType = s;
    }

    public String toString(){
        return this.formatType;
    }
}