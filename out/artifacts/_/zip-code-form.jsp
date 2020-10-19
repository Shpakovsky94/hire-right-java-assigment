<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Web Services Application</title>
</head>
<body>
<center>
    <h1>Zip code</h1>
    <h2>
        <a href="/">Home</a>
    </h2>
</center>

<div align="center">
    <h2>Write any American zip code to find the Time zone info:</h2>
    <h3>For example: 10001, 80203, 90231</h3>
    <form action = "search-time-zone" method = "post">
        Zip code: <input type = "text" name = "zip-code">
        <br />
        <input type = "submit" value = "Submit" />
    </form>

</div>
</body>
</html>
