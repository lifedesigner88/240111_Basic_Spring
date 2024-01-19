package com.encore.basic.servletjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// controller가 아닌 WebServlet을 통해 라우팅
@WebServlet("/hello-servlet-jsp-get")
public class HelloServletJspGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("myData", "jsp test data");
        req.getRequestDispatcher("/WEB-INF/views/hello-jsp.jsp").forward(req, res);
    }

/*

    //    서비스 메서드는 서블릿에 들어오는 모든 요청(get, post, put, delete 등을 처리
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("myData", "jsp test data");
        req.getRequestDispatcher("/WEB-INF/views/hello-jsp.jsp").forward(req, res);

    }
*/

}
