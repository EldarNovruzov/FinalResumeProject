var counter = 1;
var dynamicInput = [];


function addInput(){
    if (counter === 80)  {
        alert("You have reached the limit of adding " + counter + " inputs");
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.id = dynamicInput[counter];
        newdiv.innerHTML =
            "<div class=\"form-group\">\n" +
            "            Skill Name" + (counter + 1) + "\n" +
            "            <input placeholder=\"Enter skill name:\"\n" +
            "                   class=\"form-control\" type=\"text\" name=\"skillNameInputs[]\"/>\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"form-group\">\n" +
            "            Power" + (counter + 1) + "\n" +
            "            <input placeholder=\"Enter power:\"\n" +
            "                   class=\"form-control\" type=\"text\" name=\"powerInputs[]\"/>\n" +
            "        </div>" +
            "<input type='button' value='-' onClick='removeInput(" + dynamicInput[counter-1] + ");'/>";
        document.getElementById('append').appendChild(newdiv);
        counter++;
    }
}

function removeInput(id){
    var elem = document.getElementById(id);

    return elem.parentNode.removeChild(elem);
}



var counterForCourse = 1;
var dynamicInputForCourse = [];


function addInputForCourse(){
    if (counterForCourse === 80)  {
        alert("You have reached the limit of adding " + counterForCourse + " inputs");
    }
    else {
        var newdiv = document.createElement('div');
        newdiv.id = dynamicInputForCourse[counterForCourse];
        newdiv.innerHTML =
            "<div class=\"form-group\">\n" +
            "Course Name"+(counterForCourse+1)+"\n" +
            "                    <input placeholder=\"Enter Course name:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"courseNameInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Institution"+(counterForCourse+1)+"\n" +
            "                    <input placeholder=\"Enter Institution:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"institutionInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Begin Date"+(counterForCourse+1)+"\n" +
            "                    <input placeholder=\"Enter Begin Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"courseBeginDateInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    End Date"+(counterForCourse+1)+"\n" +
            "                    <input placeholder=\"Enter End Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"courseEndDateInputs[]\"/>\n" +
            "                </div>\n" +
            "<input type='button' value='-' onClick='removeInputForCourse(" + dynamicEmploymentInput[counterForCourse-1] + ");'/>";
        document.getElementById('appendCourse').appendChild(newdiv);
        counterForCourse++;
    }
}

function removeInputForCourse(id){
    var elem = document.getElementById(id);

    return elem.parentNode.removeChild(elem);
}


var cout = 1;
var dynamicEmploymentInput = [];


function addInputForEmployment(){
    if (cout === 80)  {
        alert("You have reached the limit of adding " + cout + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicEmploymentInput[cout];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n"+
            " Employment History Header"+(cout+1)+"\n"+
            "<input placeholder=\"Enter Employment History Header:\"\n"+
            "     class=\"form-control\" type=\"text\" name=\"employmentHistoryHeaderInputs[]\"/>\n"+
            "  </div>\n"+

            "\n" +
            "<div class=\"form-group\">\n"+
            " Employment History Begin Date"+(cout+1)+"\n"+
            "  <input placeholder=\"Enter Employment History Begin Date:\"\n"+
            "     class=\"form-control\" type=\"date\"\n"+
            "name=\"employmentHistoryBeginDateInputs[]\"/>\n"+
            "  </div>\n"+
            "\n"+
            "<div class=\"form-group\">\n"+
            "  Employment History End Date"+(cout+1)+"\n"+
            "  <input placeholder=\"Enter Employment History End Date:\"\n"+
            "     class=\"form-control\" type=\"date\"\n"+
            "name=\"employmentHistoryEndDateInputs[]\"/>\n"+
            "  </div>\n"+

            "<div class=\"form-group\">\n"+
            "  Employment History Job Description"+(cout+1)+"\n"+
            "  <input placeholder=\"Enter Employment History Job Description:\"\n"+
            "     class=\"form-control\" type=\"text\"\n"+
            "name=\"employmentHistoryJobDescriptionInputs[]\"/>\n"+
            "  </div>\n"+

            "<input type='button' value='-' onClick='removeEmploymentInput(" + dynamicEmploymentInput[cout-1] + ");'/>";
        document.getElementById('appendEmployment').appendChild(newDivEmployment);
        cout++;
    }
}

function removeEmploymentInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}




var coutEducation = 1;
var dynamicEducationInput = [];


