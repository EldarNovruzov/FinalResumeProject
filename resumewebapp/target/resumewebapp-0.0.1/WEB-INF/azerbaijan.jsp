<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.*" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/10/2020
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Azerbaijan</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>



    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.debug.js" integrity="sha384-NaWTHo/8YCBYJ59830LTz/P4aQZK1sS0SneOgAvhsIl3zBu8r9RevNg5lHCHAuQ/" crossorigin="anonymous"></script>--%>
    <%--<script type="text/javascript" src="html2canvas.js"></script>--%>

    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">

    <script src="https://kendo.cdn.telerik.com/2017.2.621/js/jquery.min.js">

    </script>
    <script src="https://kendo.cdn.telerik.com/2017.2.621/js/jszip.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2017.2.621/js/kendo.all.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/azerbaijanCss.css">
    <script src="${pageContext.request.contextPath}/assets/js/azerbaijanJS.js"></script>

<script>
    window.addEventListener('load', function() {
        document.querySelector('input[type="file"]').addEventListener('change', function() {
            if (this.files && this.files[0]) {
                var img = document.getElementById('myImg');  // $('img')[0]
                img.src = URL.createObjectURL(this.files[0]); // set src to blob url
                img.onload = imageIsLoaded;
            }
        });
    });

    function imageIsLoaded() {
        document.getElementById("forConfiguration").value="";
        alert(this.src);
    }

</script>
</head>
<body>

<form method="get" id="my_form11" action="menu">
</form>

<form method="get" id="my_form10" action="search">
</form>

<form method="get" id="my_form12" action="getContact">
</form>

<form action="logout" id="my_form13" method="post">
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
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form10').submit();">Back <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form11').submit();">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form12').submit();">Contact</a>
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
                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form13').submit();">Logout</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>

<br>

<div class="container content-wrapper" id="main">


    <div class="row" id="background-image">
        <div class="form-group col-md-4" >
            <input type='file' id="forConfiguration"/>
            <div class="img">
                <br><img id="myImg" src="#" alt="your image" height=150px width=150px style="border-radius: 50%">
            </div>
        </div>
        <div class="form-group col-md-8">
            <div>
                <br>
                <h1 class="text-center">
                    ${user.name} ${user.surname}
                </h1>
            </div>
            <br>
            <br>
            <br>
            <br>
            <div>
                <h2 class="text-center">
                    ${employmentHistoryListForCreateResume.get(0).header}
                </h2>
            </div>
        </div>
    </div>
    <pre>

<br>


            <table class="table-borderless">
                <thead>
                <tr></tr>
                </thead>
                <tbody>
                <tr><td><h3>Email</h3></td>
                <td>&ensp;${user.email}</td>
                    <td style="padding-left: 170px"><h3>Phone</h3></td><td >&ensp;  ${user.phone}</td></tr>
                <tr>
                    <td><h3>Date/Place of birth</h3></td>
                    <td>&ensp;${user.birthDate}/
                        ${user.birthplace.name}</td>
                    <td style="padding-left: 170px"><h3>Nationality</h3></td><td >&ensp;&ensp;&ensp;${user.nationality.nationality}</td>
                </tr>
                <tr>
                    <td><h3>Links</h3></td>
                    <td>
                        <c:forEach items="${user.socialLinkList}" var="lst">
                            <a href="${lst.link}">-${lst.label}-</a>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
            </table>
        <hr>
