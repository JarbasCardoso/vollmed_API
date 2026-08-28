package br.com.sistema.api.model.paciente;


import br.com.sistema.api.model.endereco.Endereco;
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
    @Embedded //Utilizando a classe que representa a tabela pricipal no BD
    private Endereco endereco;
    
}
