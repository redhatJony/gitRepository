package com.jony.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jony.java.redis.IRedisDao;

@Service
public class RedisServiceImpl implements IRedisService {
	
	@Autowired
	private IRedisDao redisDao;
	
	@Override
	public void insert(String key,String value) {
		redisDao.insert(key, value);
	}

	public IRedisDao getRedisDao() {
		return redisDao;
	}

	public void setRedisDao(IRedisDao redisDao) {
		this.redisDao = redisDao;
	}

}
