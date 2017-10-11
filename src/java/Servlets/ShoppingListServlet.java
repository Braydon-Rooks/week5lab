/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 671978
 */
public class ShoppingListServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
      if(session.getAttribute("user")!=null)
        {
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
       getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String action = request.getParameter("action");
        ArrayList<String> list = new ArrayList<String>();
        
        HttpSession session = request.getSession();
        
        
        switch(action)
        {
            case "register":
                session.setAttribute("user",user);  
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
            case "add":
                
                session.setAttribute("list",list);
            case "delete":
            
                session.setAttribute("list",list);
            case "logout":
                
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    
         
        }
    
    
}

    



