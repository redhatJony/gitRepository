package com.jony.java.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import redis.clients.jedis.Jedis;

import com.jony.java.jedis.JedisUtil;
import com.jony.java.jedis.JedisUtil.Strings;
import com.jony.java.model.UserVO;
import com.jony.java.service.UserService;
@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private UserService userService;
    @Resource
    private JedisUtil jedisUtil;
  //通过HttpServletRequest请求，获取前台页面传过来的值
    @RequestMapping("/getUserJedis")
    public String getUserJedis(HttpServletRequest request,Model model){  
        String userId = request.getParameter("id");  
        Jedis jedisPool = jedisUtil.getJedis();
//        String userName = jedisPool.get(userId);
//        Strings strs = jedisUtil.new Strings();//实例化用内部类
//        String password = strs.get("password");
//        model.addAttribute("jedisName", userName);  
//        model.addAttribute("password", password);  
        //hashMap
        HashMap<?, ?> hashMap = (HashMap<?, ?>) jedisPool.hgetAll(userId);
        model.addAttribute("jedisHashMap", hashMap);  
        return "showJedisCache"; 
    }
    //通过HttpServletRequest请求，获取前台页面传过来的值
    @RequestMapping("/showUser")  
    public String getUser(HttpServletRequest request,Model model){  
        String userId = request.getParameter("id");  
        UserVO user = this.userService.findByUserId(userId);
        model.addAttribute("user", user);  
        return "showUser"; 
    }
    //通过注解RequestParam标识自动绑定的，从前台页面传过来的值
    @RequestMapping("/showUser2")
    public String getUser2(@RequestParam("id") String id,Model model){
    	String userId = id;
    	UserVO user = this.userService.findByUserId(userId);
    	model.addAttribute("user", user);  
    	return "showUser";//返回的字符串对应到JSP文件的名称
    }
    @RequestMapping("/hello")
    public String hello(String str,Model model){  
    	model.addAttribute("name", "gn");  
        //这个只有值没有键的情况下,使用Object的类型作为key,String-->string  
        model.addAttribute("ok");  
        return "showUser";
    }
    
}