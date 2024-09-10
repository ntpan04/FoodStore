<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View cart Page</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
        
    </style>
    <link rel="stylesheet" href="./css/viewcart.css">
</head>

<body>
<c:set var="cart" value="${sessionScope.CART}"/>
<c:set var="product" value="${sessionScope.PRO_LIST}"/>
<c:set var="user" value="${sessionScope.USER}"/>
<div class="home_pink_version">
    <header class="header_area header_pink">
        
        <!--header starts-->
        <div class="header_top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="picture">
                            <img src="images/logo/sm_lg.png" width="250" height="350">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="top_right text-right">
                            <ul>
                                <li class="login">
                                    <a href="MainController?btAction=Home">Home</a>
                                </li>
                                <li class="top_links">
                                    <a href="#">My Account<i class="ion-chevron-down"></i></a>
                                    <ul class="dropdown_links">
                                        <li><a href="profile.jsp">My Profile</a></li>
                                        <li><a href="MainController?btAction=Logout">Log Out</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--header ends-->
        <!--cart starts-->
        <div class="pt-5 mt-5 container">
            <h2 class="font-weight-bold pt-0">Shopping Cart</h2>
            <hr class="first-hr">
        </div>
        <section id="cart-container" class="container my-5">
            <c:choose>
                <c:when test="${empty cart}">
                            <div class="empty-cart">
                                <img src="images/no_product.png" class="centered-img">
                                <p>Your cart is empty.</p>
                            </div>
                        </c:when>
                <c:otherwise>
                    <table width="100%">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                            <c:forEach var="item" items="${cart}">
                                <form action="MainController" method="GET">
                                <tr>
                                    <td><img src="<c:out value="${item.image}"/>" alt=""></td>
                                    <td>
                                        <h5><c:out value="${item.productName}"/></h5>
                                    </td>
                                    <td>
                                        <h5 class="number-item"><c:out value="${item.unitPrice}"/></h5>
                                    </td>
                                    <td>
                                        <input class="w-50 pl-1 form-input" type="number" min="1" name="quantity" value="${item.quantity}"/><br>
<!--                                        <input class="form-input" type="number" min="1" name="quantity" value="$"{item.quantity}" placeholder="Quantity"/>-->
                                        <input type="hidden" value="${item.productId}" name="proId"/>
                                        <button type="submit" name="btAction" value="Update" class="styled-button">Apply</button>
<!--                                        <input class="w-25 pl-1" name="quantity" min="1" value="" type="number">-->
<!--                                        <button><a href="MainController?btAction=Update&proId=$"{item.productId}">Apply</a></button>-->
                                    </td>
                                    <td>
                                        <h5 class="number-item"><c:out value="${item.unitPrice * item.quantity}"/></h5>
                                    </td>
                                    <td><a href="MainController?btAction=Remove&proId=${item.productId}"><i class="ion-ios-trash-outline enlarged-icon"</a></td>
                                    
                                </tr>
                                </form>
                            </c:forEach>
                        
                        </tbody>
                    </table>
                    
                    <c:if test="${not empty requestScope.INVALID_QUANTITY}">
                        <h3>Not enough products!</h3>
                        <h4>${requestScope.ProName} Left: ${requestScope.AMOUNT}</h4>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </section>

        <section id="cart-bottom" class="container">
            <form action="MainController" method="POST">
            <div class="row">
                <div class="infor col-lg-6 col-md-6 col-12 box">
                                <h5 class="title">Billing Address</h5>
                                <div class="input-box">
                                    <span>Full Name: </span>
                                    <input type="text" name="fullName" required>
                                </div>
                                <div class="input-box">
                                    <span>Phone: </span>
                                    <input type="number" name="phone" required>
                                </div>
                                <div class="input-box">
                                    <span>Address</span>
                                    <input type="text" name="address" placeholder="Number-Street-District" required>
                                </div>
                                <h5 class="title">Payment: Cash Only</h5>
                            </div>
                <div class="total col-lg-6 col-md-6 col-12">
                    <div>
                        <h5>CART TOTAL</h5>
                        <hr class="second-hr">
                            <div class="d-flex justify-content-between">
                                <h6>Total</h6>
                                <c:set var="subtotal" value="0" />
                                <c:forEach var="item" items="${cart}">
                                    <c:set var="subtotal" value="${subtotal + (item.unitPrice * item.quantity)}" />
                                </c:forEach>
                                <h6 class="number-item">${subtotal}</h6>
                            </div>
                            
                            
                            <div class="notification-box">
                                <c:set var="success" value="${requestScope.SUCCESS_BUY}"/>
                                <c:if test="${not empty success}">
                                    <h2>Buy Successful!</h2>
                                </c:if>  
                                <input type="hidden" name="total" value="${subtotal}">
                                <button type="submit" name="btAction" value="Buy" class="buy-now-button">Buy Now</button>
                            </div>      
                                <c:set var="success" value="${requestScope.SUCCESS_BUY}"/>
                                <c:if test="${not empty success}">
                                    <div class="notification-text">Thank you for your purchase!</div>
                                </c:if>
                            
                        <c:if test="${not empty cart}">    
                        </c:if>
                    </div>
                </div>
            </div>
                </form>
        </section>
        
        <!--cart ends-->
    </header>
    <footer class="footer_widgets footer_black">
        <div class="container">
            <div class="footer_top">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="widgets_container contact_us">
                            <h3>About 30 giây</h3>
                            <div class="footer_contact">
                                <p>Address : Lot 2a-7, D1 Street, Long Thanh My Ward, Thu Duc City, Ho Chi Minh City</p>
                                <p>Phone : <a href="tel:(+84)964648530">(+84)964648530</a></p>
                                <p>Email : bamuoigiayne@gmail.com</p>
                                <ul>
                                    <li><a href="#"><i class="ion-social-facebook"></i></a></li>
                                    <li><a href="#"><i class="ion-social-twitter"></i></a></li>
                                    <li><a href="#"><i class="ion-social-rss"></i></a></li>
                                    <li><a href="#"><i class="ion-social-googleplus"></i></a></li>
                                    <li><a href="#"><i class="ion-social-instagram"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="widgets_container widget_menu">
                            <img src="images/logo/sm_lg.png" height="150px" width="350px">
                            <p class="footer_menu pt-3">
                                NO 30S THEN 30M.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer_bottom">
                <div class="row">
                    <div class="col-12">
                        <div class="copyright_area">
                            <p>Copyright &copy; 2024 <a href="#">30 giây</a> All rights Reserved.</p>
                            <img src="images/icon/delivery.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </footer>
    
</div>
        
</body>


    <script>
            // Lấy tất cả các phần tử có class là "number-item"
            let numberItems = document.querySelectorAll('.number-item');
            // Duyệt qua tất cả các phần tử và định dạng số
            numberItems.forEach(function(item) {
            // Lấy giá trị số từ nội dung của phần tử
            let number = parseFloat(item.innerText);
            // Định dạng số với 3 chữ số thập phân
            let formattedNumber = number.toFixed(3);

            // Chèn thêm chữ sau số
            let finalText = formattedNumber + "đ";

            // Cập nhật nội dung của phần tử
            item.innerText = finalText;
            });
        </script>
        
</html>
