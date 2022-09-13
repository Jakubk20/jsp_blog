package com.testarmy.jsp_blog.Servlets;

import com.testarmy.jsp_blog.Dao.Dao;
import com.testarmy.jsp_blog.Dao.Entities.BlogPost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SessionLoginServlet", value = "/login")
public class BlogLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.
                getServletContext().
                getRequestDispatcher("/WEB-INF/blogLogin.jsp").forward(request, response);
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("logged") == null) {
            out.println("blogLogin.jsp");
        } else {
            out.println("Witaj " + httpSession.getAttribute("logged"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            HttpSession httpSession = request.getSession();
            String password = request.getParameter("password");
            String login = request.getParameter("login");
            if (login.equals("1") && password.equals("2")) {
                httpSession.setAttribute("logged", login);
                List<BlogPost> blogPost = Dao.loadAll(BlogPost.class);
                PrintWriter writer = response.getWriter();
                request.setAttribute("blogPost", blogPost);
                request.getRequestDispatcher("/WEB-INF/mainLogged.jsp").forward(request, response);
            }
            else {
                request.getSession().setAttribute("message","Zły login lub hasło");
                response.sendRedirect("/login");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}