<div class="row">
    <%User users=(User)request.getAttribute("user");%>
    <%if(!users.getProfileDesc().trim().isEmpty()){%>
            <table class="table-borderless">
                <thead>
                <tr>
                    <th style="padding-left: 15px"><h3>Profile</h3></th>
                </tr>
                </thead>
                <tbody>
                <tr class="d-flex"><td class="col-2"></td>
                <td class="col-10" style="padding-left: 1px" width="500">${user.profileDesc}</td></tr>
                </tbody>
            </table>
<%}%>

    <%List<EmploymentHistory> employmentHistories=users.getEmploymentHistoryList();
    int i=0;
    if(employmentHistories.get(i).getHeader()!=null
    || employmentHistories.get(i).getBeginDate()!=null
    ||employmentHistories.get(i).getEndDate()!=null
    ||employmentHistories.get(i).getJobDescription()!=null){%>


            <div class="form-group">
                    <table class="table-borderless">
                        <thead>
                        <tr>
                            <th style="padding-left: 15px"><h3>Experience</h3></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${employmentHistoryListForCreateResume}" var="uj">
                        <tr class="d-flex">
                            <td style="padding-left: 25px" class="col-5">${uj.beginDate}/${uj.endDate}</td>
                            <td style="padding-left: 90px" class="col-7">
                            <h4 style="font-weight: bold;">${uj.header}</h4></td>
                        </tr>
                        <tr class="d-flex"><td class="col-5"></td><td class="col-7" style="padding-left: 50px">${uj.jobDescription}<hr></td></tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
        <%i++;
            }%>


    <%List<EducationHistory> educationHistories=users.getEducationHistoryList();
        int ij=0;
        if(educationHistories.get(ij).getEducationHeader()!=null
                || educationHistories.get(ij).getBeginDate()!=null
                ||educationHistories.get(ij).getEndDate()!=null
                ||educationHistories.get(ij).getLocatedPlace()!=null
        ||educationHistories.get(ij).getEducationDegree()!=null
        ||educationHistories.get(ij).getEducationDescription()!=null){%>
            <div class="form-group">
                    <table class="table-borderless">
                        <thead>
                        <tr>
                            <th style="padding-left: 15px"><h3>Education</h3></th>
                        </tr>
                        </thead>
                        <tbody>
                                <c:forEach items="${user.educationHistoryList}" var="ujs">
                        <tr class="d-flex">
                            <td style="padding-left: 25px" class="col-5">${ujs.beginDate}/${ujs.endDate}</td>
                            <td style="padding-left: 110px" class="col-7">
                            <h4 style="font-weight: bold;">${ujs.educationHeader}</h4></td>
                        </tr>
                                    <tr class="d-flex">
                                        <td style="padding-left: 25px" class="col-5">${ujs.locatedPlace}</td>
                                        <td style="padding-left: 110px" class="col-7">${ujs.educationDegree}</td>
                                    </tr>
                                    <tr class="d-flex">
                                        <td class="col-5"></td>
                                        <td style="padding-left: 110px" class="col-7">${ujs.educationDescription}<hr></td>
                                    </tr>
                                </c:forEach>
                        </tbody>

                    </table>
                </div>

    <%ij++;
        }%>

    <%List<UserSkill> userSkills=users.getUserSkillList();
        int in=0;
        if(userSkills.get(in).getPower()!=null
                || userSkills.get(in).getSkill().getName()!=null){%>
                <table class="table-borderless">
                <thead>
                <tr>
                    <th style="padding-left: 15px"><h3>Skills</h3></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSkill}" var="ur">
                <tr class="d-flex">
                    <td class="col-6" style="padding-left: 15px">

                    <p class="wide">${ur.skill.name}</p>
                    </td><td class="col-6">
                    <div class="back skillbar clearfix" data-percent="${ur.power*10}%">
                        <div class="skill skillbar-bar" style="height:26px;width:0%;">${ur.power*10}%</div>
                    </div>
                <hr></td></tr>
                </tbody>
                </c:forEach>
            </table>
    <%in++;
    }%>

<%List<Course> courses=users.getCourseList();
    int iq=0;
    if(courses.get(iq).getCourseName()!=null
            || courses.get(iq).getBeginDate()!=null
            ||courses.get(iq).getEndDate()!=null
            ||courses.get(iq).getInstitution()!=null){%>
        <div class="form-group">
                    <table class="table-borderless">
                        <thead>
                        <tr>
                            <th style="padding-left: 15px"><h3>Courses</h3></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user.courseList}" var="qer">
                        <tr class="d-flex">
                            <td style="padding-left: 25px" class="col-5">${qer.beginDate}/${qer.endDate}</td>
                            <td style="padding-left: 110px" class="col-7">
                            <h4 style="font-weight: bold;">${qer.courseName}</h4></td>
                        </tr>
                        <tr class="d-flex"><td class="col-5"></td>
                            <td style="padding-left: 110px" class="col-7">${qer.institution}<hr></td>
                        </tr>
                        </tbody>
                                </c:forEach>
                    </table>
                </div>
    <%iq++;
    }%>

