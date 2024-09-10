<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='./css/login.css'>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
        </style>
    </head>
    <body>
        <div class="wrapper">
            <h1>WELCOME FEN</h1>
            <form action="MainController" method="POST">
                <div class="input-box">
                    <input type="text" required name="txtUserName"> 
                    <label>User Name</label>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="password" required name="txtPassword"> 
                    <label>Password</label>
                    <i class='bx bxs-lock-alt'></i>
                </div>
                <button type="submit" class="btn" name="btAction" value="Login">Login</button>
            </form>
            <div class="register-link">
                <p>Don't have an account? 
                    <a href="register.jsp">Sign Up</a></p>
            </div>
        </div>
    
    </body>
    
    <c:set var="err" value="${requestScope.ErMes}"/>
    <c:if test="${not empty err}">
        <div class="notification" id="errorNotification">
        <h2>Incorrect User Name or Password!</h2>
        <p>Please try again.</p>
    </div>
    </c:if>
</html>
