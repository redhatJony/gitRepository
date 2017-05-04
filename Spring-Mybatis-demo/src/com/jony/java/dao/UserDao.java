package com.jony.java.dao;

import java.util.HashMap;
import java.util.List;

import com.jony.java.model.UserVO;

public interface UserDao {
	  public int addUser(UserVO user);
	  public int updateUser(UserVO user);
	  public int deleteUser(String userName);
	  public List<UserVO> getAllUsers();
	  public int countAll();
	  public UserVO getUser(String id);
	  public List qryAllDepTcpContDetail(HashMap hashMap) throws Exception;
}
