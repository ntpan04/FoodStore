<%@page import="Product.ProductDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="Product.ProductDTO" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="css/khongbietdatten.css">
        <style>
            .container {
                padding-top: 50px;
            }
        </style>
    </head>
    <body>
        <%
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> productList = dao.getProList();
            if (productList == null || productList.isEmpty()) {
        %>
        <div class="container">
            <div class="admin-product-form-container">
                <h3>List is empty!!!</h3>
            </div>
        </div>
        <%
        } else {
        %>
        <div class="container">
            <div class="admin-product-form-container">
                <form action="AdminServlet" method="POST">
                    <h3>Add Product:</h3>
                    <input type="text" name="productID" placeholder="ProductId" class="box" /><br/>
                    <input type="text" name="productName" placeholder="Product Name" class="box" /><br/>
                    <input type="number" name="Price" placeholder="Price" class="box" /><br>
                    <input type="number" name="Amount" placeholder="Amount" class="box" /><br>

                    <select name="cbProImage" class="box" onchange="checkOtherOption(this)">
                        <% for (ProductDTO pro : productList) {
                                String image = pro.getImage();
                                String name = pro.getProductName();
                        %>
                        <option value="<%= image%>"><%= name%></option>
                        <% } %>
                        <option value="other">Other</option>
                    </select><br/>

                    <div id="otherOption" style="display: none;">
                        <input type="text" name="otherImage" placeholder="Enter other value" class="box" />
                    </div>

                    <script>
                        function checkOtherOption(selectElement) {
                            var otherOption = document.getElementById("otherOption");

                            if (selectElement.value === "other") {
                                otherOption.style.display = "block";
                            } else {
                                otherOption.style.display = "none";
                            }
                        }
                    </script>


                    <input type="submit" name="btAction" value="AddProduct" class="btn" /><br>
                    <input type="submit" name="btAction" value="Back" class="btn" /><br>
                </form>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>