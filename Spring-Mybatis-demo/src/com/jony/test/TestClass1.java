package com.jony.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.jony.java.dao.UserDao;
import com.jony.java.model.UserVO;
import com.jony.java.service.UserService;

public class TestClass1 {

	  private static ApplicationContext ctx;
	/**
     * @param args
     */
    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService=(UserService) ctx.getBean("userService");
        UserVO user=new UserVO();
        user.setWorkername("mybatis-de2");
        user.setSalary("8888");
        user.setQq("6666");
        user.setEmployedDates(new Date());
        userService.insert(user);
//        abc();
    }
    public static void abc(){
    	double[] res = new double[162150];
    	String[] abc = new String[162150];
    	int i= 0;
    	for(int a=0;a<=45;a++){
    		for(int b=0;b<=45-a;b++){
    			for(int c=0;c<=45-a-b;c++){
    				res[i] =  5*a*(1+0.2*c)*(1+0.1*b);
    				abc[i]=a+" ** "+b+" ** "+c;
//    				System.out.println("result :"+res[i] + " i :" + i);
    				i++;
    			}
    		}
    	}
    	double temp = res[0];
    	int resj=0;
    	for(int j=0;j<res.length-1;j++){
    		if(res[j]>temp){
    			temp = res[j];
    			resj = j;
    		}
    	}
    	System.out.println("run in "+resj+" times and max value is : "+temp);
    	System.out.println("a b c is :"+abc[resj]);
    }
}
