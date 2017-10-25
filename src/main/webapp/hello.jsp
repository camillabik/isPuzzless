
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Загадки!</title>
    <link rel="stylesheet" href="style_one.css">
</head>
<body>
<form id="myForm" method="post" action="/web/auth">
    <h1>Загадки</h1>
    <h2>Выбери категорию:</h2>
    <form action="">
        <a href="http://localhost:8080/music.jsp">
    <button type="button">Музыка</button>
        </a>
        <a href="http://localhost:8080/math.jsp">
    <button type="button">Математика</button>
        </a>
    <%--<input type="text" name="login"/>--%>
    <%--<input type="password" name="password"/>--%>
    <%--<input type="submit" value="login">--%>
</form>

</body>
</html>
