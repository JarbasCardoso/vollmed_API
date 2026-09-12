package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @PostMapping("/cadastro")
    public void cadastrarMedico(@RequestBody String dados) {
        System.out.println(dados);

    }

    // GET Request -> Response -> Ex: Tela home
    @GetMapping("/") // Aponta para localhost:8080/medico
    public String exibirHome() {
        return "a";
    }

}

// GET/POST Request -> Response -> Ex: Cadastrar . GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
// GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.
// DELETE
//CRUD

