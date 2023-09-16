package com.demoblaze.propertyreader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
     /*
    Rules for implementing singleton design pattern
    1. Make the constructor private
    2. Create a static method to get the instance
    3. Create a static member variable
    */

    //Declare the PropertyReader variable
    private static volatile PropertyReader propInstance;

    //Create Private constructor Because of prevent the Instantiation of class
    private PropertyReader() {
    }


    //A method that returns a singleton instance of the PropertyReader class
    public static synchronized PropertyReader getInstance() {
        // If the propInstance variable is null, create a new PropertyReader object
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        // Return the propInstance variable
        return propInstance;
    }

    // A method that takes a String parameter and returns the value of the corresponding property from the config.properties file
    public String getProperty(String propertyName) {
        // A Properties object that stores the key-value pairs from the config.properties file
        Properties prop = new Properties();
        // A FileInputStream object that reads the config.properties file FileInputStream
        FileInputStream inputStream = null;
        try {
            // Initialize the inputStream with the path of the config.properties file
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/config.properties");
            // Load the properties from the inputStream
            prop.load(inputStream);
            // If the property with the given name exists, return its value
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            // If an exception occurs, print an error message
            System.out.println("Property not found");
        }
        // If the property with the given name does not exist return null
        return null;
    }
}
