package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static jdk.internal.util.StaticProperty.userDir;

public class TestConfig {

    private static final String pathToLocalProperties = "src/main/resources/local-profile.properties";
    private static final boolean isLocalRun = new File(userDir() + pathToLocalProperties).exists();
    private static final File localProfilePropertiesFile = new File(pathToLocalProperties);
    private static final File remoteProfilePropertiesFile = new File("src/main/resources/remote-profile.properties");
    private static final Properties properties = new Properties();

    public static void loadProperties() {
        try {
            if (isLocalRun) {
                properties.load(new FileInputStream(localProfilePropertiesFile));
            } else properties.load(new FileInputStream(remoteProfilePropertiesFile));
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static Map<Creds, String> getUserCreds() {
        Map<Creds, String> user = new HashMap<>();
        user.put(Creds.LOGIN, properties.getProperty("userLogin"));
        user.put(Creds.PASSWORD, properties.getProperty("userPassword"));
        return user;
    }
}
