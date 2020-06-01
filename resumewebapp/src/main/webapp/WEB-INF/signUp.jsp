<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/18/2020
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
    <title>Sign Up</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signUpCss.css">
    <style>
        .login_background{
            background: url("https://www.hr.com/portals/hrcom/Page/images/Cover-photos/HRcom-HomeSplash.jpg") ;
        }

        .login_fix_{
            background: #fffdfd40;
            border: white;
            padding-top: 172px;
            font-style: italic;
            color: aliceblue;
            width: 660px;
            height: 660px;
        }
    </style>

</head>
<body class="login_background">

<form:form action="signUpController" method="POST" modelAttribute="signUpForm">
    <div class="col-4 container login_fix_">
        <center>
            <h1>Sign Up:</h1>
        </center>
        <div class="form-group">
            <label>Name</label>
            <form:input type="text" class="form-control" placeholder="Name" path="name"/>
        </div>
        <div class="form-group">
            <label>Surname</label>
            <form:input type="text" class="form-control" placeholder="Surname" path="surname"/>
        </div>
        <div class="form-group">
            <label>Email address</label>
            <form:input type="email" class="form-control" placeholder="email@example.com" path="email"/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <form:input type="password" class="form-control" placeholder="Password" path="password"/>
        </div>
        <form:hidden  path="role" value="USER"/>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <form:button type="submit" class="btn btn-warning" name="signUp">Sign Up</form:button>
    </div>
</form:form>

</body>
</html>

