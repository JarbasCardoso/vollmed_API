package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

//DTO do cadastro das informações do médico. DTO é um objeto que transporta dados entre processos, neste caso, entre a camada de apresentação e a camada de serviço.
public record DadosCadastroMedico(
    String nome,
    String email,
    String telefone,
    String crm,
    Especialidade especialidade,
    DadosCadastroEndereco endereco

) {
    
}
