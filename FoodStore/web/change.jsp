<%-- 
    Document   : remove.jsp
    Created on : Jun 27, 2024, 2:24:56 PM
    Author     : LENOVO
--%>

<%@page import="Product.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="Product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REMOVE</title>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="css/khongbietdatten.css">
       
    </head>
    <body>
         <div class="container">
        <div class="product-display">
        <h1 class="message" >All Products</h1>
        
        <c:set var="proList" value="${sessionScope.PRO_LIST}"/>
        <c:if test="${not empty proList}">
        <table class="product-display-table" border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Status</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                
            
                <c:forEach var="pro" items="${proList}" >
                <form action="AdminServlet" method="POST">
                <tr>
                    <td style="text-align: center">${pro.productID}
                    <input type="hidden" name="txtProID" value="${pro.productID}"></td>
                    <td><input type="text" name="txtProName" value="${pro.productName}"</td>
                    <td>
                        <c:if test="${pro.status}">
                            <input type="checkbox" name="status" checked="1">
                        </c:if>
                        <c:if test="${not pro.status}">
                            <input type="checkbox" name="status"/>
                        </c:if>
                    </td>
                    <td><input type="number" name="price" value="${pro.price}"</td>
                    <td><input type="number" name="amount" value="${pro.amount}"</td>
                    <td><input type="submit" name="btAction" value="Remove" class="btn2" /><i class="fas fa-trash"></i> </td>
                    <td><input type="submit" name="btAction" value="Update" class="btn" /> <i class="fas fa-edit"></i> </td>
                    
                </tr>
                </form>
                </c:forEach>
                
            </tbody>
        </table>
        </c:if>
        <form>
        <input type="submit" name="btAction" value="Back" class="btn"/>
        </form>
        </div>
        </div>
    </body>
</html>
