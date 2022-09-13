package com.testarmy.jsp_blog;

import com.testarmy.jsp_blog.Dao.Dao;
import com.testarmy.jsp_blog.Dao.Entities.BlogPost;

public class Main {
    public static void main(String[] args) {
        BlogPost blog = new BlogPost("title", "description");
        Dao.save(blog);
    }
}
