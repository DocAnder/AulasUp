package com.example.exercicio1.controller;

import com.example.exercicio1.model.CandidatoVaga;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/candidato_vaga")
public class CandidatoVagaControler extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CandidatoVaga candidato = new CandidatoVaga();

        candidato.setNome(request.getParameter("field_nome"));

        candidato.setDataNascimento(request.getParameter("field_data_nascimento"));
        candidato.setIdioma(request.getParameter("field_idioma"));
        candidato.setHabilidades(request.getParameterValues("field_habilidades"));

        //Salva as informações capturadas na requisição
        request.setAttribute("attr_candidato", candidato);


        //Cria o objeto para fazer o redirecionamento e enviar a requisição, já com as informações
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tela_confirmacao.jsp");
        requestDispatcher.forward(request, response);




    }
}
