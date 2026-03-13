package config;
import java.io.FileInputStream;
import java.util.Properties;

public class ConnectionRedis {

    public static Properties cargar() {

        Properties props = new Properties();

        try {
            FileInputStream fis = new FileInputStream("File/redis.properties");
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return props;
    }
}