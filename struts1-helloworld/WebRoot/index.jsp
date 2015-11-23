<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  	<html:form action="/register.do">
  		<table>
  			<tr><td>注册</td></tr>
  			<tr>
  				<td>
  					用户名
  				</td>
  				<td>
  					<html:text property="user" maxlength="20"></html:text>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					密 码
  				</td>
  				<td>
  					<html:password property="pwd" maxlength="20"></html:password>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					性 别
  				</td>
  				<td>
  					<html:radio property="gender" value="1">男</html:radio>
  					<html:radio property="gender" value="0">女</html:radio>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					邮 箱
  				</td>
  				<td>
  					<html:text property="email" maxlength="50"></html:text>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					爱 好
  				</td>
  				<td>
  					<html:checkbox property="hobbies" value="看书">看书</html:checkbox>
  					<html:checkbox property="hobbies" value="音乐">音乐</html:checkbox>
  					<html:checkbox property="hobbies" value="游戏">游戏</html:checkbox>
  					<html:checkbox property="hobbies" value="电影">电影</html:checkbox>
  					<html:checkbox property="hobbies" value="购物">购物</html:checkbox>
  					<html:checkbox property="hobbies" value="钓鱼">钓鱼</html:checkbox>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					学 历
  				</td>
  				<td>
  					<html:select property="education">
  						<html:option value="-1">请选择</html:option>
  						<html:option value="研究生">研究生</html:option>
  						<html:option value="大学">大学</html:option>
  						<html:option value="高中">高中</html:option>
  						<html:option value="初中">初中</html:option>
  						<html:option value="小学">小学</html:option>
  					</html:select>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					自我简介
  				</td>
  				<td>
  					<html:textarea property="introduce" rows="8" cols="20"></html:textarea>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<html:submit value="注册"></html:submit>
  					<html:reset value="重置"></html:reset>
  				</td>
  			</tr>
  		</table>
  	</html:form>
  <body>
  	 
  </body>
</html>