<%List<ExtraCurricularActivities> extraCurricularActivities=users.getExtraCurricularActivitiesList();
    int iqn=0;
    if(extraCurricularActivities.get(iqn).getActivitiesHeader()!=null
            || extraCurricularActivities.get(iqn).getBeginDate()!=null
            ||extraCurricularActivities.get(iqn).getEndDate()!=null
            ||extraCurricularActivities.get(iqn).getEmployer()!=null
    ||extraCurricularActivities.get(iqn).getActivitiesDescription()!=null
    ||extraCurricularActivities.get(iqn).getCityName()!=null){%>
        <div class="form-group">
                    <table class="table-borderless">
                        <thead>
                        <tr>
                            <th style="padding-left: 15px"><h3>Extra-curricular Activities</h3></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user.extraCurricularActivitiesList}" var="ret">
                            <tr class="d-flex">
                            <td style="padding-left: 25px" class="col-5">${ret.beginDate}/${ret.endDate}</td>
                            <td style="padding-left: 110px" class="col-7">
                            <h4 style="font-weight: bold;">${ret.activitiesHeader}</h4></td>
                        </tr>
                        <tr class="d-flex"><td style="padding-left: 25px" class="col-5">${ret.employer}</td>
                        <td style="padding-left: 110px" class="col-7">${ret.activitiesDescription}</td>
                        </tr>
                            <tr class="d-flex">
                                <td style="padding-left: 25px" class="col-5">${ret.cityName}<hr></td>
                            </tr>
                        </tbody>
                                    </c:forEach>
                    </table>
                </div>
    <%iqn++;
    }%>

    <%List<Reference> referenceList=users.getReferenceList();
        int itn=0;
        if(referenceList.get(itn).getReferentFullName()!=null
                || referenceList.get(itn).getReferentPhone()!=null
                ||referenceList.get(itn).getReferentCompanyName()!=null
                ||referenceList.get(itn).getReferentEmail()!=null){%>

        <div class="form-group">
                    <table class="table-borderless">
                        <thead>
                        <tr>
                            <th style="padding-left: 15px"><h3>References</h3></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user.referenceList}" var="ist">
                        <tr class="d-flex"><td class="col-5" style="padding-left: 25px">${ist.referentFullName}</td>
                            <td class="col-7">${ist.referentPhone}</td>
                        </tr>
                        <tr class="d-flex"><td class="col-5" style="padding-left: 25px">${ist.referentCompanyName}</td>
                            <td class="col-7">${ist.referentEmail}<hr></td></tr>
                        </tbody>
                                    </c:forEach>
                    </table>
                </div>
    <%itn++;
    }%>

<%List<UserLanguage> usersUserLanguageList=users.getUserLanguageList();
    int iln=0;
    if(usersUserLanguageList.get(iln).getLanguageLevel()!=null
            || usersUserLanguageList.get(iln).getLanguageId().getName()!=null){%>
    <table class="table-borderless">
                <thead>
                <tr>
                    <th style="padding-left: 15px"><h3>Languages</h3></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.userLanguageList}" var="urs">
                <tr class="d-flex"><td class="col-6" style="padding-left: 15px">

                    <p class="wide">${urs.languageId.name}</p>
                    </td><td class="col-6">
                    <div class="back skillbar clearfix" data-percent="${urs.languageLevel*10}%">
                        <div class="skill skillbar-bar" style="height:26px;width:0%;">${urs.languageLevel*10}%</div>
                    </div>
                <hr></td></tr>
                </tbody>
                </c:forEach>
            </table>
    <%iln++;
    }%>

    <%if(!users.getUserHobby().trim().isEmpty()){%>
     <table class="table-borderless">
                <thead>
                <tr>
                    <th style="padding-left: 15px"><h3>Hobbies</h3></th>
                </tr>
                </thead>
                <tbody>
                <tr class="d-flex"><td class="col-2"></td><td class="col-10" style="padding-left: 80px">${user.userHobby}</td></tr>
                </tbody>
            </table>

<%}%>

    </div>

</pre>

            </div>

<footer>

<pre>
    <div class="row d-flex justify-content-center">
        <button class="btn btn-primary export-pdf">DOWNLOAD</button>
    </div>

</pre>

</footer>


</body>
</html>
