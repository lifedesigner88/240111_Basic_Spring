package com.encore.basic.servletjsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet-jsp-post")
public class HelloServletJspPost extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        콘솔에 출력
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

//        응답 header
        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");


        PrintWriter out = res.getWriter();

//        응답 body
        out.print("ok");

    }


}
