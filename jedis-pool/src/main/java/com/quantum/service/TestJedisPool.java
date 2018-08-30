package com.quantum.service;

import com.quantum.domain.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zqq on 18-8-31.
 */
@Slf4j
@Service
public class TestJedisPool {

    @Autowired
    private JedisPoolService jedisPoolService;


    private ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 0, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1000));




    public void handler(int i, Object content){
        Runnable r = new MyTask(i, content);
        try {
            executor.execute(r);
        }catch( RejectedExecutionException e ) {

            log.warn("reject");
            r.run( );
        }

    }


    class MyTask<T> implements Runnable {
        private int taskNum;
        private T t ;

        MyTask(int num, T t) {
            this.taskNum = num;
            this.t = t ;
        }

        @Override
        public void run() {

            log.info("task:" + taskNum + " -- " + t );
            Pair pair = (Pair) t;
            jedisPoolService.setString(pair.getKey(), pair.getValue());

        }
    }


}
