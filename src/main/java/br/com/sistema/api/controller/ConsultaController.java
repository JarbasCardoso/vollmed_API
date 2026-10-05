package br.com.sistema.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sistema.api.model.consulta.Consulta;
import br.com.sistema.api.model.consulta.ConsultaRepository;
import br.com.sistema.api.model.consulta.DadosAgendamentoConsulta;
import br.com.sistema.api.model.medico.MedicoRepository;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;




@RestController 
@RequestMapping ("/consultas")

public class ConsultaController {
    @Autowired 
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired 
    private PacienteRepository pacienteRepository;
    //Post-
    @PostMapping
    @Transactional 
    public Consulta agendar(@RequestBody DadosAgendamentoConsulta dados) {
        var medico= medicoRepository.getReferenceById(dados.medicoId());
        var paciente= pacienteRepository.getReferenceById(dados.pacienteId());
       
       var consulta= new Consulta (dados, medico, paciente);

       return consultaRepository.save(consulta);

    }
    

}

/**
 * var significa que Ao tipo da variável ainda não fopi definida.Com isso , a var irá recber o tipo
 * do objeto.Var é uma palavra chave que esta disponível a a da versão 10 do java.
 * O compilador infere o tipo dessa variavel com base no valor atribuido a ela.
 * 
 * 
 */
