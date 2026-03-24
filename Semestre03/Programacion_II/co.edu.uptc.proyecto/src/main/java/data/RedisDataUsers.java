package data;
import redis.clients.jedis.Jedis;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
public class RedisDataUsers {
    public void cargar(){
        try{
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("Archivos/usuarios.properties");
            
            props.load(fis);
            // con esto le explicamos al programda donde buscar la info
            Jedis jedis = new Jedis("localhost",6379);
            jedis.auth("redisdb");

            Set<String> usuarios = props.stringPropertyNames();

            for(String user: usuarios){
                String password = props.getProperty(user);
                jedis.hset("usuarios", user, password);
                System.out.println("Usuario cargado - " + user + " - " + password);
            }
            jedis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
