package com.quantum.config;

/**
 * Created by zqq on 18-8-31.
 */
public class JedisProperties {


    public static String ADDR_ARRAY = "172.17.0.2";
    public static int PORT = 6379 ;
    public static int TIMEOUT = 2000 ;


    // 可用连接实例的最大数目，默认值为8
    public static int MAX_ACTIVE = 8 ;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    public static int MAX_IDLE = 8;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    public static int MAX_WAIT = 3000;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    public static boolean TEST_ON_BORROW = false;

}
