package br.com.sistema.api.model.paciente;
import br.com.sistema.api.model.endereco.Endereco;
import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Setter
@Getter
@Table(name="pacientes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String CPF;
    private Boolean ativo;
    @Embedded //Utilizando a classe que representa a tabela pricipal no BD
    private Endereco endereco;
    

    //Metodo Construtor recebendo o DTO DasdosCadastroMedico e conectando a um objeto Medico
    public Paciente(DadosCadastroPaciente dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco()); 
        
    }


    public void excluirLogico (){

        this.ativo = false;                 
        }

       public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
