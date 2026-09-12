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
}
