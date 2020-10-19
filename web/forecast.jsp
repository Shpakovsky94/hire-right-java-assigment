<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Web Services Application</title>
</head>
<body>
<center>
    <h1>Weather forecast by City name</h1>
    <h2>
        <a href="/">Home</a>
    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Forecast info</h2></caption>
        <tr>
            <th>City name</th>
            <th>Region</th>
            <th>Country</th>
            <th>Current Temperature</th>
            <th>Current Condition</th>
            <th></th>
        </tr>
            <tr>
                <td>
                    <%=request.getAttribute("parsed-city")%>
                </td>
                <td>
                    <%=request.getAttribute("region")%>
                </td>
                <td>
                    <%=request.getAttribute("country")%>
                </td>
                <td>
                    <%=request.getAttribute("temp")%>
                </td>
                <td>
                    <%=request.getAttribute("condition")%>
                </td>
                <td>
                    <img src="<%=request.getAttribute("condition-icon")%>">
                </td>

            </tr>
    </table>

</div>
</body>
</html>
