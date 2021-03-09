package com.quinbay.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertypage {
    public static Properties prop = new Properties();
    static  {
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            System.out.println("Input Output exception");
            e.printStackTrace();
        }
    }
}
