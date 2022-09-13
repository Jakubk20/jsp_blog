package com.testarmy.jsp_blog.Servlets;

import com.mysql.cj.xdevapi.Statement;
import com.testarmy.jsp_blog.Dao.Dao;
import com.testarmy.jsp_blog.Dao.Entities.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/xd")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BlogPost> blogPost = Dao.loadAll(BlogPost.class);
      PrintWriter writer = response.getWriter();
        writer.println(blogPost);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
