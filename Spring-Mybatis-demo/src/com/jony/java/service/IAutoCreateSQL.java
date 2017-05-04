package com.jony.java.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface IAutoCreateSQL {
	public String loadFileToString(String filePath,String fileName)throws IOException;
	public String replaceStr(String content,String regex,List<String> instList);
	public List createInstId(String maxInstId,int count);
	public void createSqlByRegex(List regexList,String filePath,String readerFileName,
			String writeFileName,int bufferSize,
			List paramList) throws IOException;
}
