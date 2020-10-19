<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<html>
<head>
    <title>Web Services Application</title>
</head>
<body>
<center>
    <h1>Forecast</h1>
    <h2>
        <a href="/">Home</a>
    </h2>
</center>

<div align="center">
    <h2>Write city name to find the current weather forecast info:</h2>
    <h3>For example: Tallinn</h3>
    <form action = "search-forecast" method = "post">
        Zip code: <input type = "text" name = "city-name">
        <br />
        <input type = "submit" value = "Submit" />
    </form>

</div>
</body>
</html>
