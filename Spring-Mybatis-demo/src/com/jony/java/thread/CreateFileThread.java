package com.jony.java.thread;

import java.util.HashMap;

import com.jony.java.utils.CreateFileUtils;

public class CreateFileThread implements Runnable {

	/**
	 * @param args
	 */
	private String cacheQryType;
	private HashMap map;
	public CreateFileThread(String cacheQryType,HashMap map){
		this.cacheQryType = cacheQryType;
		this.map = map;
	}
	@Override
	public void run() {
		String cacheObj = null ;
		String fileName = null;
		if ("clearCodeMappingCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearCodeMappingCache");
			fileName = "encodingMappingCache.data";
		} else if ("clearDynamicConstantCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearDynamicConstantCache");
			fileName = "dynamicConstantCache.data";
		} else if ("clearXmlVerifyEngineCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearXmlVerifyEngineCache");
			fileName = "messageCheckerCache.data";
		} else if ("clearXmlAnalyseEngineCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearXmlAnalyseEngineCache");
			fileName = "packetAnalyzerCache.data";
		} else if ("clearXmlTransformEngineCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearXmlTransformEngineCache");
			fileName = "messageConverterCache.data";
		} else if ("clearXmlBuildEngineCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearXmlBuildEngineCache");
			fileName = "messageConstructorCache.data";
		} else if ("clearSooInnerStructureCache".equals(cacheQryType)) {
			cacheObj = (String) map.get("clearSooInnerStructureCache");
			fileName = "SOOInternalStructureCache.data";
		}else{
			return;
		}
		String basePath = System.getProperty("webAppRootValue");
		String filePath = basePath+ "/data";
		int bufferSize = 1024*10;
		try {
			CreateFileUtils.writeData2file(filePath, fileName, cacheObj, bufferSize);
		} catch (Exception e) {
			System.out.println(fileName+"文件写入数据失败！");
		}
	}
	

}
