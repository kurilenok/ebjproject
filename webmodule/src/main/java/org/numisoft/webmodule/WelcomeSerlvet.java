package org.numisoft.webmodule;

import org.numisoft.ejbmodule.User;
import org.numisoft.ejbmodule.UserDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by alku0116 on 22.06.2016.
 */

@WebServlet(value = "/jsp")
public class WelcomeSerlvet extends HttpServlet {

    @EJB
    UserDao userDao;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(">>WelcomeServlet<<");

        List<User> users = userDao.getAllUsers();

        userDao.persistUser(new User("Al", "Franza", "adt"));

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
        dispatcher.forward(request, response);

    }
}
