<%-- 
    Document   : home
    Created on : Jul 2, 2024, 9:50:24 PM
    Author     : LENOVO
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food Website</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css">

        
        <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"> 
<!--        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">-->
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Baloo+2:wght@400..800&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap');
        </style>
        <link rel="stylesheet" href="./css/menu.css">
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:set var="account" value="${sessionScope.USER}"/>
        <c:set var="foodList" value="${requestScope.FOOD_LIST}"/>
        <c:set var="drinkList" value="${requestScope.DRINK_LIST}"/>
        <c:set var="searchList" value="${requestScope.SEARCH_LIST}"/>
    <div class="home_pink_version">
            <header class="header_area header_pink">
                <!--header top starts-->
                <div class="header_top">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-lg-6 col-md-6">
                                <div class="social_icome">
                                    <ul>
                                        <li><a href="#"><i class="ion-android-mail"></i></a></li>
                                        <li><a href="https://www.instagram.com/odayco7thieunu/"><i class="ion-social-instagram"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="top_right text-right">
                                    <ul>
                                        <c:set var="admin" value="${sessionScope.ADMIN}"/>
                                        <c:if test="${not empty admin}">
                                            <li><a href="admin.jsp">Admin</a></li>
                                            <li><a href="MainController?btAction=Logout">Log Out</a></li>
                                        </c:if>
                                        <c:if test="${empty admin}">    
                                        <c:if test="${empty account}">
                                        <li class="login">
                                            <a href="login.jsp">Login</a>
                                        </li>
                                        <li class="sign up">
                                            <a href="register.jsp">Sign up</a>
                                        </li>
                                        </c:if>
                                        <c:if test="${not empty account}">
                                            <li>
                                                <a>${sessionScope.USER.userName}</a>
                                            </li>
                                        <li class="top_links">
                                            <a href="#">My Account<i class="ion-chevron-down"></i></a>
                                            <ul class="dropdown_links">
                                                <li><a href="MainController?btAction=PROFILE">My Profile</a></li>
                                                <li><a href="MainController?btAction=Logout">Log Out</a></li>
                                            </ul>
                                        </li>
                                        </c:if>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--header top ends-->
                
                <!--header middle starts-->
                <div class="header_middle">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-lg-5">
                                <div class="home_contact">
                                    <div class="contact_icone">
                                        <img src="images/icon/icon-phone.png" alt="">
                                    </div>
                                    <div class="contact_box">
                                        <p>Inquiry / Helpline : <a href="tel: 0964648530">(+84)9 6464 8530</a></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-lg-2 col-md-3 col-4">
                                <div class="main_logo">
                                    <a href="menu.html"><img src="images/logo/sm_lg.png" width="400" height="100" alt=""></a>
                                </div>
                            </div>
                            
                            <div class="col-lg-5 col-md-7 col-6">
                                <div class="middle_right">
                                    <div class="search_btn">
                                            <form action="#">
                                                <input type="text" name="txtSearch" value="${param.txtSearch}" placeholder="Search product..."/>
                                                <button type="submit" name="btAction" value="Search"><i class="ion-ios-search-strong"></i></button>
                                            </form>
                                    </div>
                                    
                                    <div class="cart_link">
                                        <a href="#"><i class="ion-android-cart"></i><span class="cart_text_quantity number-item">
                                            <c:if test="${empty sessionScope.AMOUNT}">0</c:if>
                                            <c:if test="${not empty sessionScope.AMOUNT}">${sessionScope.AMOUNT}</c:if></span><i class="ion-chevron-down"></i></a>
                                            <span class="cart_quantity">${sessionScope.QUANTITY}</span>
                                <!--mini cart-->
                                <div class="mini_cart">
                                    <div class="cart_close">
                                        <div class="cart_text">
                                            <h3>cart</h3>
                                        </div>
                                        <div class="mini_cart_close">
                                            <a href="javascript:void(0)"><i class="ion-android-close"></i></a>
                                        </div>
                                    </div>
                                    
                                    <div class="cart_items_container">
                                        <c:if test="${not empty cart}">
                                        <c:forEach var="item" items="${cart}">
                                            
                                    <div class="cart_item">
                                            <div class="cart_img">
                                                <a href="#"><img src="${item.image}" alt=""></a>
                                            </div>
                                            <div class="cart_info">
                                                <a href="#">${item.productName}</a>
                                                <span class="quantity">${item.quantity}</span>
                                                <span class="price_cart number-item" >${item.unitPrice * item.quantity}</span>
                                            </div>
                                            <div class="cart_remove">
                                                <a href="MainController?btAction=RemoveMini&proId=${item.productId}"><i class="ion-android-close"></i></a>
                                            </div>
                                    </div>
                                        </c:forEach>
                                    </c:if>
                                    
                                    <div class="cart_total">
                                        <span>Subtotal: </span>
                                        <span class="number-item"> <c:if test="${empty sessionScope.AMOUNT}">0</c:if>
                                            <c:if test="${not empty sessionScope.AMOUNT}">${sessionScope.AMOUNT}</c:if></span>
                                    </div>
                                    <div class="mini_cart_footer">
                                        <div class="cart_button view_cart">
                                            <a href="viewcart.jsp">View Cart</a>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
                                <!--mini cart ends-->
                            </div>
                        </div>
                    </div>
                </div>
               </div>
               </div>    
                <!--header middle ends-->
   
                <div class="header_bottom sticky-header">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-12">
                            <div class="main_menu_inner">
                                <div class="logo_sticky">
                                    <a href="#"><img src="images/logo/sm_lg.png" alt="logo"></a>
                                </div>
                                <div class="main_menu">
                                    <nav>
                                        <ul>
                                            <li><a href="#home" class="">Home</a></li>
                                            <li><a href="#menu">Menu</a></li>
                                            <li><a href="#team">Staffs</a></li>
                                            <li><a href="#about">About Us</a></li>
                                            <li><a href="#contact">Contact</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>   
            
             <!--header bottom ends-->   
            </header>
            
            <!--slider section starts-->
            <section class="home" id="home">
            <div class="slider_area slider_pink owl-carousel">
                <div class="single_slider" data-bgimg="slider/home_slider_image_1.PNG">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-12">
                                <div class="slider_content">
                                    <h1>.</h1>
                                    <span>.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="single_slider" data-bgimg="slider/home_slider_image_2.png">
                    <div class="row align-items-center">
                            <div class="col-12">
                                <div class="slider_content">
                                    <h1>.</h1>
                                    <span>.</span>
                                </div>
                            </div>
                        </div>
                </div>
                <div class="single_slider" data-bgimg="slider/home_slider_image_3.png">
                    <div class="row align-items-center">
                            <div class="col-12">
                                <div class="slider_content">
                                    <h1>.</h1>
                                    <span>.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--slider section ends-->
            
            <!-- product section area starts  -->
            <div  style="background-image: url(images/menu-bg.png);">
            <section class="product_section product_pink_section" id="menu">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="sec-title text-center mb-5">
                                <p class="sec-sub-title mb-3">our menu</p>
                                <h2 class="h2-title">wake up early, <span>eat fresh & healthy</span></h2>
                                <img src="images/title-shape.svg" alt="">
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="product_area">
                                <div class="product_tab_button">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item">
                                            <a href="#food" class="nav-link active" data-toggle="tab" role="tab" aria-controls="food" aria-selected="true">Food</a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#drink" class="nav-link" data-toggle="tab" role="tab" aria-controls="drink" aria-selected="false">Drink</a>
                                        </li>
                                        
                                    </ul>
                                </div>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="food" role="tabpanel">
                                    <div class="row">
                            <c:if test="${not empty searchList}">
                                <c:forEach var="search" items="${searchList}">
                                        <div class="col-md-4">
                                                <div class="box">
                                                    <span class="discount">HOT</span>
                                                    <div class="image">
                                                        <img src="${search.image}" alt="">
                                                        <div class="icons">
                                                            <c:if test="${empty account}">
                                                                <a href="login.jsp" class="cart-btn">Add to cart</a>
                                                            </c:if>
                                                            <c:if test="${not empty account}">   
                                                                <a href="MainController?btAction=Add&ProductId=${search.productID}#food" class="cart-btn">Add to cart</a>
                                                            </c:if> 
                                                        </div>
                                                    </div>
                                                    <div class="content">
                                                        <h2>${search.productName}</h2>
                                                        <div class="price number-item">${search.price}</div>
                                                    </div>
                                                </div>
                                            </div>
                                    </c:forEach>
                            </c:if>    
                            <c:if test="${empty searchList}">      
                                <c:if test="${not empty foodList}">
                                    <c:forEach var="food" items="${foodList}">
                                        <c:if test="${food.amount>0}">
                                        <div class="col-md-4">
                                                <div class="box">
                                                    <span class="discount">HOT</span>
                                                    <div class="image">
                                                        <img src="${food.image}" alt="">
                                                        <div class="icons">
                                                            <c:if test="${empty account}">
                                                                <a href="login.jsp" class="cart-btn">Add to cart</a>
                                                            </c:if>
                                                            <c:if test="${not empty account}">   
                                                                <a href="MainController?btAction=Add&ProductId=${food.productID}#food" class="cart-btn">Add to cart</a>
                                                            </c:if> 
                                                        </div>
                                                    </div>
                                                    <div class="content">
                                                        <h2>${food.productName}</h2>
                                                        <div class="price number-item">${food.price}</div>
                                                    </div>
                                                </div>
                                            </div>
                                                    </c:if>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    <div class="tab-pane fade" id="drink" role="tabpanel">
                                    <div class="row">
                                        
                                        <c:if test="${not empty drinkList}">
                                        <c:forEach var="drink" items="${drinkList}">
                                            <c:if test="${drink.amount>0}">
                                            <div class="col-md-4">
                                                <div class="box">
                                                    <span class="discount">HOT</span>
                                                    <div class="image">
                                                        <img src="${drink.image}" alt="">
                                                        <div class="icons">
                                                            <c:if test="${empty account}">
                                                                <a href="login.jsp" class="cart-btn">Add to cart</a>
                                                            </c:if>
                                                            <c:if test="${not empty account}">   
                                                                <a href="MainController?btAction=Add&ProductId=${drink.productID}#menu" class="cart-btn">Add to cart</a>
                                                            </c:if> 
                                                        </div>
                                                    </div>
                                                    <div class="content">
                                                        <h2>${drink.productName}</h2>
                                                        <div class="price number-item" >${drink.price}</div>   
                                                    </div>
                                                </div>
                                            </div>
                                                    </c:if>
                                        </c:forEach>
                                        
                                        </c:if>
                                    </div>
                                </div>
                                </c:if> 
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>
             
            <!-- product section area ends  -->
            
            
            <!--staff section start-->
            <section class="our-team section" id="team">
                <div class="sec-wp">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="sec-title text-center mb-5">
                                    <p class="sec-sub-title mb-3">Our Team</p>
                                    <h2 class="h2-title">Meet our Staffs</h2>
                                    <div class="sec-title-shape mb-4">
                                        <img src="images/title-shape.svg" alt="">
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>
                </div>
            
            
            <!--staff section starts-->
            
                <div class="facebook">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_1.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/Yokocute1711">@ _beo_chu17_</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_2.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/ngsthaow/">@ _thaobabiy</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_3.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/profile.php?id=100047954957981">@ __nmhiu</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_4.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/kimcuong.huynh.5011516?locale=fy_NL">@ the.dia.mond</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_5.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/ntpan1911/">@ ntp_an_04</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                                <div class="facebook__item set-bg" data-bgimg="images/Staff/Staff_6.jpg">
                                    <div class="facebook__text">
                                        <i class="ion-social-facebook"></i>
                                        <a href="https://www.facebook.com/dkhoa200412/">@ dkhoa_happy</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            </div>
            <!--staff section ends-->
            
            <!--about section starts-->
            <section class="about" id="about">
                <h1 class="heading"><span> About </span> Us </h1>
                <div class="row">
                    <div class="video-container">
                        <video src="images/video.mp4" loop autoplay muted></video>
                    </div>
                    
                    <div class="about-content">
                        <h3>Why choose us?</h3>
                        <p>We are a traditional street-side bread brand beloved in Ho Chi Minh City, we are a subsidiary
                            of the 1 Minute 30 Seconds brand, with 200 stores as of December 2022. We serve from 4:30 AM 
                            to 9:30 AM every day and have provided over 8 million meals to students and office workers 
                            annually. With a market potential of 25 million students and 45 million office workers, 
                            there is immense opportunity for growth and expansion.
                        </p>
                        <p>Our business model is based on the principles of fast service, offering high-value products that 
                            exceed the quality expectations for the price customers pay, and using ingredients that ensure 
                            food safety and hygiene. Thanks to this, everyone can enjoy a nutritious and affordable breakfast.
                        </p>
                        <a href="https://1phut30giay.vn/" class="btn">Learn more</a>
                    </div>
                </div>
            </section>
            <!--about section ends-->
            
            <!--contact section starts-->
            <section class="contact" id="contact">
                <h1 class="heading"><span> Your </span> Review</h1>
                <div class="row">
                    <form action="https://api.web3forms.com/submit" method="POST">
                        <input type="hidden" name="access_key" value="1d0bcbf9-1c36-4816-9719-e0e6f28c734d">
                        <input type="text" placeholder="Your Name" class="box">
                        <input type="email" placeholder="Your Email" class="box">
                        <textarea name="message" class="box" placeholder="Your Message" id="" cols="3" rows="10"></textarea>
                        <button type="submit" class="btn">Send message</button>
                    </form>
                    <div class="image">
                        <img src="images/banner/contact_2.jpg" alt="">
                    </div>
                </div>
            </section>
            <!--contact section ends-->
            
            
            <!-- footer section starts -->
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
                                            <li><a href="https://www.instagram.com/odayco7thieunu/"><i class="ion-social-instagram"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="widgets_container widget_menu">
                                    <img src="./images/logo/sm_lg.png" height="150px" width="350px">
                                    <p class="footer_menu pt-3">
                                        NO 30S THEN 30M.
                                    </p>
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
                    </div>
                </div>
            </footer>
            <!-- footer section ends -->
        </div>
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
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
