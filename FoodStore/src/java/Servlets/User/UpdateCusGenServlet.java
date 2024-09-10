/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

import Customer.CustomerDAO;
import Customer.CustomerDTO;
import Error_report.UpdateGenError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class UpdateCusGenServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String PROFILE_PAGE = "profile.jsp";
//    private final String UPDATE_PAGE = "update.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = PROFILE_PAGE;
        try {
            String cusName = request.getParameter("txtCusName");
            String cusPhone = request.getParameter("txtCusPhone");

            UpdateGenError errors = new UpdateGenError();
            boolean cusNameError = errors.checkCusName(cusName, 5, 50);
            boolean cusPhoneError = errors.checkPhone(cusPhone, 10);
            boolean isValid = cusNameError && cusPhoneError;

            if (isValid) {
                CustomerDAO dao = new CustomerDAO();
                HttpSession session = request.getSession();
                CustomerDTO cus = (CustomerDTO) session.getAttribute("USER");
                boolean isSuccess = dao.updateGen(cus.getUserName(), cusName, cusPhone);
                if (isSuccess) {
                    request.setAttribute("SUCCESS", dao);
                    session.setAttribute("USER", dao.getUser(cus.getUserName()));
                    url = PROFILE_PAGE;
                }
            } else if (!isValid) {
                request.setAttribute("ERROR", errors);
                url = PROFILE_PAGE;
            }
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
