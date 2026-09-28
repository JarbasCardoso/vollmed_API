package br.com.sistema.api.model.consulta;


import java.time.LocalDateTime;

import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;
@Entity 
@Table(name="medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id") 
public class Consulta {

    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    private String observacao;

    private Paciente paciente;
    private Medico medico;
    private LocalDateTime data;

    private Status status;  //tipo de status 
    // terceiro contrutor da classe consulta que recebe a conversão do DadosAgendamentoConsulta
    // O this.medico =new Medico() cria um objeto de médico vazio. Quando voce tentar inserir o 
    // id nesse noovo medico criado, o new médico  irá receber  e o BD saberá que aquele id já existe e trará as
    //informações com id daquele médico
    public Consulta (DadosAgendamentoConsulta dados ) {
        this.medico=new Medico ();
        this.medico.setId(dados.medicoId());
        this.paciente=new Paciente();
        this.paciente.setId(dados.pacienteId());
        this.status= dados.status();
        this.observacao= dados.observacao();
        this.data= dados.data();

    }

    //@Many ToOne=> Relacionamento: Muitas consultas podem ter o mesmo médico.

}


