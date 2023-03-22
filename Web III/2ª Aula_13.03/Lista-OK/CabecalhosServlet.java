package com.example.hellodemo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cabecalho")
public class CabecalhosServlet extends HelloServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String remoteAddressHeader = null;

        String host = req.getHeader("host");
        String userAgent = req.getHeader("user-agent");
        String acceptEncoding = req.getHeader("accept-encoding");
        String acceptLanguage = req.getHeader("accept-language");

        //Necessário para imprimir como HTML
        PrintWriter out = resp.getWriter();

        out.println(host);
        out.println(userAgent);
        out.println(acceptEncoding);
        out.println(acceptLanguage);
    }



}
