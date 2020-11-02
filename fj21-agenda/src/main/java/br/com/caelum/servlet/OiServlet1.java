package br.com.caelum.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "OiServlet",
        urlPatterns = {"/oi1"},
        initParams = {
                @WebInitParam(name = "param1", value = "value1"),
                @WebInitParam(name = "param2", value = "value2")}
)
public class OiServlet1 extends HttpServlet {
    private String parametro1;
    private String parametro2;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.parametro1 = config.getInitParameter("param1");
        this.parametro2 = config.getInitParameter("param2");
    }
}
