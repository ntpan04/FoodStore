/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

import Cart.Cart;
import Cart.CartItem;
import Customer.CustomerDTO;
import Order.OrderDAO;
import Product.ProductDAO;
import Product.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class BuyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "viewcart.jsp";
        int totalAmount = 0;
        int totalQuantity = 0;
        try {

            HttpSession session = request.getSession();

            // Retrieve cart from session
//            List<CartItem> cart = (List<CartItem>) session.getAttribute("CART");
            Cart cart = (Cart) session.getAttribute("CART");
            // Retrieve user data from session
            CustomerDTO user = (CustomerDTO) session.getAttribute("USER");
            String userName = user.getUserName();

            // Retrieve order details from request parameters
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int total = Integer.parseInt(request.getParameter("total"));

            OrderDAO orderDao = new OrderDAO();
            String cusId = orderDao.getCusId(userName);
            ProductDAO proDao = new ProductDAO();
            List<ProductDTO> proList = proDao.getProList();
            boolean isValid = true;
            if (cart != null) {
                for (CartItem item : cart) {
                    int quantity = item.getQuantity();
                    String productId = item.getProductId();
                    ProductDTO pro = proDao.getProById(productId);
                    if (pro.getAmount() < quantity) {
                        request.setAttribute("INVALID_QUANTITY", "invalid");
                        request.setAttribute("AMOUNT", pro.getAmount());
                        isValid = false;
                        request.setAttribute("ProName", pro.getProductName());
                        break;
                    }
                }
                if (isValid) {

                    boolean orderSuccess = orderDao.addOrderTable(cusId, total, address, phone, fullName);
                    String orderId = orderDao.getOrderId(cusId);
                    for (CartItem cartItem : cart) {
                        int quantity = cartItem.getQuantity();
                        String productId = cartItem.getProductId();
                        ProductDTO pro = proDao.getProById(productId);
                        boolean includeSuccess = orderDao.addIncludeTable(quantity, orderId, productId);
                        int CurAmount = pro.getAmount();
                        int newAmount = CurAmount - quantity;
                        proDao.reduceProduct(newAmount, productId);
                    }
                    request.setAttribute("SUCCESS_BUY", "buy success");
                    cart.removeAll();
                    totalAmount = 0;
                    totalQuantity = 0;

                    session.setAttribute("QUANTITY", totalQuantity);
                    session.setAttribute("AMOUNT", totalAmount);
                    session.setAttribute("CART", cart);
                }

            }
//            if(session!=null){
//                Cart cart = (Cart)session.getAttribute("CART");
//                if(cart!=null){
//                    cart.removeAll();
//                    totalAmount = 0;
//                    totalQuantity = 0;
//                }

//            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
