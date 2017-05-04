package com.jony.java.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jony.java.dao.TcpDetailDao;

@Service
public class TcpDetailServiceImpl implements TcpDetailService {
	private TcpDetailDao tcpDetailDao;
	@Override
	public List qryAllDepTcpContDetail(HashMap hashMap) throws Exception {
		return this.tcpDetailDao.qryAllDepTcpContDetail(hashMap);
	}
	@Override
	public List qryAllBusiSceneCdFromDepPrvncBusi(HashMap hashMap)
			throws Exception {
		return this.tcpDetailDao.qryAllBusiSceneCdFromDepPrvncBusi(hashMap);
	}
	
	//get/set 方法注入
	public TcpDetailDao getTcpDetailDao() {
		return tcpDetailDao;
	}
	public void setTcpDetailDao(TcpDetailDao tcpDetailDao) {
		this.tcpDetailDao = tcpDetailDao;
	}
	
}
