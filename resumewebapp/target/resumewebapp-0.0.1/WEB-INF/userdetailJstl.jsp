
<%--
Document   : user
Created on : Feb 6, 2019, 8:20:34 PM
Author     : Acer
--%>

<%@page import="com.company.entity.Country"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.company.entity.User"%>
<%@ page import="com.company.entity.UserSkill" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<title>User Detail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/userDetailJSTLCss.css">

</head>
<body>

<%
    User u= (User) request.getAttribute("user");
%>
<form method="get" id="my_form31" action="search" >
</form>

<form method="get" id="my_form32" action="menu">
</form>

<form method="get" id="my_form33" action="getContact">
</form>

<form action="logout" id="my_form34" method="post">
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
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form31').submit();">Back <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form32').submit();">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form33').submit();">Contact</a>
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
                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form34').submit();">Logout</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>


<div class="container">
    <hr>
</div>

<div class="container">
    <form:form action="userupdate" method="POST" modelAttribute="userUpdateForm">
    <div>
                <form:hidden path="id" value="<%=u.getId()%>"/>
                <div class="form-group">
                    <label>name:</label>
                    <input placeholder="Enter name:" class="form-control" type="text" name="name" value="<%=u.getName()%>"/>
                </div>
                <div class="form-group">
                    <label>surname:</label>
                    <input placeholder="Enter surname:" class="form-control" type="text" name="surname" value="<%=u.getSurname()%>"/>
                </div>
                <button class="btn btn-primary" type="submit" name="save" >Save</button>
            </div>
            <hr/>



<div>
<ul class="nav nav-tabs" role="tablist">
<li class="active"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Details</a></li>
</ul>

<div class="tab-content">
<div id="home" class="tab-pane fade show active">
<table class="table">
<thead>
<tr>
<th>Email</th>
<th>Phone</th>
<th>Address</th>
<th>BirthDate</th>
<th>Country</th>
<th>Nationality</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type="text" class="form-control" name="email" placeholder="Enter Email"
           value="<%=u.getEmail()%>"/>
    </td>
<td><input type="text" class="form-control" name="phone" placeholder="Enter Phone"
           value="<%=u.getPhone()%>"/>
    </td>
<td><input type="text" class="form-control" name="address" placeholder="Enter Address"
           value="<%=u.getAddress()%>"/>
    </td>
<td><input type="date" class="form-control" name="birthDate" placeholder="Enter Birth Date"
           value="<%=u.getBirthDate()%>"/>
    </td>
<td><input type="text" class="form-control" name="country" placeholder="Enter Country"
           value="<%=u.getBirthplace().getName()%>"/>
   </td>
<td><input type="text" class="form-control" name="nationality" placeholder="Enter Nationality"
           value="<%=u.getNationality().getNationality()%>"/>
    </td>

</tr>
</tbody>
</table>
</div>


<div id="menu1" class="tab-pane fade active show">
<table class="table">
<thead>
<tr>
<th>Profile Description</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type="text" class="form-control" name="profileDescription" placeholder="Enter Profile Description"
    value="<%=u.getProfileDesc()%>"/>
    </td>
