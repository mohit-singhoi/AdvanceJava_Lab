<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .profile {
            width: 400px;
            margin: 60px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px gray;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        p {
            font-size: 16px;
        }
    </style>
</head>
<body>

<div class="profile">
    <h2>User Profile</h2>

    <%
        String name = "Mohit Kumar";
        String roll = "24SCSE2030379";
        String email = "mohitsinghoi501@gmail.com";
        int sec =5;
        String sem ="3rd Sem";
        String course = "Master's in Computer Application (MCA)";
        String college = "Galgotias  University";
        String year ="2024-2026";
        
        
     
    %>

    <p><b>Name:</b> <%= name %></p>
    <p><b>Roll No:</b> <%= roll %></p>
    <p><b>Course:</b> <%= course %></p>
    <p><b>Section:</b> <%= sec %></p>
    <p><b>Email:</b> <%= email %></p>
     <p><b>Semester:</b> <%= sem %></p>
    <p><b>University:</b> <%= college %></p>
    <p><b>Session:</b> <%= year %></p>
</div>

</body>
</html>
