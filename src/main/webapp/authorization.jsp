<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Загадки!</title>
    <link rel="stylesheet" href="style_two.css">
</head>
<body>
<form id="myForm" method="post" action="/web/auth">
    <h3>
        Введите ваш логин:
    </h3>
    <input type="text" name="login"/>
    <h3>
        Введите ваш пароль:
    </h3>
    <input type="password" name="password"/>
    <input type="submit" value="Войти"/>
</form>

</body>
</html>
