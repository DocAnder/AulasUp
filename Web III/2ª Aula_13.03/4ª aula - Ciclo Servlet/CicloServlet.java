package br.edu.ifpr.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ciclo", value = "/ciclo")
public class CicloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("CHAMOU O INIT");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CHAMOU O SERVICE");
    }

    @Override
    public void destroy() {
        System.out.println("CHAMOU DESTROY");
    }
}
