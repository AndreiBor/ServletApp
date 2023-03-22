package by.itacademy.servletapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    private String msg;

    @Override
    public void init() throws ServletException {
        msg = "Привет из FirstServlet";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setHeader("MYHEADER", "Hi");;

        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param1");
        String param3 = req.getParameter("param1");
        String param4 = req.getParameter("param1");
        String[] ages = req.getParameterValues("age");
        Map<String, String[]> parameterMap = req.getParameterMap();
        try (PrintWriter writer = resp.getWriter();){
            parameterMap.entrySet().
                    forEach(e -> writer.println(
                            "<p>key: " +e.getKey() + " value: " + Arrays.toString(e.getValue()) + "</p>"));
            writer.println("<h1>ages = " + ages[0] + "</h1>");
            writer.println("<h1>param1 = " + param1 + "</h1>");
            writer.println("<br/><a href=\"second\">Открыть Second Servlet</a>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>" + req.getParameter("name") + "</h2>");
        writer.println("<h2>" + req.getParameter("pwd") + "</h2>");
        writer.println("<h2>" + req.getParameter("pwd2") + "</h2>");
        writer.println("<form action=\"second\" method=\"POST\">");
        writer.println("Курс: <input type=\"text\" name=\"course\">");
        writer.println("<input type=\"submit\" value=\"отправить\">");
        writer.println("</form>");
        writer.close();

    }
}

















