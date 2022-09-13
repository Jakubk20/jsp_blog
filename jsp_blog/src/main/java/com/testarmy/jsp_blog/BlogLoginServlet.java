package com.testarmy.jsp_blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "blogLoginServlet", value = {"/login"})
public class BlogLoginServlet extends HttpServlet {
    private String html = "<html><body>" +
            "<h1>Logowanie</h1>" +
            "<form method='post'>" +
            "<input type='text' name='login' placeholder='Nazwa użytkownika'>" +
            "<input type='password' name='password' placeholder='Hasło'>" +
            "<input type='submit' value='Zaloguj'>" +
            " </form>" +
            "</body></html>";


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(html);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.equals("Admin") && password.equals("Terefere123")) {
            response.getWriter().println("<html><body>" +
                    "<h1>Witaj Admin!</h1>" +
                    "</body></html>");
        } else {
            response.getWriter().println("<html><body>" +
                    "<h1>Zły login lub hasło</h1>" +
                    "</body></html>");
        }

    }
}