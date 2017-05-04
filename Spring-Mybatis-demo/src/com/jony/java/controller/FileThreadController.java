package com.jony.java.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jony.java.service.ThreadService;
@Controller  
@RequestMapping("/fileThread")  
public class FileThreadController {
	 private Logger logger= Logger.getLogger(FileThreadController.class);
	 @Resource
	 private ThreadService threadService;
	 //通过HttpServletRequest请求，获取前台页面传过来的值
	 //springMVC不返回视图 @ResponseBody void
	    @RequestMapping("/writeData2File")  
	    public @ResponseBody void writeData2File(HttpServletRequest request,Model model){  
	        String qryType = request.getParameter("qryType"); 
	        String content = request.getParameter("content"); 
	        try {
				this.threadService.writeData2file(qryType,content);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
	    }
//	    public @ResponseBody void test(){
//
//	    }
}
