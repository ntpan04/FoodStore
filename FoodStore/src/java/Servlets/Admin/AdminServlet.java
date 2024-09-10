/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String ADMIN_PAGE = "admin.jsp";
    private final String ADD_PRODUCT_PAGE = "add.jsp";
    private final String VIEW_ALL_PRODUCT_SERVLET = "ViewAllProServlet";
    private final String ADD_PRODUCT_SERVLET = "AddProductServlet";
    private final String REMOVE_PRODUCT_SERVLET = "RemoveProductServlet";
    private final String UPDATE_PRODUCT_SERVLET = "UpdateProductServlet";
    private final String UPDATE_ORDER_SERVLET = "UpdateStatusOrder";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "";
        try {
            String buttonValue = request.getParameter("btAction");
            
            if(buttonValue==null){
            }else if(buttonValue.equals("ADD")){
                url = ADD_PRODUCT_PAGE;
            }else if(buttonValue.equals("CHANGE")){
                url = VIEW_ALL_PRODUCT_SERVLET;
            }else if(buttonValue.equals("AddProduct")){
                url = ADD_PRODUCT_SERVLET;
            }else if(buttonValue.equals("Back")){
                url = ADMIN_PAGE;
            }else if(buttonValue.equals("Remove")){
                url = REMOVE_PRODUCT_SERVLET;
            }else if(buttonValue.equals("Update")){
                url = UPDATE_PRODUCT_SERVLET;
            }else if(buttonValue.equals("VIEWORDER")){
                url = "ViewOrderServlet";
            }else if(buttonValue.equals("UPDATEORDER")){
                url = UPDATE_ORDER_SERVLET;
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
