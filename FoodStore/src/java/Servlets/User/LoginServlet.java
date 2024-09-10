/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

import Admin.AdminDAO;
import Admin.AdminDTO;
import Customer.CustomerDAO;
import Customer.CustomerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    private final String MENU_PAGE = "menu.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String HOME_PAGE = "home.jsp";
    private final String LOGIN_PAGE = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = LOGIN_PAGE;
        String message = null;
        try {
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            if (userName.equals("#admin")){
                AdminDAO dao = new AdminDAO();
                AdminDTO admin = dao.authenticate(userName, password);
                if(admin!=null){
                    url = "MainController?btAction=Home";
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("ADMIN", admin);
//                    Cookie cUserName = new Cookie("USERNAME",userName);
//                    Cookie cPassword = new Cookie("PASSWORD",password);
//                    
//                    response.addCookie(cUserName);
//                    response.addCookie(cPassword);
                }else{
                    message = "Invalid user name or password!";
                    request.setAttribute("ErMes", message);
                } 
            } else{
                CustomerDAO dao = new CustomerDAO();
                boolean valid = dao.valid(userName, password);
                if(valid){  
                    CustomerDTO user = dao.authenticate(userName, password);
                    if(user!=null){
                        url = "MainController?btAction=Home";

                        HttpSession session = request.getSession();
                        session.setAttribute("USER", user);

                        Cookie cUserName = new Cookie("USERNAME",userName);
                        Cookie cPassword = new Cookie("PASSWORD",password);

                        response.addCookie(cUserName);
                        response.addCookie(cPassword);
                    }
                }else{
                        message = "Invalid user name or password!";
                        request.setAttribute("ErMes", message);
                    }
                }
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
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
