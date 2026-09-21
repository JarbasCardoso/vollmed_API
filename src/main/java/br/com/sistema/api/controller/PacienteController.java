package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.paciente.DadosAtualizacaoPaciente;
import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("paciente") //Define a url base para todos os metodos dessa classe
public class PacienteController { 
     //GET  Request -> Response -> Exemplo: localhost:8080/paciente/1

     @Autowired 
     private PacienteRepository pacienteRepository; //Injetando a dependência do repositório de pacientes para que possamos interagir com o banco de dados.
     


    //Crud Basico de um sistema de cadastro de médicos, com métodos para cadastrar e listar médicos.
    @PostMapping("/cadastro") // Aponta para localhost:8080/medico/cadastro
    @Transactional
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));

    }

     @GetMapping("/listartodos") // Aponta para localhost:8080/medico
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();

        // GET/POST Request -> Response -> Ex: Cadastrar . GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
        // GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.
        // DELETE
        //CRUD
    }

    @DeleteMapping ("/deletar/{id}")
    @Transactional 
    public void excluir (@PathVariable Integer id){
        pacienteRepository.deleteById(id);
    }

        //DEL- Exclusão lógica
    @DeleteMapping ("/alterar-status/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id){
        
        var medico = pacienteRepository.getReferenceById(id); // O var está sendo utilizado para que assim que o id for chamado e acessado, eu pegue todos os atributos e guarde agora no objeto medico.
        medico.excluirLogico();
    }

       //put 
   @PutMapping("/atualizar")
   @Transactional 
   public void atualizar (@RequestBody DadosAtualizacaoPaciente dados){
    var paciente = pacienteRepository.getReferenceById(dados.id());
    paciente.atualizarInformacoes(dados);
       
    }

}
