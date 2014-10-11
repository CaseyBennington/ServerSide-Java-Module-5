package user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserDB;

public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddress = request.getParameter("emailAddress");
        
        Boolean exists = false;
        exists = UserDB.emailExists(emailAddress);

        // TODO: add code that deletes the user that corresponds with the email address from the database
        UserDB.delete(UserDB.selectUser(emailAddress));

        String url = "/displayUsers";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}