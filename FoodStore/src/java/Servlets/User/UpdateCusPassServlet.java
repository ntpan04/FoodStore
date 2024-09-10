/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.User;

import Customer.CustomerDAO;
import Customer.CustomerDTO;
import Error_report.UpdatePassError;
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
public class UpdateCusPassServlet extends HttpServlet {

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
    private final String UPDATE_PAGE = "update.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = PROFILE_PAGE;
        try {
            String curPass = request.getParameter("txtCurPass");
            String newPass = request.getParameter("txtNewPass");
            String confirm = request.getParameter("txtPassConfirm");

            UpdatePassError errors = new UpdatePassError();
            HttpSession session = request.getSession();
            CustomerDTO cus = (CustomerDTO) session.getAttribute("USER");
            boolean isMatch = cus.getPassword().equals(curPass);
            if (!isMatch) {
                errors.setCurPassNotMatch("Current pass is not match the registed one!");
            }

            boolean newPassError = errors.checkPassLen(newPass, 5, 15);
            boolean confirmError = errors.checkConfirm(confirm, newPass);
            boolean isValid = newPassError && confirmError && isMatch;

            if (isValid) {
                CustomerDAO dao = new CustomerDAO();
                boolean isSuccess = dao.updatePass(cus.getUserName(), newPass);
                if (isSuccess) {
                    request.setAttribute("SUCCESS1", dao);
                    request.setAttribute("PASSUP", dao);
                    session.setAttribute("USER", dao.getUser(cus.getUserName()));
                    url = UPDATE_PAGE;

                }
            } else if (!isValid) {
                request.setAttribute("ERROR1", errors);
                url = UPDATE_PAGE;
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
