package com.example.exercicio1;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/processa_vaga")
public class ProcessaVagaServlet extends HttpServlet {

    private DateTimeFormatter formatter;

    @Override
    public void init() throws ServletException {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Linca os campos do HTML para obter as informações
        String fieldNome = request.getParameter("field_nome");
        System.out.println(fieldNome);

        String stringDate = request.getParameter("field_data_nascimento");
        LocalDate fieldDataNascimento = LocalDate.parse(stringDate, formatter);

        String fieldIdioma = request.getParameter("field_idioma");

        // Para pegar MULTIVALORES utilizar o getParameterValues
        String [] fieldHabilidades = request.getParameterValues("field_habilidades");

        //Salva as informações capturadas na requisição
        request.setAttribute("attr_nome", fieldNome);
        request.setAttribute("attr_data", fieldDataNascimento);
        request.setAttribute("attr_idioma", fieldIdioma);
        request.setAttribute("attr_habilidades", fieldHabilidades);


        if (fieldNome.equals("")){
            response.sendRedirect("http://localhost:8080/Exercicio1_war_exploded/index.jsp");
        }else{
            //Cria o objeto para fazer o redirecionamento e enviar a requisição, já com as informações
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("tela_confirmacao.jsp");
            requestDispatcher.forward(request, response);
        }



    }
}
