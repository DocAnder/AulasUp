package br.edu.ifpr.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "origem_nome", value = "/origem")
public class OrigemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recebo a requisicao e despacho ela para a Servlet mais adequada, chamando pelo nome ou valor.
        //Encaminho em conjunto também os dados da reqest e response
        req.getRequestDispatcher("destino_url").forward(req, resp);
    }
}
