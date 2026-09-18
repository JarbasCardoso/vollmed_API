package br.com.sistema.api.model.endereco;
import jakarta.persistence.Embeddable;
//Enereço completo (çogradouro, número, complemento, bairro, cidade, UF, CEP)
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //Classe que representa a tabela de endereço no BD
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String complemento;
    private String cidade;
    private String uf;
  

    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        
        
    }

    public void  atualizarInformacoes (DadosCadastroEndereco dados) {
     if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }
}
