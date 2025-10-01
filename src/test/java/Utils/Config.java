package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);

            // Push values into system properties so your existing code can read them
            System.setProperty("APP_BASE_URL", props.getProperty("baseUrl"));
            System.setProperty("APP_USERNAME", props.getProperty("Username"));
            System.setProperty("APP_PASSWORD", props.getProperty("Password"));
            System.setProperty("APP_HEADLESS", props.getProperty("headless"));
            System.setProperty("APP_IMPLICIT", props.getProperty("implicitSeconds"));
            System.setProperty("APP_EXPLICIT", props.getProperty("explicitSeconds"));

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}