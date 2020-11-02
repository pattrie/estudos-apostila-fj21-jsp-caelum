package br.com.caelum.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "OiServlet",
        urlPatterns = {"/oi2"},
        initParams = {
                @WebInitParam(name = "param1", value = "value1"),
                @WebInitParam(name = "param2", value = "value2")}
)
public class OiServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h2>Exemplo com InitParam Servlet</h2>");

        out.print("Valor do parâmetro 1: " + getServletConfig().getInitParameter("param1"));
        out.print("</br>");
        out.print("Valor do parâmetro 2: " + getServletConfig().getInitParameter("param2"));

        out.close();
    }
}