function addInputForEducation(){
    if (coutEducation === 80)  {
        alert("You have reached the limit of adding " + coutEducation + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicEducationInput[coutEducation];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n" +
            "                    University"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter University name:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"universityNameInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Degree"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter Degree:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"degreeInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Begin Date"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter Begin Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"educationBeginDateInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    End Date"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter End Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"educationEndDateInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Located Place"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter Located Place:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"locatedPlaceInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Education Description"+(coutEducation+1)+"\n" +
            "                    <input placeholder=\"Enter Education Description:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"educationDescriptionInputs[]\"/>\n" +
            "                </div>"+

            "<input type='button' value='-' onClick='removeEducationInput(" + dynamicEducationInput[coutEducation-1] + ");'/>";
        document.getElementById('appendEducation').appendChild(newDivEmployment);
        coutEducation++;
    }
}

function removeEducationInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}



var coutExtra = 1;
var dynamicExtraInput = [];


function addInputForExtra(){
    if (coutExtra === 80)  {
        alert("You have reached the limit of adding " + coutExtra + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicExtraInput[coutExtra];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n" +
            "                    Function Title"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter Function Title:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"functionTitleInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Employer"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter Employer:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"employerInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Begin Date"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter Begin Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"extraBeginDateInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    End Date"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter End Date:\"\n" +
            "                           class=\"form-control\" type=\"date\" name=\"extraEndDateInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    City"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter City:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"cityInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Description"+(coutExtra+1)+"\n" +
            "                    <input placeholder=\"Enter Description:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"extraDescriptionInputs[]\"/>\n" +
            "                </div>"+

            "<input type='button' value='-' onClick='removeExtraInput(" + dynamicExtraInput[coutExtra-1] + ");'/>";
        document.getElementById('appendExtra').appendChild(newDivEmployment);
        coutExtra++;
    }
}

function removeExtraInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}



var coutLanguage = 1;
var dynamicLanguageInput = [];


function addInputForLanguage(){
    if (coutLanguage === 80)  {
        alert("You have reached the limit of adding " + coutLanguage + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicLanguageInput[coutLanguage];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n" +
            "                    Language"+(coutLanguage+1)+"\n" +
            "                    <input placeholder=\"Enter Language:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"languageNameInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Level"+(coutLanguage+1)+"\n" +
            "                    <input placeholder=\"Enter Level:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"languageLevelInputs[]\"/>\n" +
            "                </div>"+

            "<input type='button' value='-' onClick='removeLanguageInput(" + dynamicLanguageInput[coutLanguage-1] + ");'/>";
        document.getElementById('appendLanguage').appendChild(newDivEmployment);
        coutLanguage++;
    }
}

function removeLanguageInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}



var coutLink = 1;
var dynamicLinkInput = [];


function addInputForLink(){
    if (coutLink === 80)  {
        alert("You have reached the limit of adding " + coutLink + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicLinkInput[coutLink];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n" +
            "                    Social Link Label"+(coutLink+1)+"\n" +
            "                    <input placeholder=\"Enter Social Link Label:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"linkLabelInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Link"+(coutLink+1)+"\n" +
            "                    <input placeholder=\"Enter Link:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"linkInputs[]\"/>\n" +
            "                </div>"+

            "<input type='button' value='-' onClick='removeLinkInput(" + dynamicLinkInput[coutLink-1] + ");'/>";
        document.getElementById('appendLink').appendChild(newDivEmployment);
        coutLink++;
    }
}

function removeLinkInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}



var coutReference = 1;
var dynamicReferenceInput = [];


function addInputForReference(){
    if (coutReference === 80)  {
        alert("You have reached the limit of adding " + coutReference + " inputs");
    }
    else {
        var newDivEmployment = document.createElement('div');
        newDivEmployment.id = dynamicReferenceInput[coutReference];
        newDivEmployment.innerHTML =
            "<div class=\"form-group\">\n" +
            "                    Referent's Full Name"+(coutReference+1)+"\n" +
            "                    <input placeholder=\"Enter Referent's Full Name:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"referentNameInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Company"+(coutReference+1)+"\n" +
            "                    <input placeholder=\"Enter Company:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"companyInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Phone"+(coutReference+1)+"\n" +
            "                    <input placeholder=\"Enter Phone:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"phoneInputs[]\"/>\n" +
            "                </div>\n" +
            "\n" +
            "                <div class=\"form-group\">\n" +
            "                    Email"+(coutReference+1)+"\n" +
            "                    <input placeholder=\"Enter Email:\"\n" +
            "                           class=\"form-control\" type=\"text\" name=\"emailInputs[]\"/>\n" +
            "                </div>"+

            "<input type='button' value='-' onClick='removeReferenceInput(" + dynamicReferenceInput[coutReference-1] + ");'/>";
        document.getElementById('appendReference').appendChild(newDivEmployment);
        coutReference++;
    }
}

function removeReferenceInput(id){
    var elemEmployment = document.getElementById(id);

    return elemEmployment.parentNode.removeChild(elemEmployment);
}