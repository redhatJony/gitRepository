package com.jony.java.redis;

public interface IRedisDao {
	public void insert(String key,Object value);
	public void insert(String key,Object value,String route);
	public Object get(String key);
	public Object get(String key,String route);
}
