package com.jony.java.utils;

import java.util.Properties;

public class PropertiesHolder {
	
	private static final Properties properties=new Properties();
	
	public static void addProperties(Properties pro){
		if(null==pro||"".equals(pro)){
			return;
		}
		properties.putAll(pro);
		
	}
	public static String getPropertiesByKey(String keyword){
		return properties.getProperty(keyword);
	}

}
