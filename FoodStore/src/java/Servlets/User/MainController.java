/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

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

/**
 *
 * @author LENOVO
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String HOME_PAGE = "home.jsp";
    private final String REGISTER_SERVLET = "RegisterServlet";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String COOKIE_SERVLET = "CookieServlet";
    private final String HOME_SERVLET = "HomeServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String REMOVE_SERVLET = "RemoveServlet";
    private final String REMOVE_MINI_CART_SERVLET = "RemoveMiniCartServlet";
    private final String SEARCH_SERVLET = "SearchServlet";
    private final String UPDATE_SERVLET = "UpdateServlet";
    private final String UPDATE_CUS_PASS_SERVLET = "UpdateCusPassServlet";
    private final String UPDATE_CUS_GEN_SERVLET = "UpdateCusGenServlet";
    private final String UPDATE_CUS_INFO_SERVLET = "UpdateCusInfoServlet";
    private final String BUY_SERVLER = "BuyServlet";
    private final String PROFILE_SERVLET = "CustomerServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = HOME_PAGE;
        try {
            String buttonValue = request.getParameter("btAction");
            if(buttonValue==null){
                url = COOKIE_SERVLET;
            }else if(buttonValue.equals("Register")){
                url = REGISTER_SERVLET;
            }else if(buttonValue.equals("Login")){
                url = LOGIN_SERVLET;
            }else if(buttonValue.equals("Add")){
                url = ADD_TO_CART_SERVLET;
            }else if(buttonValue.equals("Logout")){
                url = LOGOUT_SERVLET;
            }else if(buttonValue.equals("Home")){
                url = HOME_SERVLET;
            }else if(buttonValue.equals("Remove")){
                url = REMOVE_SERVLET;
            }else if(buttonValue.equals("RemoveMini")){
                url = REMOVE_MINI_CART_SERVLET;
            }else if(buttonValue.equals("Search")){
                url = SEARCH_SERVLET;
            }else if(buttonValue.equals("Update")){
                url = UPDATE_SERVLET;
            }else if(buttonValue.equals("Save Password")){
                url = UPDATE_CUS_PASS_SERVLET;
            }else if(buttonValue.equals("Save General")){
                url = UPDATE_CUS_GEN_SERVLET;
            }else if(buttonValue.equals("Save Info")){
                url = UPDATE_CUS_INFO_SERVLET;
            }else if(buttonValue.equals("Buy")){
                url = BUY_SERVLER;
            }else if (buttonValue.equals("PROFILE")) {
                url = PROFILE_SERVLET;
            }
            
        }finally{
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
