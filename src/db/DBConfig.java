package db;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * File for DB configuration
 *
 * Includes hardcoded HOST, PORT, NAME
 * Includes methods to access .env content
 */

public class DBConfig {
    // Hardcode values for less sensitive data
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String NAME = "recipes_db";

    // Storing env vars from .env in root
    private static final Map<String, String> envVars = new HashMap<>();
    
    static {
        loadEnvFile();
    }
    
    private static void loadEnvFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                // Parse key=value pairs
                int equalsIndex = line.indexOf('=');
                if (equalsIndex > 0) {
                    String key = line.substring(0, equalsIndex).trim();
                    String value = line.substring(equalsIndex + 1).trim();
                    envVars.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading .env file: " + e.getMessage());
        }
    }
    
    // Env variables management
    private static String getEnv(String key, String defaultValue) {
        return envVars.getOrDefault(key, defaultValue);
    }
    
    public static String getUser() {
        return getEnv("DB_USER", "root");
    }
    
    public static String getPassword() {
        return getEnv("DB_PASS", "");
    }

    // getBootstrapURL: connects to MySQL server (for one-time setup of the DB)
    public static String getBootstrapURL() {
        return String.format("jdbc:mysql://%s:%d/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                             HOST, PORT);
    }
    
    // getAppURL: connecets to the created local db
    public static String getAppURL() {
        return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                             HOST, PORT, NAME);
    }
}
