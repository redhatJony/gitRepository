package com.jony.java.redis;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.al.crm.nosql.cache.ICache;
import com.jony.java.utils.ConstantsUtils;
import com.jony.java.utils.SpringUtil;
@Component
public class RedisDaoImpl implements IRedisDao{
	//路由映射
	private Map<String,String> routeRedis;
	//默认路由
	private String defaultRoute = ConstantsUtils.DEFAULT_ROUTE;
	/***
	 * 获取默认redis连接
	 * @param null
	 * @return ICache
	 * @since 20170509
	 * @author Jony
	 */
	public ICache getDefaultCacheDao(){
		String defaultBeanName=routeRedis.get(defaultRoute);
		return (ICache) SpringUtil.getInstanceByName(defaultBeanName);
	}
	/***
	 * 获取指定redis连接
	 * @param String
	 * @return ICache
	 * @since 20170509
	 * @author Jony
	 */
	public ICache getCacheDaoByRoute(String route){
		String defaultBeanName=routeRedis.get(route);
		return (ICache) SpringUtil.getInstanceByName(defaultBeanName);
	}

	/***
	 * 插入键值对到默认redis服务器
	 * @param String key
	 * @param Object value
	 * @return void
	 * @since 20170509
	 * @author Jony
	 */
	@Override
	public void insert(String key, Object value) {
		this.getDefaultCacheDao().put(key,value);
		
	}
	
	/***
	 * 插入键值对到指定redis服务器
	 * @param String key
	 * @param Object value
	 * @return void
	 * @since 20170509
	 * @author Jony
	 */
	@Override
	public void insert(String key, Object value, String route) {
		this.getCacheDaoByRoute(route).put(key,value);
	}
	
	/***
	 * 获取键对应的值，从默认的redis服务器
	 * @param String key
	 * @return Object 
	 * @since 20170509
	 * @author Jony
	 */
	@Override
	public Object get(String key) {
		return getDefaultCacheDao().get(key);
	}

	/***
	 * 获取键对应的值，从指定的redis服务器
	 * @param String key
	 * @return Object 
	 * @since 20170509
	 * @author Jony
	 */
	@Override
	public Object get(String key, String route) {
		return getCacheDaoByRoute(route).get(key);
	}

	public Map<String, String> getRouteRedis() {
		return routeRedis;
	}

	public void setRouteRedis(Map<String, String> routeRedis) {
		this.routeRedis = routeRedis;
	}

	public static void main(String[] args){
		
	}
}
