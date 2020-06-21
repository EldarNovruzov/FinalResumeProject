<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 01.09.2019
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
    <title>ADD USER</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/addUser.css">
    <script src="${pageContext.request.contextPath}/assets/js/addUser.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/image/encFavicon.ico">
</head>

<body>

<form method="get" id="my_form61" action="menu" >
</form>

<form method="get" id="my_form62" action="menu">
</form>

<form method="get" id="my_form63" action="getContact">
</form>

<form action="logout" id="my_form64" method="post">
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
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form61').submit();">Back <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form62').submit();">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="javascript:{}" onclick="document.getElementById('my_form63').submit();">Contact</a>
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
                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form64').submit();">Logout</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>


<div class="container">
    <hr>
</div>


<div class="container warning">
    <p><strong>Warning!</strong> I hope that this project
        will play an important role in your business life.
        Good Luck!!!</p>
</div>

    <div class="container">

    <form method="GET" action="addUserOneByOne">
        <hr>
        <div class="form-group">
            <label>name:</label>
            <input placeholder="Enter name:" class="form-control" type="text" name="name"/>
        </div>

        <hr>
        <div class="form-group">
            <label>surname:</label>
            <input placeholder="Enter surname:" class="form-control" type="text" name="surname"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Email address</label>
            <input type="email" class="form-control" placeholder="email@example.com" name="email" />
        </div>
        <hr>
        <div class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" placeholder="Enter Phone:" name="phone"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Address</label>
            <input placeholder="Enter address:" class="form-control" type="text" name="address"/>
        </div>
        <hr>
        <div class="form-group">
            <label>BirthDate</label>
            <input placeholder="Enter birthdate: like this XXXX-XX-XX" class="form-control"
                        type="date" name="birthDate"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Country</label>
            <input placeholder="Enter country:"
                   class="form-control" type="text" name="country"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Nationality</label>
            <input placeholder="Enter nationality:"
                   class="form-control" type="text" name="nationality"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Profile Description</label>
            <input placeholder="Enter profile description:"
                   class="form-control" type="text" name="profileDescription"/>
        </div>
        <hr>
        <div class="form-group">
            <label>Hobbies</label>
            <input placeholder="Enter Hobbies:"
                   class="form-control" type="text" name="hobby"/>
        </div>
        <hr>
        <div class="container" id="appendCourse">

            <div id="dynamicInputForCourse[0]">

                <div class="form-group">
                    <label>Course Name</label>
                    <input placeholder="Enter Course name:"
                           class="form-control" type="text" name="courseNameInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Institution</label>
                    <input placeholder="Enter Institution:"
                           class="form-control" type="text" name="institutionInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Begin Date</label>
                    <input placeholder="Enter Begin Date:"
                           class="form-control" type="date" name="courseBeginDateInputs[]"/>
                </div>

                <div class="form-group">
                    <label>End Date</label>
                    <input placeholder="Enter End Date:"
                           class="form-control" type="date" name="courseEndDateInputs[]"/>
                </div>

                <input type="button" class="button" value="+" onclick="addInputForCourse()"/>

            </div>

        </div>
        <hr>

        <div class="container" id="appendEducation">

            <div id="dynamicInputForEducation[0]">

                <div class="form-group">
                    <label>University</label>
                    <input placeholder="Enter University name:"
                           class="form-control" type="text" name="universityNameInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Degree</label>
                    <input placeholder="Enter Degree:"
                           class="form-control" type="text" name="degreeInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Begin Date</label>
                    <input placeholder="Enter Begin Date:"
                           class="form-control" type="date" name="educationBeginDateInputs[]"/>
                </div>

                <div class="form-group">
                    <label>End Date</label>
                    <input placeholder="Enter End Date:"
                           class="form-control" type="date" name="educationEndDateInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Located Place</label>
                    <input placeholder="Enter Located Place:"
                           class="form-control" type="text" name="locatedPlaceInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Education Description</label>
                    <input placeholder="Enter Education Description:"
                           class="form-control" type="text" name="educationDescriptionInputs[]"/>
                </div>

                <input type="button" class="button" value="+" onclick="addInputForEducation()"/>

            </div>

        </div>
        <hr>

        <div class="container" id="append">

            <div id="dynamicInput[0]">

        <div class="form-group">
            <label>Skill Name</label>
            <input placeholder="Enter skill name:"
                   class="form-control" type="text" name="skillNameInputs[]"/>
        </div>

        <div class="form-group">
            <label>Power</label>
            <input placeholder="Enter power: Please add interval: 0-10"
                   class="form-control" type="text" name="powerInputs[]"/>
        </div>

                <input type="button" class="button" value="+" onclick="addInput()"/>

            </div>

        </div>
        <hr>

        <div class="container" id="appendExtra">

            <div id="dynamicInputForExtra[0]">

                <div class="form-group">
                    <label>Function Title</label>
                    <input placeholder="Enter Function Title:"
                           class="form-control" type="text" name="functionTitleInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Employer</label>
                    <input placeholder="Enter Employer:"
                           class="form-control" type="text" name="employerInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Begin Date</label>
                    <input placeholder="Enter Begin Date:"
                           class="form-control" type="date" name="extraBeginDateInputs[]"/>
                </div>

                <div class="form-group">
                    <label>End Date</label>
                    <input placeholder="Enter End Date:"
                           class="form-control" type="date" name="extraEndDateInputs[]"/>
                </div>

                <div class="form-group">
                    <label>City</label>
                    <input placeholder="Enter City:"
                           class="form-control" type="text" name="cityInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <input placeholder="Enter Description:"
                           class="form-control" type="text" name="extraDescriptionInputs[]"/>
                </div>

                <input type="button" class="button" value="+" onclick="addInputForExtra()"/>

            </div>

        </div>
        <hr>
        <div class="container" id="appendLanguage">

            <div id="dynamicInputForLanguage[0]">

                <div class="form-group">
                    <label>Language</label>
                    <input placeholder="Enter Language:"
                           class="form-control" type="text" name="languageNameInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Level</label>
                    <input placeholder="Enter Level: Please add interval: 0-10"
                           class="form-control" type="text" name="languageLevelInputs[]"/>
                </div>

                <input type="button" class="button" value="+" onclick="addInputForLanguage()"/>

            </div>
        </div>
        <hr>
        <div class="container" id="appendLink">

            <div id="dynamicInputForLink[0]">

                <div class="form-group">
                    <label>Social Link Label</label>
                    <input placeholder="Enter Social Link Label:"
                           class="form-control" type="text" name="linkLabelInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Link</label>
                    <input placeholder="Enter Link:"
                           class="form-control" type="text" name="linkInputs[]"/>
                </div>

                <input type="button" class="button" value="+" onclick="addInputForLink()"/>

            </div>
        </div>

        <hr>
        <div class="container" id="appendReference">

            <div id="dynamicInputForReference[0]">

                <div class="form-group">
                    <label>Referent's Full Name</label>
                    <input placeholder="Enter Referent's Full Name:"
                           class="form-control" type="text" name="referentNameInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Company</label>
                    <input placeholder="Enter Company:"
                           class="form-control" type="text" name="companyInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Phone</label>
                    <input placeholder="Enter Phone:"
                           class="form-control" type="text" name="phoneInputs[]"/>
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <input placeholder="Enter Email:"
                           class="form-control" type="text" name="emailInputs[]"/>
                </div>


                <input type="button" class="button" value="+" onclick="addInputForReference()"/>

            </div>
        </div>

        <hr>
        <div class="container" id="appendEmployment">

            <div id="dynamicEmploymentInput[0]">

        <div class="form-group">
            <label>Employment History Header</label>
            <input placeholder="Enter Employment History Header:"
                   class="form-control" type="text" name="employmentHistoryHeaderInputs[]"/>
        </div>

        <div class="form-group">
            <label>Employment History Begin Date</label>
            <input placeholder="Enter Employment History Begin Date:"
                   class="form-control" type="date" name="employmentHistoryBeginDateInputs[]"/>
        </div>

        <div class="form-group">
            <label>Employment History End Date</label>
            <input placeholder="Enter Employment History End Date:"
                   class="form-control" type="date" name="employmentHistoryEndDateInputs[]"/>
        </div>

        <div class="form-group">
            <label>Employment History Job Description</label>
            <input placeholder="Enter Employment History Job Description:"
                   class="form-control" type="text" name="employmentHistoryJobDescriptionInputs[]"/>
        </div>

                <input type="button" class="button" value="+" onclick="addInputForEmployment()"/>

            </div>
        </div>
    </br>
        <button type="submit" class="btn btn-primary button">ADD</button>


    </form>
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
