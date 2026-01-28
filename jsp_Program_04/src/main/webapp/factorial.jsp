<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Factorial Result</title>
</head>
<body>

<%
    String n = request.getParameter("num");

    if (n != null) {
        int num = Integer.parseInt(n);
        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
%>

<h2>Factorial Result</h2>
<h3>Factorial of <%= num %> is <%= fact %></h3>
<h4>Mohit Kumar (24SCSE2030379)</h4>

<%
    }
%>

</body>
</html>
