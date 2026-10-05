package br.com.sistema.api.model.consulta;


import java.time.LocalDateTime;

import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.Paciente;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table(name="consultas")
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

    @ManyToOne  // Relacionamento: Muitas consultas podem ter o mesmo paciente.
    @JoinColumn (name="paciente_id")
    
    private Paciente paciente;

    @ManyToOne // Relacionamento: Muitas consultas podem ter o mesmo médico.
    @JoinColumn (name="medico_id")
    private Medico medico;
    private LocalDateTime data;
    

    @Enumerated (EnumType.STRING)
    private Status status;  
    //tipo de status 
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


    /**
     *   //@Many ToOne
     * => Relacionamento: Muitas consultas podem ter o mesmo médico.
    //=> Sempre o primeiro termo é refertente a tabela atual, segundo termo da tabela de ref.
     * 
     */
   

}


