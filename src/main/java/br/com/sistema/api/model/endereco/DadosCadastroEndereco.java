package br.com.sistema.api.model.endereco;

public record DadosCadastroEndereco(
   String logradouro,
    String bairro,
    String cep,
    String complemento,
    String cidade,
    String uf

){
    public DadosCadastroEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(),
             endereco.getComplemento(), endereco.getCidade(), endereco.getUf());
    }



}
    

