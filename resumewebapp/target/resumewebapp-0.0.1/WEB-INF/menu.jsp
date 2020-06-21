<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 18.08.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HRMENU</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
</head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menuCss.css">
<script src="${pageContext.request.contextPath}/assets/js/menuJS.js"></script>

<body>
<%--<div>--%>
    <%--<div>--%>
        <%--<h1>HR MENU</h1>--%>
    <%--</div>--%>

    <%--<form method="GET" action="addUserByMenu">--%>
    <%--<div>--%>
        <%--<button type="submit">Add Person</button>--%>
        <%--&lt;%&ndash;<input type="hidden" name="authenticatedUserRole" value="${userRoleAuthenticated.id}"/>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--</form>--%>


    <%--<form method="GET" action="search">--%>
    <%--<div>--%>
        <%--<button type="submit" >Search Person</button>--%>
    <%--</div>--%>
    <%--</form>--%>
    <%--add all JSP PAGES FOR LOGOUT REMEMBER--%>

    <%--<form action="logout" method="POST">--%>

        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <%--<button type="submit" class="btn btn-primary">Logout</button>--%>
    <%--</form>--%>

<%--</div>--%>

<section id="screen1">

    <p>Scroll down</p>

    <nav>
        <ul>
            <li>
            <form id="my_form1" method="get" action="addUserByMenu">
            <a href="javascript:{}" onclick="document.getElementById('my_form1').submit();">Add Person</a>
                <%--<input type="hidden" name="authenticatedUserRole" value="${userRoleAuthenticated.id}"/>--%>
            </form>
            </li>
            <li>
            <form id="my_form2" method="get" action="search">
            <a href="javascript:{}" onclick="document.getElementById('my_form2').submit();">Search Person</a>
            </form>
            </li>
            <li>
                <form id="my_form4" action="getContact" method="get">
                <a href="javascript:{}" onclick="document.getElementById('my_form4').submit();">Contact</a>
                </form>
            </li>
            <li>
            <form id="my_form3" action="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <a href="javascript:{}" onclick="document.getElementById('my_form3').submit();">Logout</a>
            </form>
            </li>
        </ul>
    </nav>

</section>
<section id="screen2"></section>

</body>
</html>
