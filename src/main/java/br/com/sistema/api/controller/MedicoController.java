package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("medico")
public class MedicoController { // Anotação que indica que a classe é um controlador REST e que os métodos dentro dela irão lidar com requisições HTTP.
    // GET Request -> Response -> Ex: Tela home

    @Autowired
    private MedicoRepository medicoRepository; // Injetando a dependência do repositório de médicos para que possamos interagir com o banco de dados.
    
    //Crud Basico de um sistema de cadastro de médicos, com métodos para cadastrar e listar médicos.
    @PostMapping("/cadastro") // Aponta para localhost:8080/medico/cadastro
    @Transactional
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));

    }

    @GetMapping("/listartodos") // Aponta para localhost:8080/medico
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();

        // GET/POST Request -> Response -> Ex: Cadastrar . GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
        // GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.
        // DELETE
        //CRUD
    }

    //Jarbas ama Sunny Lane <3


    //DEL Exclusão ral

    @DeleteMapping ("/deletar/{id}")
    @Transactional 
    public void excluir (@PathVariable Integer id){
        medicoRepository.deleteById(id);
    }
    //DEL- Exclusão lógica
    @DeleteMapping ("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id){
        
        var medico = medicoRepository.getReferenceById(id); // O var está sendo utilizado para que assim que o id for chamado e acessado, eu pegue todos os atributos e guarde agora no objeto medico.
        medico.excluirLogico();
    }
   //put 
   @PutMapping("/atualizar")
   @Transactional 
   public void atualizar (@RequestBody DadosAtualizacaoMedico dados){
    var medico = medicoRepository.getReferenceById(dados.id());
    medico.atualizarInformacoes(dados);
       
    }

    
}

// GET/POST Request -> Response -> Ex: Cadastrar . GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
// GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.
// DELETE
//CRUD

