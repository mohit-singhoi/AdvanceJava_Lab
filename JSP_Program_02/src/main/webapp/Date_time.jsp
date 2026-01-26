<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Current Date and Time</title>
</head>
<body>

<h2>Current Date and Time</h2>

<%
    Date currentDate = new Date();
    out.println("Current Date and Time: " + currentDate);
%>

</body>
</html>



