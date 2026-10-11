package br.com.github.lucasmlg1.cadastro_pets.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter

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

    @Generated(event = EventType.INSERT)
    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;

}
