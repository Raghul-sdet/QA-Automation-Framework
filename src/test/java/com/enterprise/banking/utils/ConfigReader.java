package com.enterprise.banking.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            // CRITICAL JENKINS FIX:
            // Use System.getProperty("user.dir") to dynamically find the project root directory
            // This works flawlessly on both Local Eclipse and Jenkins Cloud Server
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            fis.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file from path: " + System.getProperty("user.dir") + "/src/test/resources/config.properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}