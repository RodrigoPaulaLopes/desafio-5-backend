package br.com.banco.entities;

import br.com.banco.enums.TipoTransferencia;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transferencia")
    private LocalDate dataTransferencia;

    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoTransferencia tipo;


    @Column(name = "nome_operador_transacao")
    private String operadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;


}
