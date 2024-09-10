<%-- 
    Document   : admin
    Created on : Jul 4, 2024, 2:57:49 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="./css/style.css">

        <!-- custom js file link  -->
        <script src="./js/script.js" defer></script>
    </head>
    <body>
        <form action="AdminServlet" method="POST">
        <div class="container">
            <nav>
                <ul>
                    <li><a href="#" class="logo">
                            <img src="images/logo/sm_lg.png" alt="">
                            
                        </a></li>
                         <li><a href="#" class="logo">
                            
                            <span class="nav-item">DashBoard</span>
                        </a></li>
                    <li><a href="MainController?btAction=Home">
                            <i class="fas fa-home"></i>
                            <span class="nav-item">Home</span>
                        </a></li>
                    <li><a href="profile.jsp">
                            <i class="fas fa-user"></i>
                            <span class="nav-item">Profile</span>
                        </a></li>

                    <li><a href="#">
                            <i class="fas fa-chart-bar"></i>
                            <span class="nav-item">Analytics</span>
                        </a></li>
                    <li><a href="#">
                            <i class="fas fa-tasks"></i>
                            <span class="nav-item">Tasks</span>
                        </a></li>

                        
                    <li><a href="MainController?btAction=Logout" class="logout">
                            <i class="fas fa-sign-out-alt"></i>
                            <span class="nav-item">Log out</span>
                        </a></li>
                </ul>
            </nav>

            <section class="main">
                <div class="main-top">
                    <h1>Product</h1>
                    <i class="fas "></i>
                </div>
                <div class="main-skills">
                    <div class="card">
                        <i class="fas"></i>
                        <h3>Add Product</h3>
                        <p> Thêm sản phẩm </p>
                          <button type="submit" name="btAction" value="ADD"/>Get Started</button>
                    
                    </div>
                    <div class="card">
                        <i class="fas"></i>
                        <h3>Update Product</h3>
                        <p>Cập Nhật Sản Phẩm</p>
                <button type="submit" name="btAction" value="CHANGE"/>Get Started</button>
                    </div>
                    <div class="card">
                            <i class="fas"></i>
                            <h3>View Order</h3>
                            <p>Xem đơn hàng</p>
                            <button type="submit" name="btAction" value="VIEWORDER"/>Get Started</button>
                        </div>

                </div>
                </section>

        </div>
        </form>
    </body>
</html>
