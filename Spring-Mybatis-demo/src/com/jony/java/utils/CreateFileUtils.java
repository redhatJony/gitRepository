package com.jony.java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class CreateFileUtils {
	/***
	 * 将字符串转换成字符流写入指定路径的文件中，如果路径不存在则新建，如果文件不存在也新建！
	 * @param
	 * @return void
	 * 
	 */
	public static void writeData2file(String filePath,String fileName,String content,int bufferSize) throws Exception{
//		String relativelyPath= Thread.class.getResource("/").getPath();
//		String s = relativelyPath.replace("WEB-INF/class", "");
//		String s1 = System.getProperty("webAppRootValue");
//		String s = s1.replace("WEB-INF/class", "");
		File dir = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath+"/"+fileName);//文件不存在则新建
		} catch (IOException e) {
			throw new Exception("创建文件写入流失败");
		}
        long start = System.currentTimeMillis();
		char[] buffer = new char[bufferSize]; //设缓冲最大值为2048字符
		if(content!=null&&!content.equals("")){
			//字符串转为字符流
			BufferedReader br = new BufferedReader(new StringReader(content));
			BufferedWriter bw = new BufferedWriter(fw); 
			for(int i=0;i<(content.length()/bufferSize);i++){
//				if(i==content.length()/bufferSize){
//					buffer = new char[content.length()%bufferSize];
//				}
				br.read(buffer);
				bw.write(buffer);
				bw.flush();
			}
			//最后一次读取buffer
			buffer = new char[content.length()%bufferSize];
			br.read(buffer);
			bw.write(buffer);
			bw.flush();
			bw.close();
			br.close();
			System.out.println(System.currentTimeMillis()-start);
		}
		fw.close();
	}
	/**
	 *@param filePath 文件路径
	 *@param fileName 文件名
	 *@param codeType 字符编码
	 *加载文件，读取文件内容转换成字符串
	 */
	public String loadFileToString(String filePath, String fileName,String codeType) throws IOException {
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
		try {//设置编码格式GBK
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream,codeType));
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
	public static void main(String[] args) throws Exception{
		String str = "123456789012345678901234567890123456789012345678901234567890123456";
		CreateFileUtils.writeData2file("D:\\data","b.txt",str,1024);
	}
}
