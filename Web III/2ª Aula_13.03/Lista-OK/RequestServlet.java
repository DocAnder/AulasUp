package com.example.hellodemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Requisicao")
public class RequestServlet extends HelloServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String a = req.getMethod();
        String protocol = req.getProtocol();
        String requestURI = req.getRequestURI();
        String remoteAddr = req.getRemoteAddr();

        //Necessário para imprimir como HTML
        PrintWriter out = resp.getWriter();

        out.println(a);
        out.println(protocol);
        out.println(requestURI);
        out.println(remoteAddr);
    }

}
