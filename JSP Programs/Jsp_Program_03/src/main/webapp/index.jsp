<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of Two Numbers</title>
</head>
<body>

<h2>Add Two Numbers</h2>

<form method="post">
    Enter First Number:
    <input type="text" name="num1" required><br><br>

    Enter Second Number:
    <input type="text" name="num2" required><br><br>

    <input type="submit" value="Add">
</form>

<%
    String n1 = request.getParameter("num1");
    String n2 = request.getParameter("num2");

    if (n1 != null && n2 != null && !n1.trim().isEmpty() && !n2.trim().isEmpty()) {
        try {
            int a = Integer.parseInt(n1.trim());
            int b = Integer.parseInt(n2.trim());
            int sum = a + b;
%>

<h3>Sum = <%= sum %></h3>
<h3>Mohit Kumar (24SCSE2030379)</h3>

<%
        } catch (NumberFormatException e) {
%>
<h3 style="color:red;">Please enter valid numbers only!</h3>
<%
        }
    }
%>

</body>
</html>
