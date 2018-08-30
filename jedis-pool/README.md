# jedis pool问题排查
[源码地址](https://github.com/xetorthio/jedis/releases)

[Jedis常见异常汇总](https://yq.aliyun.com/articles/236384#cc2)

[jedis:连接池(JedisPool)使用示例](https://blog.csdn.net/10km/article/details/77852075)

[jedis 的 Unexpected end of stream 解决方案](https://blog.csdn.net/aubdiy/article/details/53511410)


[业务并发量大，maxTotal确实设置小了--计算](https://yq.aliyun.com/articles/236384#cc1)

## 异常

###　Unexpected end of stream

1. Jedis多线程会有问题, 但JedisPool没有
2. 客户端缓冲区满了
3. 长时间闲置连接被服务端主动断开，可以查询timeout配置的设置以及自身连接池配置是否需要做空闲检测。

```sbtshell
# 查看Redis缓冲区的配置
config get client-output-buffer-limit
```
```
Redis的客户端缓冲区配置具体格式是：
client-output-buffer-limit <class> <hard limit> <soft limit> <soft seconds>
(a) class: 客户端类型：(a) normal、(b) slave、(c) pubsub
(b) hard limit: 如果客户端使用的输出缓冲区大于hard limit，客户端会被立即关闭。
(c) soft limit和soft seconds: 如果客户端使用的输出缓冲区超过了soft limit并且持续了soft limit秒，客户端会被立即关闭
```