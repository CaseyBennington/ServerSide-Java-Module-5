package user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserDB;

public class DisplayUserServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String emailAddress = request.getParameter("emailAddress");
        // TODO: get the User object
        User user = new User();
        UserDB.selectUser(emailAddress);

        HttpSession session = request.getSession();
        // TODO: set the User object as a session attribute
        session.setAttribute("user", user);

        String url = "/user.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}