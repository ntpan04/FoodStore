<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Orders</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="css/khongbietdatten.css">

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
            }
            .container {
                width: 80%;
                margin: auto;
                padding: 20px;
            }
            .product-display {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }
            .message {
                text-align: center;
                margin-bottom: 20px;
            }
            .product-display-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            .product-display-table th, .product-display-table td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }
            .product-display-table th {
                background-color: #f2f2f2;
            }
            .btn {
                padding: 8px 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                transition-duration: 0.4s;
            }
            .btn:hover {
                background-color: #45a049;
            }
            .btn2 {
                padding: 8px 16px;
                background-color: #f44336;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                transition-duration: 0.4s;
            }
            .btn2:hover {
                background-color: #da190b;
            }
            .product-display-table ul.flex {
                display: flex;
            }
            .product-display-table ul.Product {

                text-align: left;
                display: flex;
                padding-left: 10px;
            }


        </style>
        <link rel="stylesheet" href="css/khongbietdatten.css">
    </head>
    <body>
        <div class="container">
            <div class="product-display">
                <h2 class="message">Admin Orders</h2>

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
                            <th>Update</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${requestScope.ORDERLIST}">
                           <form action="AdminServlet" method="POST">
                            <tr>
                                <td> <input type="hidden" name="ORDERID" value="${order.orderID}"></td>
                                <td>${order.date_time}</td>
                                <td><input type="text" name="ORDERSTATUS" value="${order.status}"></td>
                                <td>${order.totalPrice}</td>
                                <td>${order.customerID}</td>
                                <td>${order.address}</td>
                                <td>${order.phone}</td>
                                <td>${order.fullName}</td>
                                <td><input type="submit" name="btAction" value="UPDATEORDER" class="btn" /> <i class="fas fa-edit"></i> </td>

                            </tr>

                            <tr>
                                <td colspan="9" >
                                    <ul class="flex"> 
                                        <c:forEach var="include" items="${order.includeList}">
                                            <ul class="Product">   ${include.productName}: ${include.quantity} </ul>
                                        </c:forEach>
                                    </ul>

                                </td>
                            </tr>
                           </form>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="admin.jsp"><input type="submit" name="btAction" value="Back" class="btn"/></a>
            </div>
        </div>
    </body>
</html>
