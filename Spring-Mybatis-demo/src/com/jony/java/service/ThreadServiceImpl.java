package com.jony.java.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jony.java.thread.CreateFileThread;
@Service("threadService")
@Scope("prototype")
public class ThreadServiceImpl implements ThreadService{
	 private Logger logger= Logger.getLogger(ThreadServiceImpl.class);
	/**
	 * @param args
	 */

	@Override
	public void writeData2file(String qryType,String content) throws Exception {
//		 String qryType = "clearCodeMappingCache";
		  HashMap map = new HashMap();
		  map.put(qryType, content);
		  CreateFileThread thfile = new CreateFileThread(qryType,map);
		  Thread thTest = new Thread(thfile,"thDemo");
		  thTest.start();
	}

}
