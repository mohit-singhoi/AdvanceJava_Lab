<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="max.UserDao" %>
<jsp:useBean id="obj" class="max.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<%  
int i=UserDao.save(obj);  
if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
}  
%>  