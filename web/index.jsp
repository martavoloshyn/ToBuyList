<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 2019-09-28
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToBuyList</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link href="${pageContext.request.contextPath}/webapp/css/index.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/webapp/js/index.js"></script>
</head>
<body>
<jsp:include page="/webapp/components/header.jsp"/>
<div class="container">
    <div class="row justify-content-center align-self-center">
        <button type="button" class="btn btn-dark" onclick="showSignInForm()">
            <div class="btn-text">SIGN IN</div>
        </button>
    </div>
    <div class="row justify-content-center align-self-center">
        <button type="button" class="btn btn-dark" onclick="showSignUpForm()">
            <div class="btn-text">SIGN UP</div>
        </button>
    </div>
    <div class="row justify-content-center align-self-center sign-in-form" id="sign-in-form" hidden>
        <form>
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                       placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="row justify-content-center align-self-center sign-up-form" id="sign-up-form" hidden>
        <form>
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp"
                       placeholder="Enter email">
                <small id="emailHelp2" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
                <small id="passwordHelp" class="form-text text-muted" hidden>Passwords are not equal.
                </small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Repeat password</label>
                <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
            </div>
            <button type="button" class="btn btn-primary" onclick="signUp()">Submit</button>
        </form>
    </div>
</div>
</body>
</html>
