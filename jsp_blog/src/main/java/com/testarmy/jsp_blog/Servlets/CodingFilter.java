package com.testarmy.jsp_blog.Servlets;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CodingFilter", value = "/*")
public class CodingFilter implements Filter {

    private final String encoding = "UTF-8";
    private final String content = "text/html";

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType(content);
        chain.doFilter(request, response);
    }
}
