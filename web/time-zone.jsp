<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Web Services Application</title>
</head>
<body>
<center>
    <h1>Time zone by Zip code</h1>
    <h2>
        <a href="/">Home</a>
    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Time Zone info</h2></caption>
        <tr>
            <th>Zip code</th>
            <th>Timezone identifier</th>
            <th>Timezone abbreviation</th>
        </tr>
            <tr>
                <td>
                    <%=request.getAttribute("parsed-zip-code")%>
                </td>
                <td>
                    <%=request.getAttribute("timezone-identifier")%>
                </td>
                <td>
                    <%=request.getAttribute("timezone-abbr")%>
                </td>

            </tr>
    </table>

</div>
</body>
</html>
