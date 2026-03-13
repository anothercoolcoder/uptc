package data;

import redis.clients.jedis.Jedis;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class Data {
    public static void cargar(){
    try{
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("File/usuarios.properties");
            props.load(fis);

            Jedis jedis = new Jedis("localhost",6379);
            jedis.auth("programacion22026");

            Set<String> usuarios = props.stringPropertyNames();

            for(String user: usuarios){
                String password = props.getProperty(user);
                jedis.hset("usuarios",user, password);

                System.out.println("Usuario cargado " + user);
            }
            jedis.close();

        } catch(Exception e ){
            e.printStackTrace();
        }   
    }
    
}