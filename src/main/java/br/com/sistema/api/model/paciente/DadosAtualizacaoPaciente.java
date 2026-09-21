package br.com.sistema.api.model.paciente;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoPaciente(

    Integer id,
    String nome,
    String email,
    String telefone,
    String CPF,
    DadosCadastroEndereco endereco


) {
    


    
}
