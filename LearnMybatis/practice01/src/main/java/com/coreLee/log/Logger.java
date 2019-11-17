package com.coreLee.log;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Logger extends org.apache.log4j.Logger {

    static {
        InputStream inputStream = Logger.class.getResourceAsStream("/log/log4j.properties");
        PropertyConfigurator.configure(inputStream);
        String rootPath = Logger.class.getResource("").getPath();
        System.setProperty("project",rootPath);
    }

    private Logger(String name) {
        super(name);
    }


    public static org.apache.log4j.Logger getLogger(Class cla) {

        return org.apache.log4j.Logger.getLogger(cla);
    }
}
