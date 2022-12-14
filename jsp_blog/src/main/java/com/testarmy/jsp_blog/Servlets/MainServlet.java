package com.testarmy.jsp_blog.Servlets;

import com.testarmy.jsp_blog.Dao.Dao;
import com.testarmy.jsp_blog.Dao.Entities.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BlogPost> blogPost = Dao.loadAll(BlogPost.class);
        request.setAttribute("blogPost", blogPost);
        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
