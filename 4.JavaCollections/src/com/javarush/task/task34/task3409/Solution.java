package com.javarush.task.task34.task3409;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Настраиваем логгер
*/
public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(com.javarush.task.task34.task3409.Solution.class);
    public static void main(String args[]) throws IOException {
        String logProperties = "4.JavaCollections/src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        PropertyConfigurator.configure(logProperties);
        Path path = Paths.get(logProperties).toAbsolutePath();
        logger.error("processTask id=" + logProperties);
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
        }
    }
}
