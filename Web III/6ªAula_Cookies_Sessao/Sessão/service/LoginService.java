package com.example.atividade2.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String user, String password, HttpServletRequest request) throws Exception {

        if(user.isEmpty() || user == null){
            throw  new Exception("Usuário Inválido!");
        }

        if(password.isEmpty() || password == null){
            throw  new Exception("Senha Inválida!");
        }

        if(user.equals("admin") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", user);

        }else {
            throw new Exception("Usuário ou senha incorretas!");
        }





    }

}
