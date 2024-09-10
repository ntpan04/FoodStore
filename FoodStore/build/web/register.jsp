<%-- 
    Document   : register
    Created on : Jun 9, 2024, 10:27:06 PM
    Author     : LENOVO
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Error_report.RegisterError"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
        </style>
        
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        
        <link rel='stylesheet' href='./css/register.css'>
        <title>SIGN UP</title>
    </head>
    <body>
        
        <%
            RegisterError errors = (RegisterError) request.getAttribute("ERROR");
            String accountExist = "";
            String cusNameLenError = "";
            String fullNameLenError = "";
            String passwordLenError = "";
            String phoneLenError = "";
            String phoneNotMatch = "";
            String confirmError = "";

            if (errors != null) {
                accountExist = errors.getAccountExist();
                cusNameLenError = errors.getCusNameLenError();
                fullNameLenError = errors.getFullNameLenError();
                passwordLenError = errors.getPasswordLenError();
                phoneLenError = errors.getPhoneLenError();
                phoneNotMatch = errors.getPhoneNotMatch();
                confirmError = errors.getConfirmError();
            }
        %>
        <div class="wrapper">

        <h1>Sign Up</h1>
        <form action="MainController" method="POST">
            
            <div class="input-box">
                <input type="text" required name="txtUserName"> 
                <label>User Name</label>
                <%
                        if (cusNameLenError.length() > 0) {
                    %>
                    <font style="color: red"><%=cusNameLenError%></font>
                    <%}%>

                    <%
                        if (accountExist.length() > 0) {
                    %>
                    <font style="color: red"><%=accountExist%></font>
                    <%}%>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
            <input type="password" required name="txtPassword"> 
                <label>Password</label>
                <%
                        if (passwordLenError.length() > 0) {
                    %>
                    <font style="color: red"><%=passwordLenError%></font>
                    <%}%>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="input-box">
            <input type="password" required name="txtConfirm"> 
                <label>Confirmed Password *</label>
                <%
                        if (confirmError.length() > 0) {
                    %>
                     <font style="color: red"><%=confirmError%></font>
                    <%}%>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="input-box">
                <input type="text" required name="txtFullName"> 
                <label>Full Name</label>
                <%
                        if (fullNameLenError.length() > 0) {
                    %>
                    <font style="color: red"><%=fullNameLenError%></font>
                <%}%>
                <i class='bx bxs-user'></i>
            </div> 
            
            <div class='input-box'>
                <input type="text" required name="phoneNumber"> 
                <label>Phone Number</label>
                <%
                        if (phoneNotMatch.length() > 0) {
                    %>
                    <font style="color: red"><%=phoneNotMatch%></font>
                    <%}%>
                    
                    <%
                        if (phoneLenError.length() > 0) {
                    %>
                    <font style="color: red"><%=phoneLenError%></font>
                    <%}%>
                <i class='bx bxs-phone' ></i>
            </div>
                
            <button type="submit" class="btn" name="btAction" value="Register">Sign Up</button>
            
            <div class="longin-link">
                <p>Already have an account? 
                <a href="login.jsp">Login</a></p>
            </div>
        </form>
        </div>
    </body>
<!--    
        <div class="noti">
                <span class="bx bx-bell"></span>
                <span class="msg">Notification: Register Successfully !</span>
                <span class="close-btn">
                    <span class="bx bx-x"></span>
                </span>
        </div>-->
<!--        <script>
            $('button').click(function(){
                $('.noti').removeClass("hide");
                $('.noti').addClass("show");
                $('.noti').addClass("showNoti");
                setTimeout(function(){
                    $('.noti').addClass("hide");
                    $('.noti').removeClass("show");
                },3000);
            });
            $('.close-btn').click(function(){
                $('.noti').addClass("hide");
                $('.noti').removeClass("show");
            });
        </script>-->

    <c:set var="success" value="${requestScope.SUCCESS}"/>
    <c:if test="${not empty success}">
        <div class="notification">
            <h2>Registration Successful!</h2>
        </div>
    </c:if>
        
    
    
</html>