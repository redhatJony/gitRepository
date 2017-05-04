package com.jony.java.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.jony.java.utils.CreateFileUtils;

@Service
public class AutoCreateSQLImpl implements IAutoCreateSQL{
	private static String filePath = "D:\\AsiaInfoDoc\\CommCodeFile\\";//默认文件路径
	private static String readerFileName = "templeteSQL.sql";//默认模板文件
	private static String writeFileName = "newSQL.sql";//默认生成数据到此文件
	private static final int bufferSize = 1024*10; //缓冲区大小
	/**
	 *@param filePath
	 *@param fileName
	 *加载文件，读取文件内容转换成字符串
	 */
	public String loadFileToString(String filePath, String fileName) throws IOException {
		StringBuffer content = new StringBuffer();//缓存字符串
		InputStream inputStream = null;
		//文件输入流
		try {
			inputStream = new FileInputStream(filePath+fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//缓冲读取流
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
			String conStr = null;
			while((conStr = bufferedReader.readLine())!=null){//分行进行读取文件中的内容
				content.append(conStr+"\n");//转化 为缓冲字符串
			}
		} catch (UnsupportedEncodingException e1) {
			throw new UnsupportedEncodingException(e1.getMessage());
		}catch (IOException e) {
			throw new IOException(e.getMessage());
		}finally{//关闭流
			bufferedReader.close();
			inputStream.close();
		}
		return content.toString();
	}
	/**
	 * @param maxInstId ：当前测试库|生产库中的最大服务实例ID  例如：SRVCINST95078
	 * @param count 要生成的ID个数，不超过32个
	 * @return reList 服务实例ID所在的LIST
	 */
	@Override
	public List createInstId(String maxInstId,int count) {
		List reList = new ArrayList();
		String startIdNum = maxInstId.substring(8);//从第8个下标位置开始取（包括第八个下标位）
		int start = Integer.parseInt(startIdNum);
		while(count-->0){
			String inst = "SRVCINST"+String.format("%05d", ++start);//补全5位编码 再连接字符串
			reList.add(inst);
		}
		return reList;
	}
	/**
	 * @param instIdList 服务实例ID所在的LIST
	 * @param content SQL脚本
	 * @return sb
	 * 说明：此种生成并替换服务实例ID的方法有局限性，要求模板SQL中的服务实例SQL数据和服务识别SQL数据严格按顺序对应，如果顺序乱了，生成的脚本也是乱的！
	 * 	  后续考虑改进此方法
	 */
	@Override
	public String replaceStr(String content,String regex,List<String> instIdList) {
		StringBuffer sb = new StringBuffer();
		String[] contentList = content.split(";");

		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = null;
		String newContent = null; 
		//第一次替换服务实例数据中的SVCINSTID
		for(int i=0;i<instIdList.size();i++){
			matcher = pattern.matcher(contentList[i]);
			while (matcher.find()) {
				newContent = matcher.replaceFirst("'"+instIdList.get(i)+"'");
				break;
			}
			sb.append(newContent+";");
		}
		//第二次替换服务识别数据中的SVCINSTID
		for(int i=0;i<instIdList.size();i++){
			matcher = pattern.matcher(contentList[32+i]);
			while (matcher.find()) {
				newContent = matcher.replaceFirst("'"+instIdList.get(i)+"'");
				break;
			}
			sb.append(newContent+";");
		}
//		for(int i=0;i<instIdList.size();i++){
//			sb.append(contentList[i].replaceFirst(regex,"'"+instIdList.get(i)+"'")+";");
//			sb.append(contentList[32+i].replaceFirst(regex,"'"+instIdList.get(i)+"'")+";");
//		}
		content = sb.toString();
		return content;
	}
	public void createSqlByRegex(List regexList,String filePath,String readerFileName,
			String writeFileName,int bufferSize,List paramList) throws IOException{
		String content = this.loadFileToString(filePath,readerFileName);
		String startInstId = (String) paramList.get(0);
		paramList.remove(0);
		List instIdList = this.createInstId(startInstId,32);
		String resCon = null;
		//替换实例ID
		resCon = this.replaceStr(content, regexList.get(0).toString(), instIdList);
		regexList.remove(0);
		//此处处理busCode、serviceCode、serviceContractVer的替换
		if(regexList.size()==paramList.size()){
			for(int i=0;i<paramList.size();i++){
				resCon = resCon.replaceAll(regexList.get(i).toString(), paramList.get(i).toString());
			}
		}
		try {
			CreateFileUtils.writeData2file(filePath, writeFileName, resCon, bufferSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			//SRVCINST94106 
			//SRVCINST94074 
			//SRVCINST94042 
			//SRVCINST94010 
			//SRVCINST93978 
			//SRVCINST93946 
			//SRVCINST93914 
			//SRVCINST93882 
			//SRVCINST93850
			//SRVCINST93818 
			//SRVCINST93786 
			//SRVCINST93754 
			//SRVCINST93722 
			//SRVCINST93690 
			//SRVCINST93658 
			//SRVCINST93626 
			//SRVCINST93594 
			//SRVCINST93562
			//SRVCINST93530 
			//SRVCINST93498 
			//SRVCINST93466 
			//SRVCINST93434
	public static void main(String[] agrs) throws IOException{
		AutoCreateSQLImpl as = new AutoCreateSQLImpl();
		String startInstId = "SRVCINST94266";//SRVCINST94170
		String content = as.loadFileToString(filePath,readerFileName);
		List instIdList = as.createInstId(startInstId,32);
		String regex = "'SRVCINST.*?\\d'";//此参数可以使用SCVcode BUScode……
		String resCon = as.replaceStr(content,regex,instIdList);
		try {
			CreateFileUtils.writeData2file(filePath, writeFileName, resCon, bufferSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
