package ssm.dao;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    @Test
    public void doTest() {
        Jedis jedis = new Jedis("127.0.0.1");
        String keys = "num";
        String value = jedis.get(keys);
        System.out.println(value);
    }

}
