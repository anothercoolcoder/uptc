package dao;
import java.util.Properties;
import config.ConnectionRedis;
import redis.clients.jedis.Jedis;

public class UsuariosDAO{
    Properties props = ConnectionRedis.cargar();
    public Jedis jedis;
    public String host;
    public int port;
    public String password;
    public UsuariosDAO() {
    host = props.getProperty("redis.host");
    port =
    Integer.parseInt(props.getProperty("redis.port"));
    password = props.getProperty("redis.password");
    jedis = new Jedis(host, port);
    jedis.auth(password);
    }
    public boolean validarUsuario(String usuario,String password)
    {

    String clave = jedis.hget("usuarios", usuario);
    System.out.println(clave);
    if(clave !=null && clave.equals(password)) {
    return true;
    }
    return false;
    }
}