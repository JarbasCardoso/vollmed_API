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
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String UF;
    private String CEP;
}
