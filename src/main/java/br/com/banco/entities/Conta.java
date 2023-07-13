package br.com.banco.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    private String numeroConta;

    private String nome_responsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias = new ArrayList<>();
}
