package com.jony.test.junit;

import java.util.List;

//import org.jredis.JRedis;
//import org.jredis.RedisException;
//import org.jredis.ri.alphazero.JRedisClient;
//import org.jredis.ri.alphazero.support.DefaultCodec;

public class JRedisDemo {
	/* private JRedis jredis;
	 *//**
      * 建立与服务器连接
      * @throws Exception
      *//*
     JRedisDemo() throws Exception {
         System.out.println("** 尝试与服务器建立连接 **");
         jredis = new JRedisClient("10.4.101.93",6379);
         jredis.ping();
         System.out.println("** 连接服务器成功 **");
     }
     *//**
      * 断开连接
      *//*
     public void closeJredis() {
         if (jredis != null) {
                 System.out.println("** 断开与服务器的连接 **");
                 jredis.quit();
         }
     }
     *//**
      * 测试set/get使用
      *//*
     public void testJRedis() {
         try {
                 jredis.flushdb();
                 System.out.printf("** 放入值<%s=%s> **\n","foo","bar");
                 jredis.set("foo", "bar");
                 byte[] bytes = jredis.get("foo");
                 String value = DefaultCodec.toStr(bytes);
//                     String value = bytes.toString();
                 System.out.printf("** 获取到的值:%s **\n",value);
         } catch (RedisException e) {
                 e.printStackTrace();
         }
     }
     *//**
      * 测试lpush/rpush/lrange使用
      *//*
     public void testSet() {
         try {
             jredis.flushdb();
             System.out.printf("** 放入集合[%s,%s,%s,%s,%s] **\n","one","two","three","four","five");
             jredis.lpush("list", "three");
             jredis.lpush("list", "two");
             jredis.lpush("list", "one");

             jredis.rpush("list", "four");
             jredis.rpush("list", "five");
             List<byte[]> bytes = jredis.lrange("list", 0, -1);
             List<String> values = DefaultCodec.toStr(bytes);
//                     String values = bytes.toString();
             System.out.println("** 获取到的集合值"+values+" **");
         } catch (RedisException e) {
             e.printStackTrace();
         }
     }
     public static void main(String[] args) throws Exception {
    	 JRedisDemo redisTest = new JRedisDemo();
//         redisTest.prepareJRedisClient();

         redisTest.testJRedis();
         redisTest.testSet();
         
         redisTest.closeJredis();
 }*/
}
