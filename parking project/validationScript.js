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

function validateLocation(formName) {
    var loc = document.forms[formName]["location"].value;
    if (loc == "") {
        writeError("The location cannot be empty!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
}

function validateAskingPrice(formName) {
    var askingPrice = parseInt(document.forms[formName]["asking_price"].value);
    if (isNaN(askingPrice)) {
        writeError("The asking price cannot be empty!");
        return false;
    }
    if (askingPrice < 0) {
        writeError("The asking price cannot be negative!");
        return false;
    }
    document.getElementById("error_label").style.visibility = 'hidden';
    return true;
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

function validateNoSQLInjection(formName) {

    var elements = document.forms[formName].elements;
    for (var i = 0, element; element = elements[i++];) {
        var str = element.value;
        if (str == null || str.search("'") != -1) {
            writeError("Please Don't Try SQL Injection...");
            return false;
        }
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
    return validateNoSQLInjection(formName) && validateUsername(formName) && validateEmail(formName) && validatePassword(formName);
}

function validateSignIn() {
    var formName = "signinform";
    return validateNoSQLInjection(formName) && validateUsername(formName) && validatePasswordLength(formName);
}

function validateOfferParkingSpot() {
    var formName = "parkingspotform";
    return validateNoSQLInjection(formName) && validateLocation(formName) && validateAskingPrice(formName);
}