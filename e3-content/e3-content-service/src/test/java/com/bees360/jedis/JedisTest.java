package com.bees360.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	/**
	 * 单机版
	 * @throws Exception
	 */
	@Test
	public void testJedis() throws Exception{
		//创建一个连接Jedis对象，参数：host，port
		Jedis jedis = new Jedis("192.168.25.128",6379);
		//直接使用jedis操作redis，所有的jedis的命令对应一个方法
		jedis.set("test123", "first jedis test");
		String string = jedis.get("test123");
		System.out.println(string);
		//关闭连接
		jedis.close();
	}
	/**
	 * 单机版连接池
	 * @throws Exception
	 */
	@Test
	public void testJedisPool() throws Exception{
		//创建一个连接连接池对象，参数：host，port
		JedisPool jedisPool = new JedisPool("192.168.25.128",6379);
		//从连接池中获得一个连接，即jedis对象
		Jedis jedis = jedisPool.getResource();
		//jedis操作redis
		String string = jedis.get("test123");
		System.out.println(string);
		//关闭连接，每次使用完后关闭连接。连接池回收资源
		jedis.close();
		//关闭连接池
		jedisPool.close();
	}
	
	/**
	 * 连接集群
	 * @throws Exception
	 */
	@Test
	public void testJedisCluster() throws Exception{
		//创建一个jedisCuluster对象，有一个参数nodes 是set类型，set中包含若干个host和port
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.128", 7001));
		nodes.add(new HostAndPort("192.168.25.128", 7002));
		nodes.add(new HostAndPort("192.168.25.128", 7003));
		nodes.add(new HostAndPort("192.168.25.128", 7004));
		nodes.add(new HostAndPort("192.168.25.128", 7005));
		nodes.add(new HostAndPort("192.168.25.128", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		//直接使用jedisCluster对象操作redis
		 jedisCluster.set("test", "123");
		String string = jedisCluster.get("test");
		System.out.println(string);
		//关闭jedisCluster对象
		jedisCluster.close();
		
	}
}
