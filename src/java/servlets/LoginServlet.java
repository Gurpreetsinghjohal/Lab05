/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import services.AccountService;

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession  session = request.getSession();
        String logout = request.getParameter("logout");
        
        if (logout!= null){
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successfully logged out.");
        }
        else if (session.getAttribute("username") != null){
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
            
        }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users;
        String invalid = "Please enter valid username and password";
        
        if (username != null && password != null){
            AccountService account = new AccountService();
            users = account.login(username, password);
            
            if(users != null){
                session.setAttribute("username", username);
                response.sendRedirect("home");
                return;
            }
        }
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("message", invalid);
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;

    }
    
}