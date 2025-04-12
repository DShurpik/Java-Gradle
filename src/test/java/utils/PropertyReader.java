package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    String env;
    Properties properties;

    public PropertyReader() {
        env = System.getProperty("env", "test");
        properties = getProperties(env);
    }


    public String getRequiredProperty(String key) {
        String value = System.getProperty(key, properties.getProperty(key));
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Property '" + key + "' is not set in system properties or config file");
        }
        return value;
    }


    private Properties getProperties(String env) {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(env + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to load %s.properties", env), e);
        }
        return properties;
    }
}
