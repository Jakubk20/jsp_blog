package com.testarmy.jsp_blog.Servlets;

import com.testarmy.jsp_blog.Dao.Dao;
import com.testarmy.jsp_blog.Dao.Entities.BlogPost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowPostServlet", value = "/show_post")
public class ShowPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        BlogPost blogPost = Dao.loadById(BlogPost.class, id);
        request.setAttribute("blogPost", blogPost);
        request.
                getRequestDispatcher("/WEB-INF/showPost.jsp").
                forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
