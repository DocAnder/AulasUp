package com.example.cookielab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //CRIAR UM COOKIE
        Cookie cookie = new Cookie("usuario", "anderson");

        //Define o tempo de "vida" do cookie. Caso não definido, o cookie morre quando as habas forem fechadas
        cookie.setMaxAge(60*10); //em segundos
        //P/ matar o cookie basta definir o tempo para 0 ou -1;

        //add o cookie na resp para salvar no client
        resp.addCookie(cookie);

        resp.sendRedirect("http://localhost:8080/app/index.jsp");

        //CAPTURAR OS COOKIES DA REQUEST
        Cookie [] cookiesRquest = req.getCookies();


    }
}
