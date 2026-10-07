package br.com.github.lucasmlg1.cadastro_pets.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data()
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPet tipoPet;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private SexoPet sexoPet;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "raca")
    private String raca;

    @Column(name = "idade")
    private Double idade;

    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private LocalDateTime dataCadastro;

    // endereco??
}
