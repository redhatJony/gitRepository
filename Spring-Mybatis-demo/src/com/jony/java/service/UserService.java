package com.jony.java.service;

import java.util.List;

import com.jony.java.model.UserVO;

public interface UserService {
	public int insert(UserVO user);
	public int update(UserVO user);
	public int delete(String userName);
	public List<UserVO> selectAll();
	public int countAll();
	public UserVO findByUserId(String id);
}
