package br.com.caelum.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contador")
public class Contador extends HttpServlet {
    private int contador = 0;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contador++;

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Contador agora é: " +contador);
        out.println("</body>");
        out.println("</html>");

    }
}
