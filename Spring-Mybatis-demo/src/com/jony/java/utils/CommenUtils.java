package com.jony.java.utils;

import java.util.Map;


public class CommenUtils {
	public static final String SAOP_SERVICE_JUDGE_ELEMENT = "BusCode,ServiceCode,SrcOrgID,SrcSysID,DstOrgID,DstSysID"; //依次为：业务编码、服务编码、发起方机构代码、发起方(系统/平台)编码、落地方机构编码、落地方(系统/平台)编码
	public static final String SAOP_SERVICE_JUDGE_ELEMENT_DB = "BUS_CODE,SERVICE_CODE,SRC_ORG_ID,SRC_SYS_ID,DST_ORG_ID,DST_SYS_ID"; //顺序必须完全同SAOP_SERVICE_JUDGE_ELEMENT
	public static final String RETURN_MSG_CONTENT = "RETURN_MSG_CONTENT";
	
	public static String getSaopServiceJudgeKeyElement(Object tcpContObject, Map<String, String> map) {
		String keyElement = "";
		String returnMsg = "";
		if (null != tcpContObject) {
			if (tcpContObject instanceof Map) {
				Map<String, String> tcpContMap = (Map) tcpContObject;
				String[] elementArray = SAOP_SERVICE_JUDGE_ELEMENT.split(",");
				String elementText = "";
				for (String element : elementArray) {
					elementText = tcpContMap.get(element);
					if (null != elementText && !"".equals(elementText)) {
						keyElement += elementText;
						if (null != map) {
							returnMsg += element + "=" + elementText + ",";
						}
					}
				}
				if (null == elementText || "".equals(elementText)) {
					elementArray = SAOP_SERVICE_JUDGE_ELEMENT_DB.split(",");
					for (String element : elementArray) {
						elementText = tcpContMap.get(element);
						if (null != elementText && !"".equals(elementText)) {
							keyElement += elementText;
							if (null != map) {
								returnMsg += element + "=" + elementText + ",";
							}
						}
					}
				}
			}
			if (null != map) {
				if (!"".equals(returnMsg)) {
					returnMsg = returnMsg.substring(0, returnMsg.length() - 1);
				}
				map.put(RETURN_MSG_CONTENT, returnMsg);
			}
		}
		return keyElement;
	}
}
