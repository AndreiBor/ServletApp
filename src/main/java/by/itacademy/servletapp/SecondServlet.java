package by.itacademy.servletapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (var writer = resp.getWriter()){
            writer.println("<h3>Привет из SecondServlet</h3>");
            writer.println("<br/><a href=\"first\">First Servlet</a>");
            writer.println("<br/><a href=\"first\">First Servlet</a>");
            writer.println("<br/><a href=\"first\">First Servlet</a>");
            writer.println("<br/><a href=\"Smth.html\">Go to login</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Smth.html");
        /* resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>" + req.getParameter("course") + "</h2>");
        writer.close();*/


    }
}
