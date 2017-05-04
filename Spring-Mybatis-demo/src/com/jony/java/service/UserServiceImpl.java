package com.jony.java.service;

import java.util.List;

import com.jony.java.dao.UserDao;
import com.jony.java.model.UserVO;

public class UserServiceImpl implements UserService{
	
	  private UserDao userDao;
	  public UserDao getUserDao() {
	    return userDao;
	  }
	  public void setUserDao(UserDao userDao) {
	    this.userDao = userDao;
	  }
	 
	  public int insert(UserVO user) {
	    return userDao.addUser(user);
	  }
	 
	  public int update(UserVO user) {
	    return userDao.updateUser(user);
	  }
	 
	  public int delete(String userName) {
	    return userDao.deleteUser(userName);
	  }
	 
	  public List<UserVO> selectAll() {
	    return userDao.getAllUsers();
	  }
	 
	  public int countAll() {
	    return userDao.countAll();
	  }
	 
	  public UserVO findByUserId(String id) {
	    return userDao.getUser(id);
	  }
	  public int add(int a ,int b){
		  return a+b;
	  }
	  
}
