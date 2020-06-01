<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 19.02.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
    <style>

        .login_background{
            background: url("https://www.hr.com/portals/hrcom/Page/images/Cover-photos/HRcom-HomeSplash.jpg");
        }

        .login_fix_{
            background: #fffdfd40;
            border: white;
            padding-top: 172px;
            font-style: italic;
            color: aliceblue;
            width: 500px;
            height: 500px;
        }
    </style>

</head>
<body class="login_background">

    <div class="col-4 container login_fix_">
        <form action="login" method="POST">
        <center>
            <h1>Login:</h1>
        </center>
        <div class="form-group">
            <label>Email address</label>
            <input type="email" class="form-control" placeholder="email@example.com" name="username">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" placeholder="Password" name="password">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary" name="login">Login</button>
    </form>
        <div>
        <form action="sign" method="get">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <button type="submit" class="btn btn-info">Sign Up</button>
        </form>
        </div>
    </div>


</body>
</html>
