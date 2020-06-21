<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 04.09.2019
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Create Resume</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/createResumeWithTemplatesCss.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">

</head>
<body>
<form method="get" id="my_form41" action="search" >
</form>

<form method="get" id="my_form42" action="menu">
</form>

<form method="get" id="my_form43" action="getContact">
</form>

<form action="logout" id="my_form44" method="post">
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
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form41').submit();">Back <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form42').submit();">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form43').submit();">Contact</a>
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
                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form44').submit();">Logout</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>

<br>

<div class="container body-content">




    <div class="container">

        <center >
            <h2>
                <label>Create your Resume With These Templates</label>

            </h2>
        </center>

        <div class="row justify-content-center" style="padding-top:10px;">

            <div class="card-group">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/forCard.jpeg" alt="Amsterdam Template Image">
                <div class="card-body">
                    <h5 class="card-title">Azerbaijan</h5>
                    <p class="card-text">Choose a job you love, and you will never have to work a day in your life.</p>
                <form:form method="POST" action="getAzerbaijan" modelAttribute="userInform">
                <form:hidden path="idInform" value="${user.id}"/>
                    <form:hidden path="actionInform" value="create"/>
                    <button type="submit" class="btn btn-primary">Select</button>
                </form:form>
                </div>
            </div>


                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/comingSoon.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Berlin</h5>
                        <p class="card-text">Work to become, not to acquire.</p>
                        <button type="submit" class="btn btn-primary">Select</button>
                    </div>
                </div>


                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/comingSoon.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">United Kingdom</h5>
                        <p class="card-text">Find out what you like doing best and get someone to pay you for doing it.</p>
                        <button type="submit" class="btn btn-primary">Select</button>
                    </div>
                </div>

            </div>


        </div>




        <hr>



        <div class="row justify-content-center" style="padding-top:10px;">


            <div class="card-group">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/comingSoon.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Istanbul</h5>
                        <p class="card-text">It's not what you achieve, it's what you overcome. That's what defines your career.</p>
                        <button type="submit" class="btn btn-primary">Select</button>
                    </div>
                </div>


                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/comingSoon.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Moscow</h5>
                            <p class="card-text">Failure doesn't mean you are a failure it just means you haven't succeeded yet.</p>
                            <button type="submit" class="btn btn-primary">Select</button>
                        </div>
                    </div>


                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/assets/image/comingSoon.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Tokyo</h5>
                            <p class="card-text">The best way to predict the future is to create it.</p>
                            <button type="submit" class="btn btn-primary">Select</button>
                        </div>
                    </div>




            </div>

        </div>

    </div>

</div>


<footer class="page-footer font-small teal pt-4" >

    <div class="row">
        <!-- Footer Text -->
        <div class="container-fluid text-center" style="background-color: rgb(0, 150, 136);">

            <img src="${pageContext.request.contextPath}/assets/image/encFavicon.ico" height="100px" alt="ENC">

        </div>
        <!-- Footer Text -->
        <hr class="clearfix w-100 d-md-none pb-3">

    </div>
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3" style="background-color: rgb(0, 120, 109); color: white">© 2020 Powered by:
        <a href="#" style="color: black">ENCompany</a>
    </div>
    <!-- Copyright -->

</footer>

</body>

</html>
