package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String ENV;
    private static final Properties PROPERTIES = new Properties();

    static {
        ENV = System.getProperty("env", "dev");
        String fileName = ENV + ".properties";

        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IllegalStateException("Properties file not found: " + fileName);
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from file: " + fileName, e);
        }
    }


    public static String getRequiredProperty(String key) {
        String value = System.getProperty(key, PROPERTIES.getProperty(key));
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Property '" + key + "' is not set in system properties or config file");
        }
        return value;
    }


    public static String get(String key) {
        String value = System.getProperty(key, PROPERTIES.getProperty(key));
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Property '" + key + "' is not set in system properties or config file");
        }
        return value;
    }
}
