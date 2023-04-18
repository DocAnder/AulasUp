package com.example.atividade2;

import com.example.atividade2.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fieldUser = request.getParameter("field_user");
        String fieldPassword = request.getParameter("field_password");

        LoginService service = new LoginService();

        try {
            service.validateLogin(fieldUser, fieldPassword, request);
            response.sendRedirect("http://localhost:8080/login/pagina.jsp");

        }catch (Exception e){
            String mensagem = e.getMessage();
            response.sendRedirect("http://localhost:8080/login/index.jsp?msg=" + mensagem);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();

        resp.sendRedirect("http://localhost:8080/login/index.jsp");
    }
}
