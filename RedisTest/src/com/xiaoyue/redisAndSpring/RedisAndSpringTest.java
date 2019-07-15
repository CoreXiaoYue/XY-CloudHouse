package com.xiaoyue.redisAndSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisAndSpringTest {
	@Test
	public void redisSpringTest() {
		//Spring配置文件
		String configLocation = "classpath:ApplicationContext.xml";
		//创建ioc容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext(configLocation);
		//获取JedisPool连接池实例。
		JedisPool jedisPool = (JedisPool) ioc.getBean("jedisPool");
		//获取jedis实例
		Jedis jedis = jedisPool.getResource();
		//获取值
		String avalue = jedis.get("key1");
		System.out.println(avalue);
	}
}
