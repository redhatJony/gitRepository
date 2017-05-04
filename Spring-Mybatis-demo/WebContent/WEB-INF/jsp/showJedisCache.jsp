<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL技术循环集合 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
 hello My SpringMVC!<br> 
 <table border="1">
   <%--<tr>
    <th>属性</th>
    <th>值</th>
  </tr>
  <tr>
    <td>name</td>
    <td>${jedisName}</td>
  </tr>
  <tr>
    <td>password</td>
    <td>${password}</td>
  </tr> --%>
    <c:forEach var="item" items="${jedisHashMap}"> 
	  	<tr>
	      <th>map键名：${item.key}</th>
	      　　<th>map键值： ${item.value}</th>
	    </tr> 
	</c:forEach>
</table>
</body>
</html>