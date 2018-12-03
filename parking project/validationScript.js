function validateUsername(formName) {
    var username = document.forms[formName]["username"].value;
    if (username == "") {
        writeError("The username cannot be empty!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
}

function validateEmail(formName) {
    var email = document.forms[formName]["email"].value;
    var re = /^([\w\._]+)@\w+(\.\w+)$/
    var result = re.test(email);
    if (!result) {
        writeError("Invalid Email!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
}

function validatePassword(formName) {
    var pass1 = document.forms[formName]["password"].value;
    var pass2 = document.forms[formName]["confirm_password"].value;
    if (!validatePasswordLength(formName)) return false;
    if (pass1 != pass2) {
        writeError("Passwords have to match!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
}

function writeError(errorMessage) {
    document.getElementById("error_label").innerHTML = errorMessage;
    document.getElementById("error_label").style.visibility = 'visible';
    document.getElementById("error_label").style.color = 'red';
}

function validateSignUp() {
    var formName = "signupform";
    return validateUsername(formName) && validateEmail(formName) && validatePassword(formName);
}

function validatePasswordLength(formName) {
    var pass = document.forms[formName]["password"].value;
    if (pass.length < 6) {
        writeError("The password has to be at least 6 characters long!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
}

function validateSignIn() {
    var formName = "signinform";
    return validateUsername(formName) && validatePasswordLength(formName);
}