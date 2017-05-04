package com.jony.java.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		sd.format(new Date());
		System.out.println("hello job!-----------"+ sd.format(new Date()));
	}

}
