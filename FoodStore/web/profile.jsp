<%-- 
    Document   : profile
    Created on : Jul 5, 2024, 12:09:45 PM
    Author     : tungt
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Error_report.UpdatePassError"%>
<%@page import="Customer.CustomerDAO"%>
<%@page import="Error_report.UpdateGenError"%>
<%@page import="Customer.CustomerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/profile.css">
    </head>
    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Account settings
            </h4>
            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">
                    <!--phan tab--> 
                    <div class="col-md-3 pt-0">

                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list"
                               href="#account-general">Info</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#account-change-password">Change password</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#account-view-order">My Order</a>
                        </div>

                    </div>

                    <div class="col-md-9">
                        <div class="tab-content">
                            <!--tab general-->
                            <div class="tab-pane fade active show" id="account-general">

                                <hr class="border-light m-0">
                                <!--phan body cua general-->
                                <div class="card-body">
                                    <!--set dien thong tin mac dinh cho customer-->
                                    <%
                                        CustomerDTO user = (CustomerDTO) session.getAttribute("USER");
                                        if (user != null) {
                                    %>

                                    <!--set error tab General-->
                                    <%
                                        UpdateGenError errors = (UpdateGenError) request.getAttribute("ERROR");
                                        String cusNameLenError = "";
                                        String cusPhoneLenError = "";
                                        String cusPhoneNotMatch = "";

                                        if (errors != null) {
                                            cusNameLenError = errors.getCusNameLenError();
                                            cusPhoneLenError = errors.getCusPhoneLenError();
                                            cusPhoneNotMatch = errors.getCusPhoneNotMatch();
                                        }
                                    %>

                                    <form action="MainController" method="POST">
                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control mb-1" value="<%=user.getUserName()%>" disabled/>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Name</label>
                                            <input type="text" class="form-control" name="txtCusName" value="<%=user.getFullName()%>"/>
                                            <%
                                                if (cusNameLenError.length() > 0) {
                                            %>
                                            <font style="color: red"><%=cusNameLenError%></font>
                                            <%}%>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Phone Number</label>
                                            <input type="text" class="form-control mb-1" name="txtCusPhone" value="<%=user.getPhone()%>"/>
                                            <%
                                                if (cusPhoneNotMatch.length() > 0) {
                                            %>
                                            <font style="color: red"><%=cusPhoneNotMatch%></font>
                                            <br/>
                                            <%}%>

                                            <%
                                                if (cusPhoneLenError.length() > 0) {
                                            %>
                                            <font style="color: red"><%=cusPhoneLenError%></font>
                                            <%}%>
                                        </div>

                                        <%
                                            CustomerDAO cus = (CustomerDAO) request.getAttribute("SUCCESS");
                                            if (cus != null) {
                                        %>
                                        <font style="color: red">General Changed!</font>
                                        <%}%>

                                        <% }%>

                                        <div class="text-right mt-3">
                                            <input type="submit" class="btn btn-primary" name="btAction" value="Save General"/>&nbsp;
                                            <input type="reset" class="btn btn-default"  value="Cancel"/>
                                            <input type="submit" class="btn btn-default" name="btAction" value="Home"/>
                                        </div>

                                    </form>
                                </div>
                            </div>

                            <!--tab change password-->
                            <div class="tab-pane fade" id="account-change-password">
                                <div class="card-body pb-2">
                                    <%
                                        UpdatePassError errors1 = (UpdatePassError) request.getAttribute("ERROR1");
                                        String passwordLenError = "";
                                        String confirmNotMatch = "";
                                        String curPassNotMatch = "";
                                        if (errors1 != null) {
                                            curPassNotMatch = errors1.getCurPassNotMatch();
                                            passwordLenError = errors1.getPasswordLenError();
                                            confirmNotMatch = errors1.getConfirmNotMatch();
                                        }
                                    %>
                                    <form action="MainController" method="POST">
                                        <div class="form-group">
                                            <label class="form-label">Current password</label>
                                            <input type="password" name="txtCurPass" class="form-control">
                                            <%
                                                if (curPassNotMatch.length() > 0) {
                                            %>
                                            <font style="color: red"><%=curPassNotMatch%></font>
                                            <%}%>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">New password</label>
                                            <input type="password" name="txtNewPass" class="form-control">
                                            <%
                                                if (passwordLenError.length() > 0) {
                                            %>
                                            <font style="color: red"><%=passwordLenError%></font>
                                            <%}%>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Confirm new password</label>
                                            <input type="password" name="txtPassConfirm"class="form-control">
                                            <%
                                                if (confirmNotMatch.length() > 0) {
                                            %>
                                            <font style="color: red"><%=confirmNotMatch%></font>
                                            <%}%>
                                        </div>

                                        <%
                                            CustomerDAO cus1 = (CustomerDAO) request.getAttribute("SUCCESS1");
                                            if (cus1 != null) {
                                        %>
                                        <font style="color: red">Password Changed!</font>
                                        <%}%>
                                        <div class="text-right mt-3">
                                            <input type="submit" class="btn btn-primary" name="btAction" value="Save Password"/>&nbsp;
                                            <input type="reset" class="btn btn-default" value="Cancel"/>
                                            <input type="submit" class="btn btn-default" name="btAction" value="Home"/>
                                        </div>

                                    </form>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="account-view-order">           
                                <div class="product-display">
                                    
                                    <h2 class="message">Customer Orders</h2>

                                    <table class="product-display-table">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Date/Time</th>
                                                <th>Status</th>
                                                <th>Total Price</th>
                                                <th>Customer ID</th>
                                                <th>Address</th>
                                                <th>Phone</th>
                                                <th>Full Name</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="order" items="${requestScope.CUSORDERLIST}">
                                                <tr>
                                                    <td>${order.orderID}</td>
                                                    <td>${order.date_time}</td>
                                                    <td>${order.status}</td>
                                                    <td>${order.totalPrice}</td>
                                                    <td>${order.customerID}</td>
                                                    <td>${order.address}</td>
                                                    <td>${order.phone}</td>
                                                    <td>${order.fullName}</td>

                                                </tr>

                                                <tr>
                                                    <td colspan="8" >
                                                        <ul class="flex"> 
                                                            <c:forEach var="include" items="${order.includeList}">
                                                                <ul class="Product">   ${include.productName}: ${include.quantity} </ul>
                                                            </c:forEach>
                                                        </ul>

                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
