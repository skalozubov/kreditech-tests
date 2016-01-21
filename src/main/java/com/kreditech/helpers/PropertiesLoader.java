package com.kreditech.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static final String PATH_TO_PROPERTIES_FILE = "/configuration.properties";
    Properties properties = new Properties();

    public String getStringPropertyValue(String property) {
        try {
            properties.load(PropertiesLoader.class.getResourceAsStream(PATH_TO_PROPERTIES_FILE));
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}