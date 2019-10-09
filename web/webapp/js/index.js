function showSignInForm() {
    document.getElementById("sign-up-form").hidden = true;
    document.getElementById("sign-in-form").hidden = false;
}

function showSignUpForm() {
    document.getElementById("sign-in-form").hidden = true;
    document.getElementById("sign-up-form").hidden = false;
}

function signUp() {
    var password = document.getElementById("exampleInputPassword2").value;
    var repeatPassword = document.getElementById("exampleInputPassword3").value;
    document.getElementById("passwordHelp").hidden = true;
    if (password !== repeatPassword) {
        document.getElementById("passwordHelp").hidden = false;
    } else {
        document.getElementById("sign-up").submit();
    }
}

function checkFieldsOnInput() {
    var password = document.getElementById("exampleInputPassword2").value;
    var email = document.getElementById("exampleInputEmail2").value;
    var username = document.getElementById("exampleInputUsername").value;

    if(password===""||email===""||username===""){
        alert("Please, fill in all the fields");
    } else {
        signUp();
    }
}