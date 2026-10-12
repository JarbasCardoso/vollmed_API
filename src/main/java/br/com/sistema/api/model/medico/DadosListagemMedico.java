package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

public record DadosListagemMedico(
        Integer id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        DadosCadastroEndereco endereco) {

        public DadosListagemMedico(Medico medico) {
            this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), new DadosCadastroEndereco(medico.getEndereco()));
        }       

}