/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

import Customer.CustomerDAO;
import Error_report.RegisterError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String REGISTER_PAGE = "register.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "login.jsp";
        try {
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            String fullName = request.getParameter("txtFullName");
            String phone = request.getParameter("phoneNumber");
            String confirm = request.getParameter("txtConfirm");
            
            RegisterError errors = new RegisterError();
            CustomerDAO dao = new CustomerDAO();
            boolean isExist = dao.checkAccountExist(userName);
            if (isExist) {
                errors.setAccountExist("Account is existed!");
            }

            boolean cusNameError = errors.checkCusNameLen(userName, 5, 15);
            boolean passwordError = errors.checkPasswordLen(password, 5, 15);
            boolean fullNameError = errors.checkFullNameLen(fullName, 5, 50);
            boolean phoneError = errors.checkPhone(phone, 10);
            boolean confirmError = errors.checkConfirm(password, confirm);
            
            boolean isValid = (cusNameError && passwordError && confirmError && fullNameError && phoneError && !isExist);

            if (isValid) {
                boolean isSuccess = dao.createNewAccount(userName, password, fullName, phone);
                if(isSuccess){
                    request.setAttribute("SUCCESS", dao);
                    url = REGISTER_PAGE;
                    
                }
            }else if (!isValid) {
                request.setAttribute("ERROR", errors);
                url = REGISTER_PAGE;
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
