package com.encore.basic.servletjsp;

import com.encore.basic.domain.Hello;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// POST JSON을 받아서 콘솔에 출력.
@WebServlet("/hello-servlet-rest-post")
public class HelloServletRestPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
/*
        BufferedReader br = req.getReader();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) sb.append(line);
        // json 검사가 필요하다.
*/
        ObjectMapper obj = new ObjectMapper();
        Hello hello = obj.readValue(req.getReader(), Hello.class);

        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");

        System.out.println(hello);

        res.getWriter().print("OK");
    }
}

