package config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ConnectionRedis {
    private static JedisPool pool;

    public static Jedis getConnection() {
        if (pool == null) {
            // Aquí puedes leer el archivo redis.properties, por ahora lo haremos directo:
            pool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);
        }
        return pool.getResource();
    }
}