package com.jony.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.jony.java.jedis.JedisUtil;
import com.jony.java.service.IAutoCreateSQL;
import com.jony.java.service.TcpDetailService;
import com.jony.java.utils.CommenUtils;

@Controller  
@RequestMapping("/autoCreateSQL") 
public class AutoCreateSQLController {
	 private Logger logger= Logger.getLogger(AutoCreateSQLController.class);
	 @Resource
	 private IAutoCreateSQL autoCreateSQL;
	 @Resource 
	 private TcpDetailService tcpDetailService;
	 @Resource
	 private JedisUtil jedisUtil;
	 
	 private static String filePath = "D:\\AsiaInfoDoc\\CommCodeFile\\";//默认文件路径
	 private static String readerFileName = "templeteSQL.sql";//默认模板文件
	 private static String writeFileName = "newSQL.sql";//默认生成数据到此文件
	 private static final int bufferSize = 1024*10; //缓冲区大小
	 
	 @RequestMapping("/replaceStr")
	 public @ResponseBody void replaceStr(HttpServletRequest request,Model model){  
		 	List<String> paramList = new ArrayList<String>();
		 	paramList.add(request.getParameter("serviceInstId"));
		 	paramList.add(request.getParameter("busCode")); 
		 	paramList.add(request.getParameter("svcCode")); 
		 	paramList.add(request.getParameter("serviceContractVer"));
//	        HashMap regexMap = new HashMap();
//	        regexMap.put("serviceInstIdRegex", "'SRVC.*?\\d'");
//	        regexMap.put("busCodeRegex", "'BUS\\d{5}'");
//	        regexMap.put("svcCodeRegex", "'SVC\\d{5}'");
//	        regexMap.put("serviceContractVerRegex", "'SVC\\d{13}'");
		 	List<String> regexList = new ArrayList<String>();
		 	regexList.add("'SRVC.*?\\d'");
		 	regexList.add("'BUS\\d{5}'");
		 	regexList.add("'SVC\\d{5}'");
		 	regexList.add("'SVC\\d{13}'");
	        try {
	        	this.autoCreateSQL.createSqlByRegex(regexList, filePath,
	        			readerFileName, writeFileName,
	        			bufferSize, paramList);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
	    }
	 @RequestMapping("/insertIntoRedis")
	 public @ResponseBody void insertIntoRedis(HttpServletRequest request,Model model){
		 HashMap resultMap = new HashMap();
		 List<Map> depTcpContDetailList = null;
		 try{
			depTcpContDetailList = this.tcpDetailService.qryAllDepTcpContDetail(null);
		 }catch(Exception e){
			 logger.debug(e.getMessage());
		 }
		 System.out.println(depTcpContDetailList.size());
		 int i = 0;
		 if (null != depTcpContDetailList && !depTcpContDetailList.isEmpty()) {
			
			String busCode = null;
			String serviceCode = null;
			String keyElement = null;
			String srvcInstId = null;
			Jedis jedisPool = jedisUtil.getJedis();
			jedisPool.select(1);
//			for (Map<String, String> depTcpContDetailMap : depTcpContDetailList) {
//				i++;
//				busCode = depTcpContDetailMap.get("BUS_CODE");
//				serviceCode = depTcpContDetailMap.get("SERVICE_CODE");
////					resultMap.put(busCode + "_" + serviceCode, depTcpContDetailMap); //TODO:后续这个要去除
//				Jedis jedisPool = jedisUtil.getJedis();
//				jedisPool.select((i%14)+2);
//				jedisPool.hmset(busCode + "_" + serviceCode, depTcpContDetailMap);
//				srvcInstId = depTcpContDetailMap.get("SRVC_INST_ID"); //获取能力平台服务实例标识
//				keyElement = CommenUtils.getSaopServiceJudgeKeyElement(depTcpContDetailMap, null); //获取判断能力平台服务实例标识的关键元素
////					resultMap.put(keyElement, srvcInstId);
//				jedisPool.hset("detailInstMap", keyElement, srvcInstId);
//				keyElement = srvcInstId;
////					resultMap.put(keyElement, depTcpContDetailMap);
//				jedisPool.hmset(keyElement, depTcpContDetailMap);
//				System.out.println("loop-------------"+ i +"-------------times");
//			}
			System.out.println("插入redis 成功!");
		}
	 }
}
