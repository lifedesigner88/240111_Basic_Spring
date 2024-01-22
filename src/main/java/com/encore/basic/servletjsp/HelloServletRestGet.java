package com.encore.basic.servletjsp;

import com.encore.basic.domain.Hello;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello-servlet-rest-get")
public class HelloServletRestGet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Hello hello = new Hello(
                "sejong",
                "ppasd@lkfj",
                "12341"
        );

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().print(hello.toJason(hello));


    }
}
