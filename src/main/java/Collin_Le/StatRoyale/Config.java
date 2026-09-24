package Collin_Le.StatRoyale;

import io. github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getKey(String key) {
        return dotenv.get(key);
    }

    public static String getURL(String url) {
    return dotenv.get(url);
    }
}
