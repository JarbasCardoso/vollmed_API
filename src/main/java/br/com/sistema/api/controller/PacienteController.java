package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente") //Define a url base para todos os metodos dessa classe
public class PacienteController { 
     //GET  Request -> Response -> Exemplo: localhost:8080/paciente/1

     @GetMapping("/") // Aponta para localhost:8080/paciente
     public String exibirHome() {
             return "a";
     };
     //GET/POST Request -> Response -> Exemplo: Cadastrar paciente .exibea tela de cadstro e o POST é chamado quando enviar é clicado
      
     //GET/PUT Request -> Response -> Exemplo: Alterar telefone . Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado
     //DELETE
     //CRUD 

}
