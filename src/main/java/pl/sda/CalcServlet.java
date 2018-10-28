package pl.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String displayA = (req.getParameter("a"));
        String displayB = (req.getParameter("b"));

        int a = StringUtils.isNumeric(displayA)? Integer.parseInt(displayA) : 0;
        int b = StringUtils.isNumeric(displayB)? Integer.parseInt(displayB) : 0;

        PrintWriter writer = resp.getWriter();
        writer.println("<h1> Wynik: " + a + " + " + b + " = " + (a + b) + "</h1");
    }
}
