package com.quantum;

import com.quantum.domain.Pair;
import com.quantum.service.TestJedisPool;
import com.quantum.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zqq on 18-8-31.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class JestPoolTest {

    @Autowired
    private TestJedisPool testJedisPool;

    @Test
    public void testSetString(){
        for (int i = 0; i < 10000 ; i++) {
            Pair pair = Pair.builder().key(Utils.getUUID32()).value("" + i).build();
            testJedisPool.handler(i, pair);
        }
    }
}
