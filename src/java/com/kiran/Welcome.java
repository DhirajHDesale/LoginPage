/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kiran;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhira
 */
public class Welcome extends HttpServlet {

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
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
           Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","KiranPatil@2001");
        
        PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=?");
        ps.setString(1,name);
     ps.setString(2,pass);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            HttpSession hs = request.getSession();
            hs.setAttribute("id", rs.getString("id"));
         hs.setAttribute("na", rs.getString("name"));
             hs.setAttribute("em", rs.getString("email"));
             hs.setAttribute("city", rs.getString("city"));
             hs.setAttribute("DOB", rs.getString("DOB"));
             out.println("<h1 style='color:green;'>Login Successfully</h1>");
            out.println("<p> <a href='Profile'>Profile</a></p>");
             out.println("<p> <a href='Logout.jsp'>Logout</a></p>");
              out.println("<p> <a href='index.html'>Home</a></p>");
        }
        else {
            
            request.getRequestDispatcher("Login.html").include(request, response);
            out.println("<h1 style='text-align:center; color:red'>email and password not matched</h1>");
            out.println("<h2 style='text-align:center;'>Or</h1>");
            out.println("<h1 style='text-align:center;'>New User Please Register Here <a href='Register.html'>Register</a></h1>");
        }
        } catch (ClassNotFoundException ex) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>"+ex+"</h1>");
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
             response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>"+ex+"</h1>");
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
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
