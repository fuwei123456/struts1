<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ok.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>你的注册信息是</h1>
    <bean:define id="info" name="registerForm"></bean:define>
    <div>
    	用户名：<bean:write name="info" property="user"/>
    </div>
    <div>
    	密码：<bean:write name="info" property="pwd"/>
    </div>
    <div>
    	邮箱：<bean:write name="info" property="email"/>
    </div>
    <div>
    	性别：<logic:equal name="info" property="gender" value="1">男</logic:equal>	 
    	<logic:equal name="info" property="gender" value="0" >女</logic:equal>
    </div>
    <div>
    	学历：<bean:write name="info" property="education"/>
    </div>
    <div>
    	爱好：
    	<logic:notEmpty name="info" property="hobbies" >
    		<logic:iterate id="hobby" name="info" property="hobbies">
    			<ol><bean:write name="hobby"></bean:write></ol>
    		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="info" property="hobbies">
    		<div>没有爱好</div>
    	</logic:empty>
    </div>
  </body>
</html>
