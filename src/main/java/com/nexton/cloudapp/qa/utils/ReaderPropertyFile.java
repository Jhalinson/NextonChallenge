package com.nexton.cloudapp.qa.utils;

import com.nexton.cloudapp.qa.constants.FrameworkConstants;
import com.nexton.cloudapp.qa.enums.ConfigProperties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReaderPropertyFile {
    private static final Map<String, String> PROPMAP = new HashMap<>();
    private static Properties prop = new Properties();

    static {

        try {
            FileInputStream fiS = new FileInputStream(FrameworkConstants.getConfigPath());
            prop.load(fiS);
            System.out.println(FrameworkConstants.getConfigPath());
            for (Map.Entry<Object, Object> key : prop.entrySet()) {
                PROPMAP.put(String.valueOf(key.getKey()), String.valueOf(key.getValue()).trim());

            }
        } catch (Exception e) {
            System.out.println("Error loading config.properties " + e.getMessage());
            e.printStackTrace();
        }

    }

    private ReaderPropertyFile() {

    }

    public static String getValue(ConfigProperties key) throws Exception {
        String value;
        if (key == null || PROPMAP.get(key) == null) {
            value = PROPMAP.get(key.name().toLowerCase());
            System.out.println("Value: "+value);
        } else {
            throw new Exception("Property name:  " + key + " is not found. Please check config.properties");
        }

        return value;
    }

}
