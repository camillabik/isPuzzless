
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Загадки!</title>
    <link rel="stylesheet" href="style_two.css">
  </head>
  <body>
  <form id="myForm" method="post" action="/web/reg">
        <h3>
          Введите вашe имя:
      </h3>
      <input type="text" name="name"/>
      <h3>
          Введите ваш логин:
      </h3>
      <input type="text" name="login"/>
    <h3>
      Введите ваш пароль:
    </h3>
    <input type="password" name="password"/>
      <%--<a href="http://localhost:8080/hello.jsp">--%>
    <input type="submit" value="Зарегистрироваться"/>
      <%--</a>--%>

  </form>

  </body>
</html>





