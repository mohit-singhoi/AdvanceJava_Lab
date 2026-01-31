<%-- 

<%@ page contentType="text/html" %>
<html>
<head>
    <title>Powers of 2 Result</title>
</head>
<body>
    <h2>Powers of 2 from 0 to 10</h2>

    <table border="1" cellpadding="8">
        <tr>
            <th>Number (n)</th>
            <th>2<sup>n</sup></th>
        </tr>

        <%
            for(int i = 0; i <= 10; i++) {
                int power = (int)Math.pow(2, i);
        %>
        <tr>
            <td><%= i %></td>
            <td><%= power %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html> --%>



<%@ page contentType="text/html" %>
<html>
<head>
    <title>Powers of 2 Result</title>
</head>
<body>
    <h2>Powers of 2 </h2>

    <%
        int n = Integer.parseInt(request.getParameter("n"));
    %>

    <table border="1" cellpadding="8">
        <tr>
            <th>Number (i)</th>
            <th>2<sup>i</sup></th>
        </tr>

        <%
            for(int i = 0; i <= n; i++) {
                int power = (int)Math.pow(2, i);
        %>
        <tr>
            <td><%= i %></td>
            <td><%= power %></td>
        </tr>
        <%
            }
        
        %>
    </table>
    </br>
    <h3>Mohit Kumar </br> 24SCSE2030379</h3>
</body>
</html>

