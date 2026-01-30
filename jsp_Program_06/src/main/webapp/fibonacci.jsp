<%@ page contentType="text/html" %>
<html>
<head>
    <title>Fibonacci Result</title>
</head>
<body>
    <h2>Fibonacci Series</h2>

    <%
        int n = Integer.parseInt(request.getParameter("n"));
        int a = 0, b = 1, c;

        out.print(a + " " + b + " ");

        for(int i = 2; i < n; i++) {
            c = a + b;
            out.print(c + " ");
            a = b;
            b = c;
        }
    %>
    </br>
    <h3>Mohit Kumar </br> 24SCSE2030379</h3>
    
</body>
</html>
