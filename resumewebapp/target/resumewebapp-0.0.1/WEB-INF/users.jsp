<%--
    Document   : user
    Created on : Feb 6, 2019, 8:20:34 PM
    Author     : Acer
--%>

<%@page import="java.util.List"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/users.css">
    <script src="${pageContext.request.contextPath}/assets/js/users.js"></script>

</head>
<body>
<form method="get" id="my_form21" action="menu">
</form>

<form method="get" id="my_form22" action="menu">
</form>

<form method="get" id="my_form23" action="getContact">
</form>

<form action="logout" id="my_form24" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/assets/image/encFavicon.ico" height="50" alt="ENC"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form21').submit();">Back <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form22').submit();">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form23').submit();">Contact</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="far fa-user fa-lg"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <%--<a class="dropdown-item" href="#">Delete Account</a>--%>
                        <%--<div class="dropdown-divider"></div>--%>
                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form24').submit();">Logout</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>

<br>
<div class="container mycontainer">
    <div class="col-12 row">
        <div class="col-4">

            <form:form action="usersM" method="GET" modelAttribute="user">

                <div class="form-group">
                    <label>Name:</label>
                    <form:input
                            onkeyup="writeWhatIamTyping()"
                            placeholder="Enter name:"
                            class="form-control"
                            path="name"/>
                    <form:errors path="name"/>
                </div>


                <div class="form-group">
                    <label>Surname:</label>
                    <form:input
                            placeholder="Enter surname:"
                            class="form-control"
                            path="surname"/>
                    <form:errors path="surname"/>
                </div>

                <form:button
                        class="btn btn-primary"
                        type="submit"
                        value="Search"
                        id="btnsearch">Search</form:button>

            </form:form>

        </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="u">
                <tr>
                    <td>${u.name}</td>
                    <td>${u.surname}</td>
                    <td>${u.nationality.nationality}</td>
                    <td style="width: 5px">

                        <input type="hidden" name="id" value="<${u.id}>"/>
                        <input type="hidden" name="action" value="delete">
                        <button class="btn btn-danger" type="submit" value="delete"
                                data-toggle="modal" data-target="#exampleModalLong" onclick="setIdForDelete('${u.id}')">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                    <td style="width: 5px">
                        <form:form action="userdetail" method="POST" modelAttribute="user">
                            <form:hidden path="id" value="${u.id}"/>
                            <%--<form:hidden path="action" value="update"/>--%>
                            <button class="btn btn-secondary" type="submit" value="update">
                                <i class="fas fa-pen-square"></i>
                            </button>
                        </form:form>
                    </td>
                    <td style="width: 5px">
                        <form:form action="forCreateResume" method="POST" modelAttribute="userInform">
                            <form:hidden path="idInform" value="${u.id}"/>
                            <form:hidden path="actionInform" value="create"/>
                            <button class="btn btn-secondary" type="submit" value="create">
                                <i class="fas fa-user-edit"></i>
                            </button>
                        </form:form>
                    </td>
                </tr>

            </tbody>
            </c:forEach>
        </table>


    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <form:form action="userdelete" method="POST" modelAttribute="userDeleteForm">
                        <input type="hidden" name="id" value="" id="idForDelete"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>


</div>


</body>
</html>