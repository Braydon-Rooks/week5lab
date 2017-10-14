/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
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
        
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("list");
            request.setAttribute("logout", "You have logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
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
        String item = request.getParameter("item");
        HttpSession session = request.getSession();
        
        
        switch(action)
        {
            case "register":
                session.setAttribute("user",user);  
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "add":
                
                ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
                if(list == null)
                {
                    list=new ArrayList<>();
                }
                 list.add(item);
                session.setAttribute("list",list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "delete":
                int items = Integer.parseInt(request.getParameter("items"));
                 list =(ArrayList<String>) session.getAttribute("list");
                 
                 list.remove(items);
                  

                session.setAttribute("list",list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;

        }
    
         
        }
    
    
}

    