</tr>
</tbody>
</table>
</div>

    <div id="menu3" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Hobbies</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input type="text" class="form-control" name="hobby"
                           placeholder="Enter Hobby:" value="${user.userHobby}"/>
                </td>
            </tr>
            </tbody>
        </table>

    </div>

    <div id="menu4" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Course Name</th>
                <th>Institution</th>
                <th>Begin Date</th>
                <th>End Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.courseList}" var="n">
            <tr>
                <td>
                    <input type="text" class="form-control" name="courseName"
                           placeholder="Enter Course Name:" value="${n.courseName}"/>
                </td>
                <td>
                    <input type="text" class="form-control" name="courseInstitution"
                           placeholder="Enter Institution:" value="${n.institution}"/>
                </td>
                <td>
                    <input type="date" class="form-control" name="courseBeginDate"
                           placeholder="Enter Course Begin Date:" value="${n.beginDate}"/>
                </td>
                <td>
                    <input type="date" class="form-control" name="courseEndDate"
                           placeholder="Enter Course End Date:" value="${n.endDate}"/>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>


    <div id="menu5" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Education Header</th>
                <th>Degree</th>
                <th>Begin Date</th>
                <th>End Date</th>
                <th>Located Place</th>
                <th>Education Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.educationHistoryList}" var="e">
                <tr>
                    <td>
                        <input type="text" class="form-control" name="educationHeader"
                               placeholder="Enter Education Header:" value="${e.educationHeader}"/>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="educationDegree"
                               placeholder="Enter Education Degree:" value="${e.educationDegree}"/>
                    </td>
                    <td>
                        <input type="date" class="form-control" name="educationBeginDate"
                               placeholder="Enter Education Begin Date:" value="${e.beginDate}"/>
                    </td>
                    <td>
                        <input type="date" class="form-control" name="educationEndDate"
                               placeholder="Enter Education End Date:" value="${e.endDate}"/>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="educationLocatedPlace"
                               placeholder="Enter Education Located Place:" value="${e.locatedPlace}"/>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="educationDescription"
                               placeholder="Enter Education Description:" value="${e.educationDescription}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="menu6" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Employment History Header</th>
                <th>Begin Date</th>
                <th>End Date</th>
                <th>Job Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.employmentHistoryList}" var="s">
                <tr>
                    <td>
                        <input type="text" class="form-control" name="employmentHeader"
                               placeholder="Enter Employment Header:" value="${s.header}"/>
                    </td>
                    <td>
                        <input type="date" class="form-control" name="employmentBeginDate"
                               placeholder="Enter Employment Begin Date:" value="${s.beginDate}"/>
                    </td>
                    <td>
                        <input type="date" class="form-control" name="employmentEndDate"
                               placeholder="Enter Employment End Date:" value="${s.endDate}"/>
                    </td>
                    <td>
                        <input type="text" class="form-control"  name="employmentJobDescription"
                               placeholder="Enter Employment Job Description:" value="${s.jobDescription}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="menu7" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Extra Curricular Header</th>
                <th>Employer</th>
                <th>Begin Date</th>
                <th>End Date</th>
                <th>City Name</th>
                <th>Extra Curricular Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.extraCurricularActivitiesList}" var="er">
                <tr>
                    <td>
                        <input type="text" class="form-control" name="extraCurricularHeader"
                               placeholder="Enter Extra Curricular Header:" value="${er.activitiesHeader}"/>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="extraEmployer"
                               placeholder="Enter Employer:" value="${er.employer}"/>
                    </td>
                    <td>
                        <input type="date" class="form-control" name="extraBeginDate"
                               placeholder="Enter Begin Date:" value="${er.beginDate}"/>
                    </td>
                    <td>
                        <input type="date" id="dateChangeable" class="form-control" name="extraEndDate"
                               placeholder="Enter End Date:" value="${er.endDate}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield13" class="form-control" name="extraCityName"
                               placeholder="Enter City Name:" value="${er.cityName}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield12" class="form-control" name="extraDescription"
                               placeholder="Enter Description:" value="${er.activitiesDescription}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="menu8" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Language</th>
                <th>Language Level</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.userLanguageList}" var="ers">
                <tr>
                    <td>
                        <input type="text" id="textfield10" class="form-control" name="languageName"
                               placeholder="Enter Language:" value="${ers.languageId.name}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield11" class="form-control" name="languageLevel"
                               placeholder="Enter Language Level:" value="${ers.languageLevel}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>


    <div id="menu9" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Referent Full Name</th>
                <th>Company Name</th>
                <th>Referent Phone</th>
                <th>Referent Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.referenceList}" var="uy">
                <tr>
                    <td>
                        <input type="text" id="textfield3" class="form-control" name="referentFullName"
                               placeholder="Enter Referent Full Name:" value="${uy.referentFullName}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield4" class="form-control" name="referentCompanyName"
                               placeholder="Enter Referent Company Name:" value="${uy.referentCompanyName}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield5" class="form-control" name="referentPhone"
                               placeholder="Enter Referent Phone:" value="${uy.referentPhone}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield1" class="form-control" name="referentEmail"
                               placeholder="Enter Referent Email:" value="${uy.referentEmail}"/>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="menu10" class="tab-pane fade active show">
        <table class="table">
            <thead>
            <tr>
                <th>Social Link Label</th>
                <th>Link</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user.socialLinkList}" var="rf">
                <tr>
                    <td>
                        <input type="text" id="textfield6" class="form-control" name="linkLabel"
                               placeholder="Enter Link Label:" value="${rf.label}"/>
                    </td>
                    <td>
                        <input type="text" id="textfield7" class="form-control" name="socialLink"
                               placeholder="Enter Link:" value="${rf.link}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

<div id="menu2" class="tab-pane fade active show">
<table class="table">
<thead>
<tr>
<th>Skill Name</th>
<th>Power</th>
</tr>
</thead>
<tbody>

<c:forEach items="${listskill}" var="f">
<tr>
<td><input type="text" id="textfield8" class="form-control" placeholder="Enter Skill Name:" name="skillName"
    value="${f.skill.name}"/>
</td>
<td><input type="text" id="textfield9" class="form-control" placeholder="Enter Skill Power:" name="skillPower"
           value="${f.power}"/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
    </form:form>

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