<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
 hello My SpringMVC!<br> 
 <table border="1">
  <tr>
    <th>属性</th>
    <th>值</th>
  </tr>
  <tr>
    <td>id</td>
    <td>${user.id }</td>
  </tr>
  <tr>
    <td>name</td>
    <td>${user.workername }</td>
  </tr>
  <tr>
    <td>salary</td>
    <td>${user.salary }</td>
  </tr>
   <tr>
    <td>tel</td>
    <td>${user.tel }</td>
  </tr>
   <tr>
    <td>mailbox</td>
    <td>${user.mailbox }</td>
  </tr>
</table>
</body>
</html>