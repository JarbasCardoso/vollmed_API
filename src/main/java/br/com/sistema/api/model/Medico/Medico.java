

package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id") 
public class Medico { 
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo= true;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //Utilizando a classe que representa a tabela pricipal no BD
    private Endereco endereco;

    //Cadastrar Doutora Lolla Melo

    //Metodo Construtor recebendo o DTO DasdosCadastroMedico e conectando a um objeto Medico
    public Medico(DadosCadastroMedico dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco()); 
        
    }

    //Metodo para alterar o status do campo ativo do medico, para exclusão lógica
    public void excluirLogico (){

        this.ativo = false;                 
        }

        //Metodo que checa se o nome, email ou endereço estão como null

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}