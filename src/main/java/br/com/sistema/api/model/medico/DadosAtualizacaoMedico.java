package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoMedico (
      Integer id,
      String nome,
      String email,
      DadosCadastroEndereco endereco


) {


}
    

