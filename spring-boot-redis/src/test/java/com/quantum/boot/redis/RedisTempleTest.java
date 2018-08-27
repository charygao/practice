package com.quantum.boot.redis;

import com.quantum.boot.redis.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Created by zqq on 18-8-26.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTempleTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private RedisTemplate redisTemplate;


    // 默认使用JdkSerializationRedisSerializer来进行序列化 , 为了能在redis看到数据,使用String序列化
    // 对象  使用json节省空间, 当然还可以自定义实现压缩
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        RedisSerializer<User> jsonSerializer = new Jackson2JsonRedisSerializer<>(User.class);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void test()  {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象 json
        redisTemplate.opsForValue().set("bbb", new User(111l, "quantum", 25));


    }

    @Test
    public void test002()  {

        // 保存对象
        redisTemplate.opsForValue().set("ccc", new User(111l, "quantum", 25));
        System.out.println(redisTemplate.opsForValue().get("ccc"));

    }

    @Test
    public void test003()  {

        // 保存字符串
        redisTemplate.opsForValue().set("aaa", new User(111l, "quantum", 25));
        Assert.assertTrue(redisTemplate.opsForValue().get("bbb") instanceof User);

    }

}
