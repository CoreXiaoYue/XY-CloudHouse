package com.xiaoyue.redis;


import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 小岳  
 * 			Redis API使用
 *
 */

public class RedisTest1 {
	
	/**
	 * 	使用redis连接Redis。
	 */
	@Test
	public void redistest1() {
		//获取redis连接。
		Jedis jedis6379 = new Jedis("192.168.64.128",6379);//远程主机服务器ip地址和端口号。
		//存入数据。
		jedis6379.set("key1", "k1");
		//获取数据
		System.out.println(jedis6379.get("key1"));
		System.out.println(jedis6379.get("a"));
		//关闭redis连接
		jedis6379.close();
		
		//
		Jedis jedis6380 = new Jedis("192.168.64.128",6380);//远程主机服务器ip地址和端口号。
		System.out.println(jedis6380.get("key1"));
		jedis6380.close();
	}
	
	/**
	 * 		通过连接池获取jedis实例连接
	 */
	@Test
	public void redisPool() {
		//创建连接池对象。
		JedisPoolConfig jpc = new JedisPoolConfig();
		//设置最大连接数
		jpc.setMaxTotal(30);
		//设置最大空闲数
		jpc.setMaxIdle(2);
		
		//获取连接池实例
		JedisPool jedisPool = new JedisPool(jpc,"192.168.64.128",6379);
		//通过链接池获取jedis实例
		Jedis jedis = jedisPool.getResource();
		//获取值。
		System.out.println(jedis.get("a"));
		
		//关闭jedis连接
		jedis.close();
		//关闭jedispool链接池
//		jedisPool.close();
	}
	
}
