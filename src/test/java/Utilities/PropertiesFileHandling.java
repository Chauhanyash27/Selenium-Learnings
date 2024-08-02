package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileHandling {

    public static String getPropertyValue(String key) throws IOException {
        Properties properties = new Properties();
        String filePath = System.getProperty("user.dir")+"/src/test/java/Resources/ConfigFile.properties";
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }
        return properties.getProperty(key);
    }
}
