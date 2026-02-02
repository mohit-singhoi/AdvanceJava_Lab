<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
</head>  
<body>  
  
<%@page import="max.UserDao,max.User,java.util.*"%>  

 
  
<h1>Users List</h1>  
  <table border="1" width="90%"> 
<%  
List<User> list=UserDao.getAllRecords();  
request.setAttribute("list",list); 

%>  
 
<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th>  
<th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr>

<%
for(User l: list)
{
%>

 
<tr><td><%=l.getId() %></td><td><%=l.getName() %></td><td><%=l.getPassword() %></td>  
<td><%=l.getEmail()%></td><td><%=l.getSex() %></td><td><%=l.getCountry() %></td>  
<td><a href="editform.jsp?id=<%=l.getId() %>">Edit</a></td>  
<td><a href="deleteuser.jsp?id=<%=l.getId() %>">Delete</a></td></tr>  
 

<%} %>


  
</table>  
<br/><a href="adduserform.jsp">Add New User</a>  
  
</body>  
</html>  