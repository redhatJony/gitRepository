<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"  src="jsdemo/dateutils.js"></script>
<script type="text/javascript" src="jsdemo/jquery-1.8.3.js"></script>
<meta http-equiv="Content-Type" content="text/javascript; charset=UTF-8">
<style type="text/css">  
 #divframe{ border:1px solid #999; width:500px; margin:0 auto;}  
 .loadTitle{ background:#CCC; height:30px;}  
</style> 
<script type="text/javascript">

</script>
<title>index</title>
</head>
<body>

<input type="button" onClick="showdate();" value="显示时间">

<form action="<%=basePath%>user/getUserJedis" method="get">
  		userId: <input type="text" name="id" />
  		<input type="submit" value="Submit" />
</form>
<form action="<%=basePath%>fileThread/writeData2File" method="get">
  		qryType: <input type="text" name="qryType" />
  		content: <input type="text" name="content" />
  		<input type="submit" value="Submit" />
</form>
<form action="<%=basePath%>autoCreateSQL/replaceStr" method="post">
  		serviceInstId: <input type="text" name="serviceInstId" />
  		<!-- serviceInstIdRegex :  <input type="text" name="serviceInstIdRegex" /> -->
  		<br>
  		busCode: <input type="text" name="busCode" />
  		<!-- busCodeRegex: <input type="text" name="busCodeRegex" /> -->
  		<br>
  		svcCode: <input type="text" name="svcCode" />
  		<!-- svcCodeRegex: <input type="text" name="svcCodeRegex" /> -->
  		<br>
  		serviceContractVer: <input type="text" name="serviceContractVer" />
  		<!-- serviceContractVerRegex: <input type="text" name="serviceContractVerRegex" /> -->
  		<br>
  		<input type="submit" value="Submit" />
</form>
<form action="<%=basePath%>autoCreateSQL/insertIntoRedis" method="post">
  		BusCode: <input type="text" name="BusCode" />
  		ServiceCode: <input type="text" name="ServiceCode" />
  		<input type="submit" value="Submit" />
</form>
<form action="<%=basePath%>user/putCache" method="post">
  		key: <input type="text" name="key" />
  		value: <input type="text" name="value" />
  		<input type="submit" value="Submit" />
</form>
</body>
</html>